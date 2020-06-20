package com.sirius.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User extends Account{
    private String nickname;
    private String telephone;
    private String address;
}
