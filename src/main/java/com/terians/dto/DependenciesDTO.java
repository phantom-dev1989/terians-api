package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@ApiModel("Dependencies")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DependenciesDTO {

    private int size;
    @JsonProperty("data")
    private List<DependencyDTO> dependencyDTOList;

    public DependenciesDTO() {
    }

    public List<DependencyDTO> getDependencyDTOList() {
        return dependencyDTOList;
    }

    public void setDependencyDTOList(List<DependencyDTO> dependencyDTOList) {
        this.dependencyDTOList = dependencyDTOList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
