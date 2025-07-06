package com.reksoft.exporter.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class RatingDto {
    private Integer id;
    private Integer score;
    private OffsetDateTime atMoment;
    private String teamName;
    private Integer teamId;
}