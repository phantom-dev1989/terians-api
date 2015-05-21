package com.terians.controller;

import com.terians.dto.*;
import com.terians.neo4j.service.ProjectService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stromero on 12/31/2014.
 */
@RestController
@RequestMapping("/api/v1/projects")
@Api(value = "projects", description = "Projects API")
public final class ProjectsRestController {

    private final ProjectService projectService;

    @Autowired
    public ProjectsRestController(ProjectService projectService) {

        this.projectService = projectService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get Projects", notes = "Returns all projects")
    public ProjectsDTO getProjects() {

        return projectService.findAllProjects();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Project", notes = "Returns a project by projectId or by scanId if byScan is set to \"true\"")
    public ProjectDTO getProject(@PathVariable("id") String id,
                                 @RequestParam(value = "byScan", required = false) String byScan) {

        return projectService.findProject(id, byScan);
    }

    @RequestMapping(value = "/{projectId}/scans", method = RequestMethod.GET)
    @ApiOperation(value = "Get Scans", notes = "Returns all scans of a project by projectId")
    public ScansDTO getScans(@PathVariable("projectId") String projectId) {

        return projectService.findAllScans(projectId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Scan", notes = "Returns a scan of a project by projectId, scanId")
    public ScanDTO getScan(@PathVariable("projectId") String projectId,
                           @PathVariable("scanId") String scanId) {

        return projectService.findScan(projectId, scanId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/issues", method = RequestMethod.GET)
    @ApiOperation(value = "Get Issues", notes = "Returns all issues of a scan within a project by "
            + "projectId, scanId")
    public IssuesDTO getIssues(@PathVariable("projectId") String projectId,
                               @PathVariable("scanId") String scanId) {

        return projectService.findAllIssues(projectId, scanId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/issues/{issueId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Issue", notes = "Returns an issue of a scan within a project by "
            + "projectId, scanId, issueId")
    public IssueDTO getIssue(@PathVariable("projectId") String projectId,
                             @PathVariable("scanId") String scanId,
                             @PathVariable("issueId") String issueId) {

        return projectService.findIssue(projectId, scanId, issueId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/dependencies", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependencies", notes = "Returns all dependencies of a scan within a project by "
            + "projectId, scanId")
    public DependenciesDTO getDependencies(
            @PathVariable("projectId") String projectId,
            @PathVariable("scanId") String scanId) {

        return projectService.findAllDependencies(projectId, scanId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/dependencies/{dependencyId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependency", notes = "Returns a dependency of a scan within a project by "
            + "projectId, scanId, dependencyId")
    public DependencyDTO getDependency(
            @PathVariable("projectId") String projectId,
            @PathVariable("scanId") String scanId,
            @PathVariable("dependencyId") String dependencyId) {

        return projectService.findDependeny(projectId, scanId, dependencyId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/dependencies/{dependencyId}/methods", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependency Methods", notes = "Returns all dependency methods of a scan within a project by "
            + "projectId, scanId, dependencyId")
    public MethodsDTO getMethods(@PathVariable("projectId") String projectId,
                                 @PathVariable("scanId") String scanId,
                                 @PathVariable("dependencyId") String dependencyId) {

        return projectService.findAllDependenyMethods(projectId, scanId,
                dependencyId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/dependencies/{dependencyId}/methods/{methodId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependency Method", notes = "Returns a dependency method of a scan within a project by "
            + "projectId, scanId, dependencyId, methodId")
    public MethodDTO getMethod(@PathVariable("projectId") String projectId,
                               @PathVariable("scanId") String scanId,
                               @PathVariable("dependencyId") String dependencyId,
                               @PathVariable("methodId") String methodId) {

        return projectService.findDependenyMethod(projectId, scanId,
                dependencyId, methodId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/dependencies/{dependencyId}/clazzes", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependency Classes", notes = "Returns all dependency classes of a scan within a project by "
            + "projectId, scanId, dependencyId")
    public ClazzesDTO getDependencyClazzes(
            @PathVariable("projectId") String projectId,
            @PathVariable("scanId") String scanId,
            @PathVariable("dependencyId") String dependencyId) {

        return projectService.findAllDependenyClazzes(projectId, scanId,
                dependencyId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/dependencies/{dependencyId}/clazzes/{clazzId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependency Class", notes = "Returns a dependency class of a scan within a project by "
            + "projectId, scanId, dependencyId, classId")
    public ClazzDTO getDependencyClazz(
            @PathVariable("projectId") String projectId,
            @PathVariable("scanId") String scanId,
            @PathVariable("dependencyId") String dependencyId,
            @PathVariable("clazzId") String clazzId) {

        return projectService.findDependenyClazz(projectId, scanId,
                dependencyId, clazzId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/dependencies/{dependencyId}/vulnerabilities", method = RequestMethod.GET)
    @ApiOperation(value = "Get Vulnerabilities", notes = "Returns all vulnerabilities of a dependency of a "
            + "scan within a project by projectId, scanId, dependencyId")
    public VulnerabilitiesDTO getVulnerabilities(
            @PathVariable("projectId") String projectId,
            @PathVariable("scanId") String scanId,
            @PathVariable("dependencyId") String dependencyId) {

        return projectService.findAllVulnerabilities(projectId, scanId,
                dependencyId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/dependencies/{dependencyId}/vulnerabilities/{vulnerabilityId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Vulnerability", notes = "Returns a vulnerability of a dependency of a "
            + "scan within a project by projectId, scanId, dependencyId, vulnerabilityId")
    public VulnerabilityDTO getVulnerability(
            @PathVariable("projectId") String projectId,
            @PathVariable("scanId") String scanId,
            @PathVariable("dependencyId") String dependencyId,
            @PathVariable("vulnerabilityId") String vulnerabilityId) {

        return projectService.findVulnerability(projectId, scanId,
                dependencyId, vulnerabilityId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/dependencies/{dependencyId}/issues", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependency Issues", notes = "Returns all issues of a dependency of a "
            + "scan within a project by projectId, scanId, dependencyId")
    public IssuesDTO getIssues(@PathVariable("projectId") String projectId,
                               @PathVariable("scanId") String scanId,
                               @PathVariable("dependencyId") String dependencyId) {

        return projectService.findAllDependencyIssues(projectId, scanId,
                dependencyId);

    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/dependencies/{dependencyId}/issues/{issueId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependency Issue", notes = "Returns an issue of a dependency of a "
            + "scan within a project by projectId, scanId, dependencyId, issueId")
    public IssueDTO getIssue(@PathVariable("projectId") String projectId,
                             @PathVariable("scanId") String scanId,
                             @PathVariable("dependencyId") String dependencyId,
                             @PathVariable("issueId") String issueId) {

        return projectService.findDependencyIssue(projectId, scanId,
                dependencyId, issueId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/packages", method = RequestMethod.GET)
    @ApiOperation(value = "Get Packages", notes = "Returns all packages of a "
            + "scan within a project by projectId, scanId")
    public PackagesDTO getPackages(@PathVariable("projectId") String projectId,
                                   @PathVariable("scanId") String scanId) {

        return projectService.findAllPackages(projectId, scanId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/packages/{packageId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Package", notes = "Returns a packages of a "
            + "scan within a project by projectId, scanId, packageId")
    public PackageDTO getPackage(@PathVariable("projectId") String projectId,
                                 @PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId) {

        return projectService.findPackage(projectId, scanId, packageId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/packages/{packageId}/clazzes", method = RequestMethod.GET)
    @ApiOperation(value = "Get Classes", notes = "Returns all classes of a packages of a "
            + "scan within a project by projectId, scanId, packageId")
    public ClazzesDTO getClazzes(@PathVariable("projectId") String projectId,
                                 @PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId) {

        return projectService.findAllClazzes(projectId, scanId, packageId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/packages/{packageId}/clazzes/{clazzId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Class", notes = "Returns a class of a packages of a "
            + "scan within a project by projectId, scanId, packageId, classId")
    public ClazzDTO getClazz(@PathVariable("projectId") String projectId,
                             @PathVariable("scanId") String scanId,
                             @PathVariable("packageId") String packageId,
                             @PathVariable("clazzId") String clazzId) {

        return projectService.findClazz(projectId, scanId, packageId, clazzId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/packages/{packageId}/clazzes/{clazzId}/methods", method = RequestMethod.GET)
    @ApiOperation(value = "Get Methods", notes = "Returns all methods a class of a packages of a "
            + "scan within a project by projectId, scanId, packageId, classId")
    public MethodsDTO getMethods(@PathVariable("projectId") String projectId,
                                 @PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId,
                                 @PathVariable("clazzId") String clazzId) {

        return projectService.findAllMethods(projectId, scanId, packageId,
                clazzId);
    }

    @RequestMapping(value = "/{projectId}/scans/{scanId}/packages/{packageId}/clazzes/{clazzId}/methods/{methodId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Method", notes = "Returns a method a class of a packages of a "
            + "scan within a project by projectId, scanId, packageId, classId, methodId ")
    public MethodDTO getMethod(@PathVariable("projectId") String projectId,
                               @PathVariable("scanId") String scanId,
                               @PathVariable("packageId") String packageId,
                               @PathVariable("clazzId") String clazzId,
                               @PathVariable("methodId") String methodId) {

        return projectService.findMethod(projectId, scanId, packageId, clazzId,
                methodId);
    }

}
