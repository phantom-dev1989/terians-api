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
public class Project {

    // Properties
    @GraphId
    private Long id;
    @Indexed(unique = true)
    private String name;
    @Indexed
    private String teriansId;

    // Relationships
    @RelatedTo(type = "HAS_SCAN")
    private Set<Scan> scans;

    public String getTeriansId() {
        return teriansId;
    }

    // Getters and Setters
    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Scan> getScans() {
        return scans;
    }

    public void setScans(Set<Scan> scans) {
        this.scans = scans;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (teriansId != null ? teriansId.hashCode() : 0);
        result = 31 * result + (scans != null ? scans.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Project project = (Project) o;

        if (name != null ? !name.equals(project.name) : project.name != null)
            return false;
        if (scans != null
                ? !scans.equals(project.scans)
                : project.scans != null)
            return false;
        if (teriansId != null
                ? !teriansId.equals(project.teriansId)
                : project.teriansId != null)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", name='" + name + '\''
                + ", teriansId='" + teriansId + '\'' + ", scans=" + scans + '}';
    }
}
