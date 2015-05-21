package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wordnik.swagger.annotations.ApiModel;

/**
 * Created by stromero on 12/11/2014.
 */
@ApiModel("Dependency")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class DependencyDTO {

    // Properties
    private String teriansId;

    private String description;
    private String fileName;
    private String filePath;
    private String license;
    private IssuesDTO issuesDTO;
    private VulnerabilitiesDTO vulnerabilitiesDTO;
    private MethodsDTO methodsDTO;
    private ClazzesDTO clazzesDTO;

    public DependencyDTO() {

    }

    public ClazzesDTO getClazzesDTO() {
        return clazzesDTO;
    }

    public void setClazzesDTO(ClazzesDTO clazzesDTO) {
        this.clazzesDTO = clazzesDTO;
    }

    public MethodsDTO getMethodsDTO() {
        return methodsDTO;
    }

    public void setMethodsDTO(MethodsDTO methodsDTO) {
        this.methodsDTO = methodsDTO;
    }

    public String getTeriansId() {
        return teriansId;
    }

    // Getters and Setters
    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public IssuesDTO getIssuesDTO() {
        return issuesDTO;
    }

    public void setIssuesDTO(IssuesDTO issuesDTO) {
        this.issuesDTO = issuesDTO;
    }

    public VulnerabilitiesDTO getVulnerabilitiesDTO() {
        return vulnerabilitiesDTO;
    }

    public void setVulnerabilitiesDTO(VulnerabilitiesDTO vulnerabilitiesDTO) {
        this.vulnerabilitiesDTO = vulnerabilitiesDTO;
    }
}
