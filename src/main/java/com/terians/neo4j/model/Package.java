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
public final class Package {

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
    private Double instability;
    @Indexed
    private Double abstractness;

    // Relationships
    @RelatedTo(type = "HAS_CLAZZ")
    private Set<Clazz> clazzs;

    // Getters and Setters
    public Double getAbstractness() {
        return abstractness;
    }

    public void setAbstractness(Double abstractness) {
        this.abstractness = abstractness;
    }

    public Double getInstability() {
        return instability;
    }

    public void setInstability(Double instability) {
        this.instability = instability;
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

    public Set<Clazz> getClazzs() {
        return clazzs;
    }

    public void setClazzs(Set<Clazz> clazzs) {
        this.clazzs = clazzs;
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
        result = 31 * result
                + (instability != null ? instability.hashCode() : 0);
        result = 31 * result
                + (abstractness != null ? abstractness.hashCode() : 0);
        result = 31 * result + (clazzs != null ? clazzs.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Package aPackage = (Package) o;

        if (abstractness != null
                ? !abstractness.equals(aPackage.abstractness)
                : aPackage.abstractness != null)
            return false;
        if (afferent != null
                ? !afferent.equals(aPackage.afferent)
                : aPackage.afferent != null)
            return false;
        if (clazzs != null
                ? !clazzs.equals(aPackage.clazzs)
                : aPackage.clazzs != null)
            return false;
        if (cyclomaticCom != null
                ? !cyclomaticCom.equals(aPackage.cyclomaticCom)
                : aPackage.cyclomaticCom != null)
            return false;
        if (efferent != null
                ? !efferent.equals(aPackage.efferent)
                : aPackage.efferent != null)
            return false;
        if (instability != null
                ? !instability.equals(aPackage.instability)
                : aPackage.instability != null)
            return false;
        if (name != null ? !name.equals(aPackage.name) : aPackage.name != null)
            return false;
        if (teriansId != null
                ? !teriansId.equals(aPackage.teriansId)
                : aPackage.teriansId != null)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Package{" + "abstractness=" + abstractness + ", id=" + id
                + ", teriansId='" + teriansId + '\'' + ", name='" + name + '\''
                + ", afferent=" + afferent + ", efferent=" + efferent
                + ", cyclomaticCom=" + cyclomaticCom + ", instability="
                + instability + ", clazzs=" + clazzs + '}';
    }
}
