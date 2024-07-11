package com.example.Field.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AreaUpdateDto {
    private Integer areaId;
    private String solidType;
    private String sowingDate;
}
