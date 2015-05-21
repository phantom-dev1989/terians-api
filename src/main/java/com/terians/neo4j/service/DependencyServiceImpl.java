package com.terians.neo4j.service;

import com.terians.dto.*;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.repository.DependencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public final class DependencyServiceImpl implements DependencyService {

    @Autowired
    private DependencyRepository dependencyRepository;

    @Override
    public DependenciesDTO findAllDependencies() {
        return DTOTransformerUtil
                .transformDependencySetToDependenciesDTO(dependencyRepository
                        .findAllDependencies());
    }

    @Override
    public DependencyDTO findDependency(String dependencyId) {

        if (dependencyId != null) {
            return DTOTransformerUtil
                    .transformDependencyToDependencyDTO(dependencyRepository
                            .findDependency(dependencyId));
        }
        return null;
    }

    @Override
    public MethodsDTO findAllMethods(String dependencyId) {

        if (dependencyId != null) {
            return DTOTransformerUtil
                    .transformMethodSetToMethodsDTO(dependencyRepository
                            .findAllMethods(dependencyId));
        }
        return null;
    }

    @Override
    public MethodDTO findMethod(String dependencyId, String methodId) {

        if ((dependencyId != null) && (methodId != null)) {
            return DTOTransformerUtil
                    .transformMethodToMethodDTO(dependencyRepository
                            .findMethod(dependencyId, methodId));
        }
        return null;
    }

    @Override
    public VulnerabilitiesDTO findAllVulnerabilities(String dependencyId) {

        if (dependencyId != null) {
            return DTOTransformerUtil
                    .transformVulnerabilitySetToVulnerabilitiesDTO(dependencyRepository
                            .findAllVulnerabilities(dependencyId));
        }
        return null;
    }

    @Override
    public VulnerabilityDTO findVulnerability(String dependencyId,
                                              String vulnerabilityId) {

        if ((dependencyId != null) && (vulnerabilityId != null)) {
            return DTOTransformerUtil
                    .transformVulnerabilityToVulnerabilityDTO(dependencyRepository
                            .findVulnerability(dependencyId, vulnerabilityId));
        }
        return null;
    }

    @Override
    public IssuesDTO findAllIssues(String dependencyId) {

        if (dependencyId != null) {
            return DTOTransformerUtil
                    .transformIssuesSetToIssuesDTO(dependencyRepository
                            .findAllIssues(dependencyId));
        }
        return null;
    }

    @Override
    public IssueDTO findIssue(String dependencyId, String issueId) {

        if ((dependencyId != null) && (issueId != null)) {
            return DTOTransformerUtil
                    .transformIssueToIssueDTO(dependencyRepository.findIssue(
                            dependencyId, issueId));
        }
        return null;
    }

    @Override
    public ClazzesDTO findAllClazzes(String dependencyId) {

        if (dependencyId != null) {
            return DTOTransformerUtil
                    .transformClazzSetToClazzesDTO(dependencyRepository
                            .findAllClazzes(dependencyId));
        }
        return null;
    }

    @Override
    public ClazzDTO findClazz(String dependencyId, String clazzId) {

        if ((dependencyId != null) && (clazzId != null)) {
            return DTOTransformerUtil
                    .transformClazzToClazzDTO(dependencyRepository.findClazz(
                            dependencyId, clazzId));
        }
        return null;
    }
}
