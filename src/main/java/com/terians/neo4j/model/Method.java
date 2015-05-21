package com.terians.neo4j.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Created by stromero on 1/5/2015.
 */
@NodeEntity
public final class Method {

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

    public String getTeriansId() {
        return teriansId;
    }

    // Getters and Setters
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (teriansId != null ? teriansId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (afferent != null ? afferent.hashCode() : 0);
        result = 31 * result + (efferent != null ? efferent.hashCode() : 0);
        result = 31 * result
                + (cyclomaticCom != null ? cyclomaticCom.hashCode() : 0);
        result = 31 * result + (sourceCode != null ? sourceCode.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Method method = (Method) o;

        if (afferent != null
                ? !afferent.equals(method.afferent)
                : method.afferent != null)
            return false;
        if (cyclomaticCom != null
                ? !cyclomaticCom.equals(method.cyclomaticCom)
                : method.cyclomaticCom != null)
            return false;
        if (efferent != null
                ? !efferent.equals(method.efferent)
                : method.efferent != null)
            return false;
        if (id != null ? !id.equals(method.id) : method.id != null)
            return false;
        if (name != null ? !name.equals(method.name) : method.name != null)
            return false;
        if (sourceCode != null
                ? !sourceCode.equals(method.sourceCode)
                : method.sourceCode != null)
            return false;
        if (teriansId != null
                ? !teriansId.equals(method.teriansId)
                : method.teriansId != null)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Method{" + "afferent=" + afferent + ", id=" + id
                + ", teriansId='" + teriansId + '\'' + ", name='" + name + '\''
                + ", efferent=" + efferent + ", cyclomaticCom=" + cyclomaticCom
                + ", sourceCode=" + sourceCode + '}';
    }
}
