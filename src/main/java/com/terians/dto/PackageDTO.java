package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wordnik.swagger.annotations.ApiModel;

/**
 * Created by stromero on 1/5/2015.
 */
@ApiModel("Package")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class PackageDTO {

    // Properties
    private String teriansId;
    private String name;
    private Double afferent;
    private Double efferent;
    private Double cyclomaticCom;
    private Double instability;
    private Double abstractness;
    private ClazzesDTO clazzesDTO;

    public PackageDTO() {

    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClazzesDTO getClazzesDTO() {
        return clazzesDTO;
    }

    public void setClazzesDTO(ClazzesDTO clazzesDTO) {
        this.clazzesDTO = clazzesDTO;
    }
}
