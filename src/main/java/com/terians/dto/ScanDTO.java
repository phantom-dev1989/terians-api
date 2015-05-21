package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by stromero on 12/11/2014.
 */
@ApiModel("Scan")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class ScanDTO {

    // Properties
    private String teriansId;
    private String projectVersion;
    private int complexity;
    private int techdebt;
    private int abstractness;
    private int instability;
    private int methodCount;
    private int clazzCount;
    private int packageCount;
    private int issueCount;
    private int issueCriticalCount;
    private int issueHighCount;
    private int issueMediumCount;
    private int issueLowCount;
    private int issueBestPracticeCount;
    private int loc;
    private int circularDependencyCount;
    private Date date;
    private IssuesDTO issuesDTO;
    private DependenciesDTO dependenciesDTO;
    private PackagesDTO packagesDTO;

    public ScanDTO() {

    }

    // Getters and Setters


    public int getIssueBestPracticeCount() {
        return issueBestPracticeCount;
    }

    public void setIssueBestPracticeCount(int issueBestPracticeCount) {
        this.issueBestPracticeCount = issueBestPracticeCount;
    }

    public int getIssueCriticalCount() {
        return issueCriticalCount;
    }

    public void setIssueCriticalCount(int issueCriticalCount) {
        this.issueCriticalCount = issueCriticalCount;
    }

    public int getIssueHighCount() {
        return issueHighCount;
    }

    public void setIssueHighCount(int issueHighCount) {
        this.issueHighCount = issueHighCount;
    }

    public int getIssueLowCount() {
        return issueLowCount;
    }

    public void setIssueLowCount(int issueLowCount) {
        this.issueLowCount = issueLowCount;
    }

    public int getIssueMediumCount() {
        return issueMediumCount;
    }

    public void setIssueMediumCount(int issueMediumCount) {
        this.issueMediumCount = issueMediumCount;
    }

    public int getIssueCount() {
        return issueCount;
    }

    public void setIssueCount(int issueCount) {
        this.issueCount = issueCount;
    }

    public int getClazzCount() {
        return clazzCount;
    }

    public void setClazzCount(int clazzCount) {
        this.clazzCount = clazzCount;
    }

    public int getMethodCount() {
        return methodCount;
    }

    public void setMethodCount(int methodCount) {
        this.methodCount = methodCount;
    }

    public int getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(int packageCount) {
        this.packageCount = packageCount;
    }

    public int getAbstractness() {
        return abstractness;
    }

    public void setAbstractness(int abstractness) {
        this.abstractness = abstractness;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getInstability() {
        return instability;
    }

    public void setInstability(int instability) {
        this.instability = instability;
    }

    public int getTechdebt() {
        return techdebt;
    }

    public void setTechdebt(int techdebt) {
        this.techdebt = techdebt;
    }

    public String getTeriansId() {
        return teriansId;
    }

    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public void setProjectVersion(String projectVersion) {
        this.projectVersion = projectVersion;
    }

    public DependenciesDTO getDependenciesDTO() {
        return dependenciesDTO;
    }

    public void setDependenciesDTO(DependenciesDTO dependenciesDTO) {
        this.dependenciesDTO = dependenciesDTO;
    }

    public IssuesDTO getIssuesDTO() {
        return issuesDTO;
    }

    public void setIssuesDTO(IssuesDTO issuesDTO) {
        this.issuesDTO = issuesDTO;
    }

    public PackagesDTO getPackagesDTO() {
        return packagesDTO;
    }

    public void setPackagesDTO(PackagesDTO packagesDTO) {
        this.packagesDTO = packagesDTO;
    }

    public int getCircularDependencyCount() {
        return circularDependencyCount;
    }

    public void setCircularDependencyCount(int circularDependencyCount) {
        this.circularDependencyCount = circularDependencyCount;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }
}
