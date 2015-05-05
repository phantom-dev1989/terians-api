package com.terians.dto.transformer;

import com.terians.dto.*;
import com.terians.neo4j.model.*;
import com.terians.neo4j.model.Package;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by stromero on 3/3/2015.
 */
public final class DTOTransformerUtil {

    private DTOTransformerUtil() {

    }

    public static ClazzesDTO transformClazzSetToClazzesDTO(
            Set<Clazz> clazzSet) {

        ClazzesDTO clazzesDTO = new ClazzesDTO();
        List<ClazzDTO> clazzDTOList = new ArrayList<>();

        for (Clazz e : clazzSet) {
            ClazzDTO clazzDTO = new ClazzDTO();
            clazzDTO.setTeriansId(e.getTeriansId());
            clazzDTO.setAfferent(e.getAfferent());
            clazzDTO.setCyclomaticCom(e.getCyclomaticCom());
            clazzDTO.setEfferent(e.getEfferent());
            clazzDTO.setName(e.getName());
            clazzDTO.setSourceCode(e.getSourceCode());
            clazzDTO.setLineNumbers(e.getLineNumbers());

            clazzDTOList.add(clazzDTO);
        }

        clazzesDTO.setClazzDTOList(clazzDTOList);
        clazzesDTO.setSize(clazzDTOList.size());

        return clazzesDTO;
    }

    public static ClazzDTO transformClazzToClazzDTO(Clazz clazz) {

        ClazzDTO clazzDTO = new ClazzDTO();
        clazzDTO.setTeriansId(clazz.getTeriansId());
        clazzDTO.setAfferent(clazz.getAfferent());
        clazzDTO.setCyclomaticCom(clazz.getCyclomaticCom());
        clazzDTO.setEfferent(clazz.getEfferent());
        clazzDTO.setName(clazz.getName());
        clazzDTO.setSourceCode(clazz.getSourceCode());
        clazzDTO.setLineNumbers(clazz.getLineNumbers());

        return clazzDTO;
    }

    public static DependencyDTO transformDependencyToDependencyDTO(
            Dependency dependency) {

        DependencyDTO dependencyDTO = new DependencyDTO();
        dependencyDTO.setTeriansId(dependency.getTeriansId());
        dependencyDTO.setDescription(dependency.getDescription());
        dependencyDTO.setFileName(dependency.getFileName());
        dependencyDTO.setFilePath(dependency.getFilePath());
        dependencyDTO.setLicense(dependency.getLicense());

        return dependencyDTO;
    }

    public static DependenciesDTO transformDependencySetToDependenciesDTO(
            Set<Dependency> dependencySet) {

        DependenciesDTO dependenciesDTO = new DependenciesDTO();
        List<DependencyDTO> dependencyDTOList = new ArrayList<>();
        for (Dependency e : dependencySet) {

            DependencyDTO dependencyDTO = new DependencyDTO();
            dependencyDTO.setTeriansId(e.getTeriansId());
            dependencyDTO.setDescription(e.getDescription());
            dependencyDTO.setFileName(e.getFileName());
            dependencyDTO.setFilePath(e.getFilePath());
            dependencyDTO.setLicense(e.getLicense());

            dependencyDTOList.add(dependencyDTO);
        }

        dependenciesDTO.setDependencyDTOList(dependencyDTOList);
        dependenciesDTO.setSize(dependencyDTOList.size());

        return dependenciesDTO;
    }

    public static IssueDTO transformIssueToIssueDTO(Issue issue) {

        IssueDTO issueDTO = new IssueDTO();
        issueDTO.setTeriansId(issue.getTeriansId());
        issueDTO.setCategory(issue.getCategory());
        issueDTO.setClassName(issue.getClassName());
        issueDTO.setDescription(issue.getDescription());
        issueDTO.setFileName(issue.getFileName());
        issueDTO.setFilePath(issue.getFilePath());
        issueDTO.setLineNumber(issue.getLineNumber());
        issueDTO.setPackageName(issue.getPackageName());
        issueDTO.setSeverity(issue.getSeverity());
        issueDTO.setTechDebtMinutes(issue.getTechDebtMinutes());
        issueDTO.setIssue(issue.getIssue());

        return issueDTO;

    }

