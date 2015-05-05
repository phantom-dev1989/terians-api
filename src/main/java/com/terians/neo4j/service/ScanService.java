package com.terians.neo4j.service;

import com.terians.dto.*;

/**
 * Created by stromero on 1/4/2015.
 */
public interface ScanService {

    ScansDTO findAllScans();

    ScanDTO findScan(String scanId);

    IssuesDTO findAllIssues(String scanId, String severity);

    IssueDTO findIssue(String scanId, String issueId);

    DependenciesDTO findAllDependencies(String scanId);

    DependencyDTO findDependency(String scanId, String dependencyId);

    MethodsDTO findAllDependencyMethods(String scanId, String dependencyId);

    MethodDTO findDependencyMethod(String scanId, String dependencyId,
                                   String methodId);

    VulnerabilitiesDTO findAllVulnerabilities(String scanId, String dependencyId);

    VulnerabilityDTO findVulnerability(String scanId, String dependencyId,
                                       String vulnerabilityId);

    IssuesDTO findAllDependencyIssues(String scanId, String dependencyId);

    IssueDTO findDependencyIssue(String scanId, String dependencyId,
                                 String issueId);

    PackagesDTO findAllPackages(String scanId);

    PackageDTO findPackage(String scanId, String packageId);

    ClazzesDTO findAllClazzes(String scanId, String packageId);

    ClazzDTO findClazz(String scanId, String packageId, String clazzId);

    MethodsDTO findAllMethods(String scanId, String packageId, String clazzId);

    MethodDTO findMethod(String scanId, String packageId, String clazzId,
                         String methodId);

    ClazzesDTO findAllDependenyClazzes(String scanId, String dependencyId);

    ClazzDTO findDependenyClazz(String scanId, String dependencyId,
                                String clazzId);

    ScanDTO findScanByDate(String scanned);
}
