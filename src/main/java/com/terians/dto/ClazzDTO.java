package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wordnik.swagger.annotations.ApiModel;

/**
 * Created by stromero on 1/5/2015.
 */
@ApiModel("Class")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClazzDTO {

    private String teriansId;
    private String name;
    private Double afferent;
    private Double efferent;
    private String sourceCode;
    private String lineNumbers;
    private Double cyclomaticCom;
    private MethodsDTO methodsDTO;

    public ClazzDTO() {
    }

    // Getters and Setters
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

    public MethodsDTO getMethodsDTO() {
        return methodsDTO;
    }

    public void setMethodsDTO(MethodsDTO methodsDTO) {
        this.methodsDTO = methodsDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
