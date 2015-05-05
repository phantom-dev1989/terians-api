package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@ApiModel("Issues")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class IssuesDTO {

    private int size;
    @JsonProperty("data")
    private List<IssueDTO> issueDTOList;

    public IssuesDTO() {
    }

    public List<IssueDTO> getIssueDTOList() {
        return issueDTOList;
    }

    public void setIssueDTOList(List<IssueDTO> issueDTOList) {
        this.issueDTOList = issueDTOList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
