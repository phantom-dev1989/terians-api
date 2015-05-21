package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@ApiModel("Methods")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class MethodsDTO {

    private int size;
    @JsonProperty("data")
    private List<MethodDTO> methodDTOList;

    public MethodsDTO() {
    }

    public List<MethodDTO> getMethodDTOList() {
        return methodDTOList;
    }

    public void setMethodDTOList(List<MethodDTO> methodDTOList) {
        this.methodDTOList = methodDTOList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
