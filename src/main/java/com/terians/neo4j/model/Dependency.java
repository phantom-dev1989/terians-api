package com.terians.neo4j.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.Set;

/**
 * Created by stromero on 12/11/2014.
 */
@NodeEntity
public class Dependency {

    // Properties
    @GraphId
    private Long id;
    @Indexed
    private String teriansId;
    @Indexed
    private String description;
    @Indexed
    private String fileName;
    @Indexed
    private String filePath;
    @Indexed
    private String license;

    // Relationships
    @RelatedTo(type = "HAS_VULN")
    private Set<Vulnerability> vulnerabilities;
    @RelatedTo(type = "HAS_ISSUE")
    private Set<Issue> issues;
    @RelatedTo(type = "USED_BY_METHOD")
    private Set<Method> methods;
    @RelatedTo(type = "USED_BY_CLAZZ")
    private Set<Clazz> clazzes;

    // Getters and Setters
    public Set<Clazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(Set<Clazz> clazzes) {
        this.clazzes = clazzes;
    }

    public String getTeriansId() {
        return teriansId;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Set<Vulnerability> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(Set<Vulnerability> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    public Set<Method> getMethods() {
        return methods;
    }

    public void setMethods(Set<Method> methods) {
        this.methods = methods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dependency that = (Dependency) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (teriansId != null ? !teriansId.equals(that.teriansId) : that.teriansId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) return false;
        if (license != null ? !license.equals(that.license) : that.license != null) return false;
        if (vulnerabilities != null ? !vulnerabilities.equals(that.vulnerabilities) : that.vulnerabilities != null)
            return false;
        if (issues != null ? !issues.equals(that.issues) : that.issues != null) return false;
        if (methods != null ? !methods.equals(that.methods) : that.methods != null) return false;
        return !(clazzes != null ? !clazzes.equals(that.clazzes) : that.clazzes != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (teriansId != null ? teriansId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (license != null ? license.hashCode() : 0);
        result = 31 * result + (vulnerabilities != null ? vulnerabilities.hashCode() : 0);
        result = 31 * result + (issues != null ? issues.hashCode() : 0);
        result = 31 * result + (methods != null ? methods.hashCode() : 0);
        result = 31 * result + (clazzes != null ? clazzes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dependency{" +
                "clazzes=" + clazzes +
                ", id=" + id +
                ", teriansId='" + teriansId + '\'' +
                ", description='" + description + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", license='" + license + '\'' +
                ", vulnerabilities=" + vulnerabilities +
                ", issues=" + issues +
                ", methods=" + methods +
                '}';
    }
}
