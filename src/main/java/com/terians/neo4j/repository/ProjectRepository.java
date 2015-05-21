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
public interface ProjectRepository extends GraphRepository<Project> {

    @Query("MATCH (p:Project) RETURN p")
    Set<Project> findAllProjects();

    @Query("MATCH (p:Project {teriansId:{0}}) RETURN p")
    Project findProject(String projectId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan) RETURN s")
    Set<Scan> findAllScans(String projectId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}}) RETURN s")
    Scan findScan(String projectId, String scanId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_ISSUE]->(i:Issue) RETURN i")
    Set<Issue> findAllIssues(String projectId, String scanId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_ISSUE]->(i:Issue "
            + "{teriansId:{2}}) RETURN i")
    Issue findIssue(String projectId, String scanId, String issueId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->"
            + "(d:Dependency) RETURN d")
    Set<Dependency> findAllDependencies(String projectId, String scanId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}}) RETURN d")
    Dependency findDependency(String projectId, String scanId,
                              String dependencyId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:USED_BY_METHOD]->(m:Method) RETURN m")
    Set<Method> findAllDependencyMethods(String projectId,
                                         String scanId, String dependencyId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:USED_BY_METHOD]->(m:Method {teriansId:{3}}) RETURN m")
    Method findDependencyMethod(String projectId, String scanId,
                                String dependencyId, String methodId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:USED_BY_CLAZZ]->(c:Clazz) RETURN c")
    Set<Clazz> findAllDependencyClazzes(String projectId, String scanId,
                                        String dependencyId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:USED_BY_CLAZZ]->(c:Clazz {teriansId:{3}}) RETURN c")
    Clazz findDependencyClazz(String projectId, String scanId,
                              String dependencyId, String clazzId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:HAS_VULN]->(v:Vulnerability) RETURN v")
    Set<Vulnerability> findAllDependencyVulnerabilities(
            String projectId, String scanId, String dependencyId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:HAS_VULN]->(v:Vulnerability {teriansId:{3}}) RETURN v")
    Vulnerability findDependencyVulnerability(String projectId,
                                              String scanId, String dependencyId, String vulnerabilityId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:HAS_ISSUE]->(i:Issue) RETURN i")
    Set<Issue> findAllDependencyIssues(String projectId, String scanId,
                                       String dependencyId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:HAS_ISSUE]->(i:Issue {teriansId:{3}}) RETURN i")
    Issue findDependencyIssue(String projectId, String scanId,
                              String dependencyId, String issueId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_PACKAGE]->"
            + "(p:Package) RETURN p")
    Set<Package> findAllPackages(
            String projectId, String scanId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_PACKAGE]->(p:Package "
            + "{teriansId:{2}}) RETURN p")
    Package findPackage(String projectId, String scanId, String packageId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_PACKAGE]->(p:Package "
            + "{teriansId:{2}})-[:HAS_CLAZZ]->(c:Clazz) RETURN c")
    Set<Clazz> findAllClazzes(String projectId, String scanId,
                              String packageId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_PACKAGE]->(p:Package "
            + "{teriansId:{2}})-[:HAS_CLAZZ]->(c:Clazz {teriansId:{3}}) RETURN c")
    Clazz findClazz(String projectId, String scanId, String packageId,
                    String clazzId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_PACKAGE]->(p:Package "
            + "{teriansId:{2}})-[:HAS_CLAZZ]->(c:Clazz {teriansId:{3}})-[:HAS_METHOD]->(m:Method) RETURN m")
    Set<Method> findAllMethods(String projectId, String scanId,
                               String packageId, String clazzId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_PACKAGE]->(p:Package "
            + "{teriansId:{2}})-[:HAS_CLAZZ]->(c:Clazz {teriansId:{3}})-[:HAS_METHOD]->(m:Method {teriansId:{4}}) RETURN m")
    Method findMethod(String projectId, String scanId, String packageId,
                      String clazzId, String methodId);

}
