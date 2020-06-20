package com.sirius.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Restaurant extends Account{
    private String storename;
    private String telephone;
    private String address;
    private int rating;
    private String description;
    private int state;
    private long persontime;
}
