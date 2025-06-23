package com.fabipl.fab11.dto;

import com.fabipl.fab11.model.MatchModel;
import lombok.Data;

import java.util.List;

@Data
public class MatchResponse {
    private List<MatchModel> content;
    private int pageNo;
    private int pageSize;
    private long totalItems;
    private int totalPages;
    private boolean last;
}
