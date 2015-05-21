package com.terians.controller;

import com.terians.dto.IssueDTO;
import com.terians.dto.IssuesDTO;
import com.terians.neo4j.service.IssueService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stromero on 12/31/2014.
 */
@RestController
@RequestMapping("/api/v1/issues")
@Api(value = "issues", description = "Issues API")
public final class IssuesRestController {

    @Autowired
    private IssueService issueService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get Issues", notes = "Returns all issues")
    public IssuesDTO getIssues() {

        return issueService.findAllIssues();
    }

    @RequestMapping(value = "/{issueId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Issue", notes = "Returns an issue by issueId")
    public IssueDTO getIssue(@PathVariable("issueId") String issueId) {

        return issueService.findIssue(issueId);
    }
}
