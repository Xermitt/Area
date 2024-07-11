package com.example.Field.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AreaDto {
    private Integer id;
    private Integer userId;
    private String name;
    private String solidType;
    private String sowingDate;
}
