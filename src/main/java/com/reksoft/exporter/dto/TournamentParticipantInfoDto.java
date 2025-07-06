package com.reksoft.exporter.dto;

import lombok.Data;

@Data
public class TournamentParticipantInfoDto {
    private Integer id;
    private Integer standing;
    private Integer place;
    private Integer teamId;
    private String teamName;
}