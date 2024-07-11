package com.example.Field.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AreaCreateDto {
    private Integer userId;
    private String name;
    private String soilType;
    private String sowingDate;
}
