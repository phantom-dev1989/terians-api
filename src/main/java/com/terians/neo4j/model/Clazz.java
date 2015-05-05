package com.terians.neo4j.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.Set;

/**
 * Created by stromero on 1/5/2015.
 */
@NodeEntity
public class Clazz {

    // Properties
    @GraphId
    private Long id;
    @Indexed
    private String teriansId;
    @Indexed
    private String name;
    @Indexed
    private Double afferent;
    @Indexed
    private Double efferent;
    @Indexed
    private Double cyclomaticCom;
    @Indexed
    private String sourceCode;
    @Indexed
    private String lineNumbers;

    // Relationships
    @RelatedTo(type = "HAS_METHOD")
    private Set<Method> methods;

    @RelatedTo(type = "HAS_ISSUE")
    private Set<Issue> issues;

    // Getters and Setters

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    public String getLineNumbers() {
        return lineNumbers;
    }

    public void setLineNumbers(String lineNumbers) {
        this.lineNumbers = lineNumbers;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getTeriansId() {
        return teriansId;
    }

    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public Double getAfferent() {
        return afferent;
    }

    public void setAfferent(Double afferent) {
        this.afferent = afferent;
    }

    public Double getCyclomaticCom() {
        return cyclomaticCom;
    }

    public void setCyclomaticCom(Double cyclomaticCom) {
        this.cyclomaticCom = cyclomaticCom;
    }

    public Double getEfferent() {
        return efferent;
    }

    public void setEfferent(Double efferent) {
        this.efferent = efferent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Method> getMethods() {
        return methods;
    }

    public void setMethods(Set<Method> methods) {
        this.methods = methods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = teriansId != null ? teriansId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (afferent != null ? afferent.hashCode() : 0);
        result = 31 * result + (efferent != null ? efferent.hashCode() : 0);
        result = 31 * result
                + (cyclomaticCom != null ? cyclomaticCom.hashCode() : 0);
        result = 31 * result + (methods != null ? methods.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Clazz clazz = (Clazz) o;

        if (afferent != null
                ? !afferent.equals(clazz.afferent)
                : clazz.afferent != null)
            return false;
        if (cyclomaticCom != null
                ? !cyclomaticCom.equals(clazz.cyclomaticCom)
                : clazz.cyclomaticCom != null)
            return false;
        if (efferent != null
                ? !efferent.equals(clazz.efferent)
                : clazz.efferent != null)
            return false;
        if (methods != null
                ? !methods.equals(clazz.methods)
                : clazz.methods != null)
            return false;
        if (name != null ? !name.equals(clazz.name) : clazz.name != null)
            return false;
        if (teriansId != null
                ? !teriansId.equals(clazz.teriansId)
                : clazz.teriansId != null)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Clazz{" + "afferent=" + afferent + ", id=" + id
                + ", teriansId='" + teriansId + '\'' + ", name='" + name + '\''
                + ", efferent=" + efferent + ", cyclomaticCom=" + cyclomaticCom
                + ", methods=" + methods + '}';
    }
}
