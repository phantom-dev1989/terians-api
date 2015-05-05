package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@ApiModel("Classes")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClazzesDTO {

    private int size;
    @JsonProperty("data")
    private List<ClazzDTO> clazzDTOList;

    public ClazzesDTO() {
    }

    public ClazzesDTO(int size, List<ClazzDTO> clazzDTOList) {
        this.size = size;
        this.clazzDTOList = clazzDTOList;
    }

    public List<ClazzDTO> getClazzDTOList() {
        return clazzDTOList;
    }

    public void setClazzDTOList(List<ClazzDTO> clazzDTOList) {
        this.clazzDTOList = clazzDTOList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
