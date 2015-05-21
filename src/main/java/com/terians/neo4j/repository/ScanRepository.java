package com.terians.neo4j.repository;

import com.terians.neo4j.model.*;
import com.terians.neo4j.model.Package;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by stromero on 1/4/2015.
 */
@Repository
public interface ScanRepository extends GraphRepository<Scan> {

    @Query("MATCH (p:Project)-[:HAS_SCAN]->(:Scan {teriansId:{0}}) RETURN p")
    Project findProject(String scanId);

    // Find the latest Scan in a Project by date
    @Query("MATCH (s:Scan) RETURN s ORDER BY s.date DESC LIMIT 1")
    Scan findLatestScan();

    @Query("MATCH (s:Scan) RETURN s ORDER BY s.date ASC LIMIT 1")
    Scan findOldestScan();

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package)-[:HAS_CLAZZ]->(z:Clazz)-[:HAS_METHOD]->(m:Method)"
            + " RETURN count(m)")
    Integer findMethodCountByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package)-[:HAS_CLAZZ]->(z:Clazz) RETURN count(z)")
    Integer findClazzCountByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package) RETURN count(p)")
    Integer findPackageCountByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) RETURN count(i)")
    Integer findIssueCountByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {severity:\"Critical\"}) RETURN count(i)")
    Integer findIssueCriticalCountByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {severity:\"High\"}) RETURN count(i)")
    Integer findIssueHighCountByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {severity:\"Medium\"}) RETURN count(i)")
    Integer findIssueMediumCountByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {severity:\"Low\"}) RETURN count(i)")
    Integer findIssueLowCountByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {severity:\"Best Practices\"}) RETURN count(i)")
    Integer findIssueBestPracticeCountByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package) RETURN avg(toFloat(p.cyclomaticCom))")
    Integer findComplexityByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) RETURN sum(toFloat(i.techDebtMinutes))")
    Integer findTechDebtByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package) RETURN avg(toFloat(p.abstractness))")
    Integer findAbstractnessByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package) RETURN avg(toFloat(p.instability))")
    Integer findInstabilityByScan(String scanId);

    @Query("MATCH (s:Scan) RETURN s")
    Set<Scan> findAllScans();

    @Query("MATCH (s:Scan {teriansId:{0}}) RETURN s")
    Scan findScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) RETURN i")
    Set<Issue> findAllIssues(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {teriansId:{1}}) RETURN i")
    Issue findIssue(String scanId, String issueId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_DEPENDENCY]->(d:Dependency) RETURN d")
    Set<Dependency> findAllDependencies(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{1}}) RETURN d")
    Dependency findDependency(String scanId, String dependencyId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{1}})-[:USED_BY_METHOD]->(m:Method) RETURN m")
    Set<Method> findAllDependencyMethods(String scanId,
                                         String dependencyId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{1}})-[:USED_BY_METHOD]->(m:Method {teriansId:{2}}) RETURN m")
    Method findDependencyMethod(String scanId, String dependencyId,
                                String methodId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{1}})-[:USED_BY_CLAZZ]->(c:Clazz) RETURN c")
    Set<Clazz> findAllDependencyClazzes(String scanId,
                                        String dependencyId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{1}})-[:USED_BY_CLAZZ]->(c:Clazz {teriansId:{2}}) RETURN c")
    Clazz findDependencyClazz(String scanId, String dependencyId,
                              String clazzId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{1}})-[:HAS_VULN]->(v:Vulnerability) RETURN v")
    Set<Vulnerability> findAllDependencyVulnerabilities(String scanId,
                                                        String dependencyId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{1}})-[:HAS_VULN]->(v:Vulnerability {teriansId:{2}}) RETURN v")
    Vulnerability findDependencyVulnerability(String scanId,
                                              String dependencyId, String vulnerabilityId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{1}})-[:HAS_ISSUE]->(i:Issue) RETURN i")
    Set<Issue> findAllDependencyIssues(String scanId, String dependencyId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{1}})-[:HAS_ISSUE]->(i:Issue {teriansId:{2}}) RETURN i")
    Issue findDependencyIssue(String scanId, String dependencyId,
                              String issueId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]-> (p:Package) RETURN p")
    Set<Package> findAllPackages(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package {teriansId:{1}}) RETURN p")
    Package findPackage(String scanId, String packageId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package {teriansId:{1}})-[:HAS_CLAZZ]->(c:Clazz) RETURN c")
    Set<Clazz> findAllClazzes(String scanId, String packageId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package {teriansId:{1}})-[:HAS_CLAZZ]->(c:Clazz {teriansId:{2}}) RETURN c")
    Clazz findClazz(String scanId, String packageId, String clazzId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package {teriansId:{1}})-[:HAS_CLAZZ]->(c:Clazz {teriansId:{2}})-[:HAS_METHOD]->(m:Method) RETURN m")
    Set<Method> findAllMethods(String scanId, String packageId,
                               String clazzId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package {teriansId:{1}})-[:HAS_CLAZZ]->(c:Clazz {teriansId:{2}})-[:HAS_METHOD]->(m:Method {teriansId:{3}}) RETURN m")
    Method findMethod(String scanId, String packageId, String clazzId,
                      String methodId);

}
