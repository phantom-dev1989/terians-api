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
    public Set<Project> findAllProjects();

    @Query("MATCH (p:Project {teriansId:{0}}) RETURN p")
    public Project findProject(String projectId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan) RETURN s")
    public Set<Scan> findAllScans(String projectId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}}) RETURN s")
    public Scan findScan(String projectId, String scanId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_ISSUE]->(i:Issue) RETURN i")
    public Set<Issue> findAllIssues(String projectId, String scanId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_ISSUE]->(i:Issue "
            + "{teriansId:{2}}) RETURN i")
    public Issue findIssue(String projectId, String scanId, String issueId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->"
            + "(d:Dependency) RETURN d")
    public Set<Dependency> findAllDependencies(String projectId, String scanId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}}) RETURN d")
    public Dependency findDependency(String projectId, String scanId,
                                     String dependencyId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:USED_BY_METHOD]->(m:Method) RETURN m")
    public Set<Method> findAllDependencyMethods(String projectId,
                                                String scanId, String dependencyId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:USED_BY_METHOD]->(m:Method {teriansId:{3}}) RETURN m")
    public Method findDependencyMethod(String projectId, String scanId,
                                       String dependencyId, String methodId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:USED_BY_CLAZZ]->(c:Clazz) RETURN c")
    public Set<Clazz> findAllDependencyClazzes(String projectId, String scanId,
                                               String dependencyId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:USED_BY_CLAZZ]->(c:Clazz {teriansId:{3}}) RETURN c")
    public Clazz findDependencyClazz(String projectId, String scanId,
                                     String dependencyId, String clazzId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:HAS_VULN]->(v:Vulnerability) RETURN v")
    public Set<Vulnerability> findAllDependencyVulnerabilities(
            String projectId, String scanId, String dependencyId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:HAS_VULN]->(v:Vulnerability {teriansId:{3}}) RETURN v")
    public Vulnerability findDependencyVulnerability(String projectId,
                                                     String scanId, String dependencyId, String vulnerabilityId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:HAS_ISSUE]->(i:Issue) RETURN i")
    public Set<Issue> findAllDependencyIssues(String projectId, String scanId,
                                              String dependencyId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:HAS_ISSUE]->(i:Issue {teriansId:{3}}) RETURN i")
    public Issue findDependencyIssue(String projectId, String scanId,
                                     String dependencyId, String issueId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:RELATED_DEPENDENCIES]->(rd:Dependency) RETURN rd")
    public Set<Dependency> findAllRelatedDependencies(String projectId,
                                                      String scanId, String dependencyId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_DEPENDENCY]->(d:Dependency {teriansId:{2}})-[:RELATED_DEPENDENCIES]->(rd:Dependency {teriansId:{3}}) RETURN rd")
    public Dependency findRelatedDependency(String projectId, String scanId,
                                            String dependencyId, String relatedDependencyId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_PACKAGE]->"
            + "(p:Package) RETURN p")
    public Set<Package> findAllPackages(
            String projectId, String scanId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_PACKAGE]->(p:Package "
            + "{teriansId:{2}}) RETURN p")
    public Package findPackage(String projectId, String scanId, String packageId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_PACKAGE]->(p:Package "
            + "{teriansId:{2}})-[:HAS_CLAZZ]->(c:Clazz) RETURN c")
    public Set<Clazz> findAllClazzes(String projectId, String scanId,
                                     String packageId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_PACKAGE]->(p:Package "
            + "{teriansId:{2}})-[:HAS_CLAZZ]->(c:Clazz {teriansId:{3}}) RETURN c")
    public Clazz findClazz(String projectId, String scanId, String packageId,
                           String clazzId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_PACKAGE]->(p:Package "
            + "{teriansId:{2}})-[:HAS_CLAZZ]->(c:Clazz {teriansId:{3}})-[:HAS_METHOD]->(m:Method) RETURN m")
    public Set<Method> findAllMethods(String projectId, String scanId,
                                      String packageId, String clazzId);

    @Query("MATCH(p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan {teriansId:{1}})-[:HAS_PACKAGE]->(p:Package "
            + "{teriansId:{2}})-[:HAS_CLAZZ]->(c:Clazz {teriansId:{3}})-[:HAS_METHOD]->(m:Method {teriansId:{4}}) RETURN m")
    public Method findMethod(String projectId, String scanId, String packageId,
                             String clazzId, String methodId);

}
