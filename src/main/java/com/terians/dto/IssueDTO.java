package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wordnik.swagger.annotations.ApiModel;

/**
 * Created by stromero on 12/11/2014.
 */
@ApiModel("Issue")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class IssueDTO {

    // Properties
    private String teriansId;
    private String issue;
    private String description;
    private String fileName;
    private String severity;
    private String lineNumber;
    private String packageName;
    private String className;
    private String category;
    private String filePath;
    private String techDebtMinutes;

    public IssueDTO() {
    }

    public String getTeriansId() {
        return teriansId;
    }

    // Getters and Setters
    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getTechDebtMinutes() {
        return techDebtMinutes;
    }

    public void setTechDebtMinutes(String techDebtMinutes) {
        this.techDebtMinutes = techDebtMinutes;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

}
