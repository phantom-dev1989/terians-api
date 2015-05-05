package com.terians.neo4j.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.Date;
import java.util.Set;

/**
 * Created by stromero on 12/11/2014.
 */
@NodeEntity
public class Scan {

    // Properties
    @GraphId
    private Long id;
    @Indexed
    private String teriansId;
    @Indexed
    private String projectVersion;
    @Indexed
    private Integer loc;
    @Indexed
    private Integer circularDependencyCount;
    @Indexed
    private Date date;

    // Relationships
    @RelatedTo(type = "NEXT_SCAN")
    private Scan scan;
    @RelatedTo(type = "HAS_ISSUE")
    private Set<Issue> issues;
    @RelatedTo(type = "HAS_DEPENDENCY")
    private Set<Dependency> dependencies;
    @RelatedTo(type = "HAS_PACKAGE")
    private Set<Package> packages;

    public String getTeriansId() {
        return teriansId;
    }

    // Getters and Setters
    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Dependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Set<Dependency> dependencies) {
        this.dependencies = dependencies;
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

    public Set<Package> getPackages() {
        return packages;
    }

    public void setPackages(Set<Package> packages) {
        this.packages = packages;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public void setProjectVersion(String projectVersion) {
        this.projectVersion = projectVersion;
    }

    public Scan getScan() {
        return scan;
    }

    public void setScan(Scan scan) {
        this.scan = scan;
    }

    public Integer getLoc() {
        return loc;
    }

    public void setLoc(Integer loc) {
        this.loc = loc;
    }

    public Integer getCircularDependencyCount() {
        return circularDependencyCount;
    }

    public void setCircularDependencyCount(Integer circularDependencyCount) {
        this.circularDependencyCount = circularDependencyCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Scan scan1 = (Scan) o;

        if (circularDependencyCount != null ? !circularDependencyCount.equals(scan1.circularDependencyCount) : scan1.circularDependencyCount != null)
            return false;
        if (date != null ? !date.equals(scan1.date) : scan1.date != null) return false;
        if (dependencies != null ? !dependencies.equals(scan1.dependencies) : scan1.dependencies != null) return false;
        if (id != null ? !id.equals(scan1.id) : scan1.id != null) return false;
        if (issues != null ? !issues.equals(scan1.issues) : scan1.issues != null) return false;
        if (loc != null ? !loc.equals(scan1.loc) : scan1.loc != null) return false;
        if (packages != null ? !packages.equals(scan1.packages) : scan1.packages != null) return false;
        if (projectVersion != null ? !projectVersion.equals(scan1.projectVersion) : scan1.projectVersion != null)
            return false;
        if (scan != null ? !scan.equals(scan1.scan) : scan1.scan != null) return false;
        if (teriansId != null ? !teriansId.equals(scan1.teriansId) : scan1.teriansId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (teriansId != null ? teriansId.hashCode() : 0);
        result = 31 * result + (projectVersion != null ? projectVersion.hashCode() : 0);
        result = 31 * result + (loc != null ? loc.hashCode() : 0);
        result = 31 * result + (circularDependencyCount != null ? circularDependencyCount.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (scan != null ? scan.hashCode() : 0);
        result = 31 * result + (issues != null ? issues.hashCode() : 0);
        result = 31 * result + (dependencies != null ? dependencies.hashCode() : 0);
        result = 31 * result + (packages != null ? packages.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Scan{" +
                "circularDependencyCount=" + circularDependencyCount +
                ", id=" + id +
                ", teriansId='" + teriansId + '\'' +
                ", projectVersion='" + projectVersion + '\'' +
                ", loc=" + loc +
                ", date=" + date +
                ", scan=" + scan +
                ", issues=" + issues +
                ", dependencies=" + dependencies +
                ", packages=" + packages +
                '}';
    }
}
