package com.sirius.entity;

import lombok.Data;

@Data
public class User extends Account{
    private long userid;
    private String username;
    private String password;
    private String nickname;
    private String telephone;
    private String address;
}
