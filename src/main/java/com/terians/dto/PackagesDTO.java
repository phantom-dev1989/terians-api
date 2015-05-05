package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@ApiModel("Packages")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PackagesDTO {

    private int size;
    @JsonProperty("data")
    private List<PackageDTO> packageDTOList;

    public PackagesDTO() {
    }

    public List<PackageDTO> getPackageDTOList() {
        return packageDTOList;
    }

    public void setPackageDTOList(List<PackageDTO> packageDTOList) {
        this.packageDTOList = packageDTOList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
