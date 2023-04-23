package com.istad.projectthymeleaf.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @NotNull(message = "Name is required..!")
    private User user;
    private String thumbnail;
    private UUID uuid;
    @NotBlank(message = "Title is required..!")
    private String title;
    @NotEmpty(message = "Categories is required..!")
    private List<Categories> categoriesList;
//    @NotEmpty(message = "Name is required..!")
//    private List<User> user;
//    @NotBlank
//    private String thumbnail;
//    private UUID uuid;
//    @NotBlank(message = "Title is required..!")
//    private String title;
//    @NotEmpty
//    private List<Categories> categories;

}
