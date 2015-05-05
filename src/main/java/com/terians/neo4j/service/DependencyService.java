package com.terians.neo4j.service;

import com.terians.dto.*;

/**
 * Created by stromero on 1/4/2015.
 */
public interface DependencyService {

    DependenciesDTO findAllDependencies();

    DependencyDTO findDependency(String dependencyId);

    MethodsDTO findAllMethods(String dependencyId);

    MethodDTO findMethod(String dependencyId, String methodId);

    VulnerabilitiesDTO findAllVulnerabilities(String dependencyId);

    VulnerabilityDTO findVulnerability(String dependencyId,
                                       String vulnerabilityId);

    IssuesDTO findAllIssues(String dependencyId);

    IssueDTO findIssue(String dependencyId, String issueId);

    ClazzesDTO findAllClazzes(String dependencyId);

    ClazzDTO findClazz(String dependencyId, String clazzId);
}