    public static IssuesDTO transformIssuesSetToIssuesDTO(
            Set<Issue> issueSet) {

        IssuesDTO issuesDTO = new IssuesDTO();
        List<IssueDTO> issueDTOList = new ArrayList<>();
        for (Issue e : issueSet) {

            IssueDTO issueDTO = new IssueDTO();
            issueDTO.setTeriansId(e.getTeriansId());
            issueDTO.setCategory(e.getCategory());
            issueDTO.setClassName(e.getClassName());
            issueDTO.setDescription(e.getDescription());
            issueDTO.setFileName(e.getFileName());
            issueDTO.setFilePath(e.getFilePath());
            issueDTO.setLineNumber(e.getLineNumber());
            issueDTO.setPackageName(e.getPackageName());
            issueDTO.setSeverity(e.getSeverity());
            issueDTO.setTechDebtMinutes(e.getTechDebtMinutes());
            issueDTO.setIssue(e.getIssue());

            issueDTOList.add(issueDTO);
        }

        issuesDTO.setIssueDTOList(issueDTOList);
        issuesDTO.setSize(issueDTOList.size());

        return issuesDTO;

    }

    public static PackagesDTO transformPackageSetToPackagesDTO(
            Set<com.terians.neo4j.model.Package> packageSet) {

        PackagesDTO packagesDTO = new PackagesDTO();
        List<PackageDTO> packageDTOList = new ArrayList<>();
        for (Package e : packageSet) {

            PackageDTO packageDTO = new PackageDTO();
            packageDTO.setTeriansId(e.getTeriansId());
            packageDTO.setAfferent(e.getAfferent());
            packageDTO.setCyclomaticCom(e.getCyclomaticCom());
            packageDTO.setEfferent(e.getEfferent());
            packageDTO.setName(e.getName());
            packageDTO.setInstability(e.getInstability());
            packageDTO.setAbstractness(e.getAbstractness());

            packageDTOList.add(packageDTO);
        }

        packagesDTO.setPackageDTOList(packageDTOList);
        packagesDTO.setSize(packageDTOList.size());

        return packagesDTO;
    }

    public static ProjectDTO transformProjectToProjectDTO(Project project) {

        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setTeriansId(project.getTeriansId());
        projectDTO.setName(project.getName());

        return projectDTO;
    }

    public static ProjectsDTO transformProjectSetToProjectsDTO(
            Set<Project> projectSet) {

        ProjectsDTO projectsDTO = new ProjectsDTO();
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (Project e : projectSet) {

            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setTeriansId(e.getTeriansId());
            projectDTO.setName(e.getName());

            projectDTOList.add(projectDTO);
        }

        projectsDTO.setProjectDTOList(projectDTOList);
        projectsDTO.setSize(projectDTOList.size());

        return projectsDTO;
    }

    public static ScanDTO transformScanToScanDTO(Scan scan) {

        ScanDTO scanDTO = new ScanDTO();
        scanDTO.setTeriansId(scan.getTeriansId());
        scanDTO.setDate(scan.getDate());
        scanDTO.setProjectVersion(scan.getProjectVersion());
        scanDTO.setCircularDependencyCount(scan.getCircularDependencyCount());
        scanDTO.setLoc(scan.getLoc());
        return scanDTO;
    }

    public static ScansDTO transformScanSetToScansDTO(Set<Scan> scanSet) {

        ScansDTO scansDTO = new ScansDTO();
        List<ScanDTO> scanDTOList = new ArrayList<>();
        for (Scan e : scanSet) {

            ScanDTO scanDTO = new ScanDTO();
            scanDTO.setTeriansId(e.getTeriansId());
            scanDTO.setDate(e.getDate());
            scanDTO.setProjectVersion(e.getProjectVersion());
            scanDTO.setCircularDependencyCount(e.getCircularDependencyCount());
            scanDTO.setLoc(e.getLoc());

            scanDTOList.add(scanDTO);
        }

        scansDTO.setScanDTOList(scanDTOList);
        scansDTO.setSize(scanDTOList.size());

        return scansDTO;
    }

