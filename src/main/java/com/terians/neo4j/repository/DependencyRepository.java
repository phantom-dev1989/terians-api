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
    @Query("MATCH(s:Scan)-[:HAS_DEPENDENCY]->(d:Dependency) WHERE s.teriansId = {0} RETURN d")
    public Set<Dependency> findDependenciesByScan(String scanId);

    @Query("MATCH (d:Dependency) RETURN d")
    public Set<Dependency> findAllDependencies();

    @Query("MATCH (d:Dependency {teriansId:{0}}) RETURN d")
    public Dependency findDependency(String dependencyId);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:USED_BY_METHOD]->(m:Method) RETURN m")
    public Set<Method> findAllMethods(String dependencyId);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:USED_BY_METHOD]->(m:Method {teriansId:{1}}) RETURN m")
    public Method findMethod(String dependencyId, String methodIc);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:USED_BY_CLAZZ]->(c:Clazz) RETURN c")
    public Set<Clazz> findAllClazzes(String dependencyId);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:USED_BY_CLAZZ]->(c:Clazz {teriansId:{1}}) RETURN c")
    public Clazz findClazz(String dependencyId, String clazzId);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:HAS_VULN]->(v:Vulnerability) RETURN v")
    public Set<Vulnerability> findAllVulnerabilities(String dependencyId);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:HAS_VULN]->(v:Vulnerability {teriansId:{1}}) RETURN v")
    public Vulnerability findVulnerability(String dependencyId,
                                           String vulnerabilityId);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) RETURN i")
    public Set<Issue> findAllIssues(String dependencyId);

    @Query("MATCH (d:Dependency {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {teriansId:{1}}) RETURN i")
    public Issue findIssue(String dependencyId, String issueId);

}
