package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@ApiModel("Vulnerabilities")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class VulnerabilitiesDTO {

    private int size;
    @JsonProperty("data")
    private List<VulnerabilityDTO> vulnerabilityDTOList;

    public VulnerabilitiesDTO() {

    }

    public List<VulnerabilityDTO> getVulnerabilityDTOList() {
        return vulnerabilityDTOList;
    }

    public void setVulnerabilityDTOList(
            List<VulnerabilityDTO> vulnerabilityDTOList) {
        this.vulnerabilityDTOList = vulnerabilityDTOList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
