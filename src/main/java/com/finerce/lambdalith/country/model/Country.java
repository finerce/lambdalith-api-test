package com.finerce.lambdalith.country.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country {
    private String name;
    private String capital;
    private String region;
    private long population;
}