    public static MethodsDTO transformMethodSetToMethodsDTO(
            Set<Method> methodSet) {

        MethodsDTO methodsDTO = new MethodsDTO();
        List<MethodDTO> methodDTOList = new ArrayList<>();
        for (Method e : methodSet) {

            MethodDTO methodDTO = new MethodDTO();
            methodDTO.setTeriansId(e.getTeriansId());
            methodDTO.setAfferent(e.getAfferent());
            methodDTO.setName(e.getName());
            methodDTO.setCyclomaticCom(e.getCyclomaticCom());
            methodDTO.setEfferent(e.getEfferent());
            methodDTO.setSourceCode(e.getSourceCode());
            methodDTOList.add(methodDTO);
        }

        methodsDTO.setMethodDTOList(methodDTOList);
        methodsDTO.setSize(methodDTOList.size());

        return methodsDTO;
    }

    public static MethodDTO transformMethodToMethodDTO(Method method) {

        MethodDTO methodDTO = new MethodDTO();
        methodDTO.setTeriansId(method.getTeriansId());
        methodDTO.setAfferent(method.getAfferent());
        methodDTO.setName(method.getName());
        methodDTO.setCyclomaticCom(method.getCyclomaticCom());
        methodDTO.setEfferent(method.getEfferent());
        methodDTO.setSourceCode(method.getSourceCode());

        return methodDTO;
    }

    public static VulnerabilitiesDTO transformVulnerabilitySetToVulnerabilitiesDTO(
            Set<Vulnerability> vulnerabilitySet) {

        VulnerabilitiesDTO vulnerabilitiesDTO = new VulnerabilitiesDTO();
        List<VulnerabilityDTO> vulnerabilityDTOList = new ArrayList<>();

        for (Vulnerability e : vulnerabilitySet) {

            VulnerabilityDTO vulnerabilityDTO = new VulnerabilityDTO();
            vulnerabilityDTO.setTeriansId(e.getTeriansId());
            vulnerabilityDTO.setName(e.getName());
            vulnerabilityDTO.setCve(e.getCve());
            vulnerabilityDTO.setCvssScore(e.getCvssScore());
            vulnerabilityDTO.setCwe(e.getCwe());
            vulnerabilityDTO.setDescription(e.getDescription());
            vulnerabilityDTO.setSeverity(e.getSeverity());

            vulnerabilityDTOList.add(vulnerabilityDTO);
        }

        vulnerabilitiesDTO.setVulnerabilityDTOList(vulnerabilityDTOList);
        vulnerabilitiesDTO.setSize(vulnerabilityDTOList.size());

        return vulnerabilitiesDTO;
    }

    public static VulnerabilityDTO transformVulnerabilityToVulnerabilityDTO(
            Vulnerability vulnerability) {

        VulnerabilityDTO vulnerabilityDTO = new VulnerabilityDTO();
        vulnerabilityDTO.setTeriansId(vulnerability.getTeriansId());
        vulnerabilityDTO.setName(vulnerability.getName());
        vulnerabilityDTO.setCve(vulnerability.getCve());
        vulnerabilityDTO.setCvssScore(vulnerability.getCvssScore());
        vulnerabilityDTO.setCwe(vulnerability.getCwe());
        vulnerabilityDTO.setDescription(vulnerability.getDescription());
        vulnerabilityDTO.setSeverity(vulnerability.getSeverity());

        return vulnerabilityDTO;
    }

    public static PackageDTO transformPackageToPackageDTO(Package packageObj) {

        PackageDTO packageDTO = new PackageDTO();
        packageDTO.setTeriansId(packageObj.getTeriansId());
        packageDTO.setAfferent(packageObj.getAfferent());
        packageDTO.setCyclomaticCom(packageObj.getCyclomaticCom());
        packageDTO.setEfferent(packageObj.getEfferent());
        packageDTO.setName(packageObj.getName());
        packageDTO.setInstability(packageObj.getInstability());
        packageDTO.setAbstractness(packageObj.getAbstractness());

        return packageDTO;
    }
}
