package com.terians.neo4j.service;

import com.terians.dto.IssueDTO;
import com.terians.dto.IssuesDTO;

/**
 * Created by stromero on 1/4/2015.
 */
public interface IssueService {

    IssueDTO findIssue(String issueId);

    IssuesDTO findAllIssues();

}
