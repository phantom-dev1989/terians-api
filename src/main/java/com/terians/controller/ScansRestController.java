package com.terians.controller;

import com.terians.dto.*;
import com.terians.neo4j.service.ScanService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stromero on 12/31/2014.
 */
@RestController
@RequestMapping("/api/v1/scans")
@Api(value = "scans", description = "Scans API")
public final class ScansRestController {

    private final ScanService scanService;

    @Autowired
    public ScansRestController(ScanService scanService) {

        this.scanService = scanService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get Scans", notes = "Returns all scans")
    public ScansDTO getScans() {

        return scanService.findAllScans();
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    @ApiOperation(value = "Get Scan by Date", notes = "Returns scan by date")
    public ScanDTO getScanByDate(@RequestParam(value = "scanned", required = true) String scanned) {

        return scanService.findScanByDate(scanned);

    }

    @RequestMapping(value = "/{scanId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Scan", notes = "Returns a scan by scanId")
    public ScanDTO getScan(@PathVariable("scanId") String scanId) {

        return scanService.findScan(scanId);
    }

    @RequestMapping(value = "/{scanId}/issues", method = RequestMethod.GET)
    @ApiOperation(value = "Get Issues", notes = "Returns all Issues of a scan by scanId")
    public IssuesDTO getIssues(@PathVariable("scanId") String scanId,
                               @RequestParam(value = "severity", required = false) String severity) {

        return scanService.findAllIssues(scanId, severity);
    }

    @RequestMapping(value = "/{scanId}/issues/{issueId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Issue", notes = "Returns an issue of a scan by scanId, issueId")
    public IssueDTO getIssue(@PathVariable("scanId") String scanId,
                             @PathVariable("issueId") String issueId) {

        return scanService.findIssue(scanId, issueId);
    }

    @RequestMapping(value = "/{scanId}/dependencies", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependencies", notes = "Returns all dependencies of a scan by scanId")
    public DependenciesDTO getDependencies(@PathVariable("scanId") String scanId) {

        return scanService.findAllDependencies(scanId);
    }

    @RequestMapping(value = "/{scanId}/dependencies/{dependencyId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependency", notes = "Returns a dependency of a scan by scanId, dependencyId")
    public DependencyDTO getDependency(@PathVariable("scanId") String scanId,
                                       @PathVariable("dependencyId") String dependencyId) {

        return scanService.findDependency(scanId, dependencyId);
    }

    @RequestMapping(value = "/{scanId}/dependencies/{dependencyId}/clazzes", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependency Classes", notes = "Returns all dependency classes of a scan by "
            + "scanId, dependencyId")
    public ClazzesDTO getDependencyClazzes(
            @PathVariable("scanId") String scanId,
            @PathVariable("dependencyId") String dependencyId) {

        return scanService.findAllDependenyClazzes(scanId, dependencyId);
    }

    @RequestMapping(value = "/{scanId}/dependencies/{dependencyId}/clazzes/{clazzId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependency Class", notes = "Returns a dependency class of a scan by "
            + "scanId, dependencyId, classId")
    public ClazzDTO getDependencyClazz(@PathVariable("scanId") String scanId,
                                       @PathVariable("dependencyId") String dependencyId,
                                       @PathVariable("clazzId") String clazzId) {

        return scanService.findDependenyClazz(scanId, dependencyId, clazzId);
    }

    @RequestMapping(value = "/{scanId}/dependencies/{dependencyId}/methods", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependency Methods", notes = "Returns all dependency methods of a scan by scanId, dependencyId")
    public MethodsDTO getMethods(@PathVariable("scanId") String scanId,
                                 @PathVariable("dependencyId") String dependencyId) {

        return scanService.findAllDependencyMethods(scanId, dependencyId);
    }

    @RequestMapping(value = "/{scanId}/dependencies/{dependencyId}/methods/{methodId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependency Method", notes = "Returns a dependency method of a scan by "
            + "scanId, dependencyId, methodId")
    public MethodDTO getMethod(@PathVariable("scanId") String scanId,
                               @PathVariable("dependencyId") String dependencyId,
                               @PathVariable("methodId") String methodId) {

        return scanService.findDependencyMethod(scanId, dependencyId, methodId);
    }

    @RequestMapping(value = "/{scanId}/dependencies/{dependencyId}/vulnerabilities", method = RequestMethod.GET)
    @ApiOperation(value = "Get Vulnerabilities", notes = "Returns all vulnerabilities of a dependency within a "
            + "scan by scanId, dependencyId")
    public VulnerabilitiesDTO getVulnerabilities(
            @PathVariable("scanId") String scanId,
            @PathVariable("dependencyId") String dependencyId) {

        return scanService.findAllVulnerabilities(scanId, dependencyId);
    }

    @RequestMapping(value = "/{scanId}/dependencies/{dependencyId}/vulnerabilities/{vulnerabilityId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Vulnerability", notes = "Returns a vulnerability of a dependency within a "
            + "scan by scanId, dependencyId, vulnerabilityId")
    public VulnerabilityDTO getVulnerability(
            @PathVariable("scanId") String scanId,
            @PathVariable("dependencyId") String dependencyId,
            @PathVariable("vulnerabilityId") String vulnerabilityId) {

        return scanService.findVulnerability(scanId, dependencyId,
                vulnerabilityId);
    }

    @RequestMapping(value = "/{scanId}/dependencies/{dependencyId}/issues", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependency Issues", notes = "Returns all issues of a dependency within a "
            + "scan by scanId, dependencyId")
    public IssuesDTO getDependencyIssues(@PathVariable("scanId") String scanId,
                                         @PathVariable("dependencyId") String dependencyId) {

        return scanService.findAllDependencyIssues(scanId, dependencyId);
    }

    @RequestMapping(value = "/{scanId}/dependencies/{dependencyId}/issues/{issueId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Dependency Issue", notes = "Returns a dependency issue of a dependency within a "
            + "scan by scanId, dependencyId, issueId")
    public IssueDTO getDependencyIssue(@PathVariable("scanId") String scanId,
                                       @PathVariable("dependencyId") String dependencyId,
                                       @PathVariable("issueId") String issueId) {

        return scanService.findDependencyIssue(scanId, dependencyId, issueId);
    }

    @RequestMapping(value = "/{scanId}/packages", method = RequestMethod.GET)
    @ApiOperation(value = "Get Packages", notes = "Returns all packages of a "
            + "scan by scanId")
    public PackagesDTO getPackages(@PathVariable("scanId") String scanId) {

        return scanService.findAllPackages(scanId);
    }

    @RequestMapping(value = "/{scanId}/packages/{packageId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Package", notes = "Returns a package of a scan by scanId, packageId")
    public PackageDTO getPackage(@PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId) {

        return scanService.findPackage(scanId, packageId);
    }

    @RequestMapping(value = "/{scanId}/packages/{packageId}/clazzes", method = RequestMethod.GET)
    @ApiOperation(value = "Get Classes", notes = "Returns all classes of a package within"
            + "scan by scanId, packageId and ordered by: afferrent or efferent coupling, and filtered by result limit")
    public ClazzesDTO getClazzes(@PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId) {

        return scanService.findAllClazzes(scanId, packageId);
    }

    @RequestMapping(value = "/{scanId}/packages/{packageId}/clazzes/{clazzId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Class", notes = "Returns a class of a package within a"
            + "scan by scanId, packageId, classId")
    public ClazzDTO getClazz(@PathVariable("scanId") String scanId,
                             @PathVariable("packageId") String packageId,
                             @PathVariable("clazzId") String clazzId) {

        return scanService.findClazz(scanId, packageId, clazzId);
    }

    @RequestMapping(value = "/{scanId}/packages/{packageId}/clazzes/{clazzId}/methods", method = RequestMethod.GET)
    @ApiOperation(value = "Get Methods", notes = "Returns all methods of a class within a package within a"
            + "scan by scanId, packageId, classId")
    public MethodsDTO getMethods(@PathVariable("scanId") String scanId,
                                 @PathVariable("packageId") String packageId,
                                 @PathVariable("clazzId") String clazzId) {

        return scanService.findAllMethods(scanId, packageId, clazzId);
    }

    @RequestMapping(value = "/{scanId}/packages/{packageId}/clazzes/{clazzId}/methods/{methodId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Method", notes = "Returns a method of a class within a package within a"
            + "scan by scanId, packageId, classId, methodId")
    public MethodDTO getMethod(@PathVariable("scanId") String scanId,
                               @PathVariable("packageId") String packageId,
                               @PathVariable("clazzId") String clazzId,
                               @PathVariable("methodId") String methodId) {

        return scanService.findMethod(scanId, packageId, clazzId, methodId);
    }
}
