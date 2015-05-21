package com.terians.controller;

import com.terians.dto.*;
import com.terians.neo4j.service.DependencyService;
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
@RequestMapping("/api/v1/dependencies")
@Api(value = "dependencies", description = "Dependencies API")
public final class DependenciesRestController {

    @Autowired
    private DependencyService dependencyService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependencies", notes = "Returns all dependencies")
    public DependenciesDTO getDependencies() {

        return dependencyService.findAllDependencies();
    }

    @RequestMapping(value = "/{dependencyId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependency", notes = "Returns a dependency by dependencyId")
    public DependencyDTO getDependency(
            @PathVariable("dependencyId") String dependencyId) {

        return dependencyService.findDependency(dependencyId);
    }

    @RequestMapping(value = "/{dependencyId}/methods", method = RequestMethod.GET)
    @ApiOperation(value = "Get Methods", notes = "Returns all methods of a dependency by dependencyId")
    public MethodsDTO getMethods(
            @PathVariable("dependencyId") String dependencyId) {

        return dependencyService.findAllMethods(dependencyId);
    }

    @RequestMapping(value = "/{dependencyId}/methods/{methodId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Method", notes = "Returns a method of a dependency by dependencyId, methodId")
    public MethodDTO getMethod(
            @PathVariable("dependencyId") String dependencyId,
            @PathVariable("methodId") String methodId) {

        return dependencyService.findMethod(dependencyId, methodId);
    }

    @RequestMapping(value = "/{dependencyId}/clazzes", method = RequestMethod.GET)
    @ApiOperation(value = "Get Classes", notes = "Returns all classes of a dependency by dependencyId")
    public ClazzesDTO getClazzes(
            @PathVariable("dependencyId") String dependencyId) {

        return dependencyService.findAllClazzes(dependencyId);
    }

    @RequestMapping(value = "/{dependencyId}/clazzes/{clazzId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Class", notes = "Returns a class of a dependency by dependencyId, classId")
    public ClazzDTO getClazz(@PathVariable("dependencyId") String dependencyId,
                             @PathVariable("clazzId") String clazzId) {

        return dependencyService.findClazz(dependencyId, clazzId);
    }


    @RequestMapping(value = "/{dependencyId}/vulnerabilities", method = RequestMethod.GET)
    @ApiOperation(value = "Get Vulnerabilities", notes = "Returns all vulnerabilities of a dependency by dependencyId")
    public VulnerabilitiesDTO getVulnerabilities(
            @PathVariable("dependencyId") String dependencyId) {

        return dependencyService.findAllVulnerabilities(dependencyId);
    }

    @RequestMapping(value = "/{dependencyId}/vulnerabilities/{vulnerabilityId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Vulnerability", notes = "Returns a vulnerability of a dependency by dependencyId, vulnerabilityId")
    public VulnerabilityDTO getVulnerability(
            @PathVariable("dependencyId") String dependencyId,
            @PathVariable("vulnerabilityId") String vulnerabilityId) {

        return dependencyService.findVulnerability(dependencyId,
                vulnerabilityId);
    }

    @RequestMapping(value = "/{dependencyId}/issues", method = RequestMethod.GET)
    @ApiOperation(value = "Get Issues", notes = "Returns all issues of a dependency by dependencyId")
    public IssuesDTO getIssues(@PathVariable("dependencyId") String dependencyId) {

        return dependencyService.findAllIssues(dependencyId);
    }

    @RequestMapping(value = "/{dependencyId}/issues/{issueId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Issue", notes = "Returns an issue of a dependency by dependencyId, issueId")
    public IssueDTO getIssue(@PathVariable("dependencyId") String dependencyId,
                             @PathVariable("issueId") String issueId) {

        return dependencyService.findIssue(dependencyId, issueId);
    }
}
