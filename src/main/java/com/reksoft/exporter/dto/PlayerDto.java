package com.reksoft.exporter.dto;

import lombok.Data;

@Data
public class PlayerDto {
    private Integer id;
    private String combinedName;
    private String nickName;
    private Integer country;
    private String teamName;
}
