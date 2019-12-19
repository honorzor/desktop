package com.tic.noli.game.model;


import lombok.*;

@Getter
@Builder
@Setter
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String role;
}
