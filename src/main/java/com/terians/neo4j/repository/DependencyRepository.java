package com.terians.neo4j.repository;

import com.terians.neo4j.model.*;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by stromero on 1/4/2015.
 */
@Repository
public interface DependencyRepository extends GraphRepository<Dependency> {

    // Find all dependencies by Scan teriansId
    // @Cacheable("teriansCache")
    @Query("MATCH (d:Dependency) RETURN d")
    Set<Dependency> findAllDependencies();

    @Query("MATCH (d:Dependency {teriansId:{0}}) RETURN d")
    Dependency findDependency(String dependencyId);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:USED_BY_METHOD]->(m:Method) RETURN m")
    Set<Method> findAllMethods(String dependencyId);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:USED_BY_METHOD]->(m:Method {teriansId:{1}}) RETURN m")
    Method findMethod(String dependencyId, String methodIc);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:USED_BY_CLAZZ]->(c:Clazz) RETURN c")
    Set<Clazz> findAllClazzes(String dependencyId);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:USED_BY_CLAZZ]->(c:Clazz {teriansId:{1}}) RETURN c")
    Clazz findClazz(String dependencyId, String clazzId);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:HAS_VULN]->(v:Vulnerability) RETURN v")
    Set<Vulnerability> findAllVulnerabilities(String dependencyId);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:HAS_VULN]->(v:Vulnerability {teriansId:{1}}) RETURN v")
    Vulnerability findVulnerability(String dependencyId,
                                    String vulnerabilityId);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) RETURN i")
    Set<Issue> findAllIssues(String dependencyId);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {teriansId:{1}}) RETURN i")
    Issue findIssue(String dependencyId, String issueId);

}
