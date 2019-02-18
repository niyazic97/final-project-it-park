package ru.itpark.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private String name;
    private String surName;
    private Integer yearOfBirth;
    private String email;
}
