package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@ApiModel("Scans")
public class ScansDTO {

    private int size;
    @JsonProperty("data")
    private List<ScanDTO> scanDTOList;

    public ScansDTO() {
    }

    public List<ScanDTO> getScanDTOList() {
        return scanDTOList;
    }

    public void setScanDTOList(List<ScanDTO> scanDTOList) {
        this.scanDTOList = scanDTOList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
