package com.example.Field;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Builder
@AllArgsConstructor
//@Table(name = "Areas")
@Getter
@Setter
public class Area {
    private Integer id;
    private Integer userId;
    private String title;
    private String soil_type;
    private Date sowing_date;
}
