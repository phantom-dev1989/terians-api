package com.terians.neo4j.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Created by stromero on 12/11/2014.
 */
@NodeEntity
public class Issue {

    // Properties
    @GraphId
    private Long id;
    @Indexed
    private String teriansId;
    @Indexed
    private String issue;
    @Indexed
    private String description;
    @Indexed
    private String fileName;
    @Indexed
    private String severity;
    @Indexed
    private String lineNumber;
    @Indexed
    private String packageName;
    @Indexed
    private String className;
    @Indexed
    private String category;
    @Indexed
    private String filePath;
    @Indexed
    private String techDebtMinutes;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue1 = (Issue) o;

        if (id != null ? !id.equals(issue1.id) : issue1.id != null) return false;
        if (teriansId != null ? !teriansId.equals(issue1.teriansId) : issue1.teriansId != null) return false;
        if (issue != null ? !issue.equals(issue1.issue) : issue1.issue != null) return false;
        if (description != null ? !description.equals(issue1.description) : issue1.description != null) return false;
        if (fileName != null ? !fileName.equals(issue1.fileName) : issue1.fileName != null) return false;
        if (severity != null ? !severity.equals(issue1.severity) : issue1.severity != null) return false;
        if (lineNumber != null ? !lineNumber.equals(issue1.lineNumber) : issue1.lineNumber != null) return false;
        if (packageName != null ? !packageName.equals(issue1.packageName) : issue1.packageName != null) return false;
        if (className != null ? !className.equals(issue1.className) : issue1.className != null) return false;
        if (category != null ? !category.equals(issue1.category) : issue1.category != null) return false;
        if (filePath != null ? !filePath.equals(issue1.filePath) : issue1.filePath != null) return false;
        return !(techDebtMinutes != null ? !techDebtMinutes.equals(issue1.techDebtMinutes) : issue1.techDebtMinutes != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (teriansId != null ? teriansId.hashCode() : 0);
        result = 31 * result + (issue != null ? issue.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (severity != null ? severity.hashCode() : 0);
        result = 31 * result + (lineNumber != null ? lineNumber.hashCode() : 0);
        result = 31 * result + (packageName != null ? packageName.hashCode() : 0);
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (techDebtMinutes != null ? techDebtMinutes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "category='" + category + '\'' +
                ", id=" + id +
                ", teriansId='" + teriansId + '\'' +
                ", issue='" + issue + '\'' +
                ", description='" + description + '\'' +
                ", fileName='" + fileName + '\'' +
                ", severity='" + severity + '\'' +
                ", lineNumber='" + lineNumber + '\'' +
                ", packageName='" + packageName + '\'' +
                ", className='" + className + '\'' +
                ", filePath='" + filePath + '\'' +
                ", techDebtMinutes='" + techDebtMinutes + '\'' +
                '}';
    }
}
