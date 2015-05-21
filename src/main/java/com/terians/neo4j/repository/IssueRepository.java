package com.terians.neo4j.repository;

import com.terians.neo4j.model.Issue;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by stromero on 1/4/2015.
 */
@Repository
public interface IssueRepository extends GraphRepository<Issue> {

    @Query("MATCH (i:Issue {teriansId:{0}}) RETURN i")
    Issue findIssue(String issueId);

    @Query("MATCH (i:Issue) RETURN i")
    Set<Issue> findAllIssues();

    // Queries for Critical Issues
    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {severity:\"Critical\"}) RETURN i")
    Set<Issue> findAllCriticalIssuesByScan(String scanId);

    // Queries for High Issues
    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {severity:\"High\"}) RETURN i")
    Set<Issue> findAllHighIssuesByScan(String scanId);


    // Queries for Medium Issues
    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {severity:\"Medium\"}) RETURN i")
    Set<Issue> findAllMediumIssuesByScan(String scanId);


    // Queries for Low Issues
    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {severity:\"Low\"}) RETURN i")
    Set<Issue> findAllLowIssuesByScan(String scanId);


    // Queries for Best Practices Issues
    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {severity:\"Best Practices\"}) RETURN i")
    Set<Issue> findAllBestPracticesIssuesByScan(String scanId);

}
