package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wordnik.swagger.annotations.ApiModel;

/**
 * Created by stromero on 1/5/2015.
 */
@ApiModel("Method")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MethodDTO {

    // Properties
    private String teriansId;
    private String name;
    private Double afferent;
    private Double efferent;
    private Double cyclomaticCom;
    private String sourceCode;

    public MethodDTO() {
    }

    // Getters and Setters

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
