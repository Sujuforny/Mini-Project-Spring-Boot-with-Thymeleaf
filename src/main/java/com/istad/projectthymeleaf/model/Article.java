package com.istad.projectthymeleaf.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @NotBlank(message = "Name is required..!")
    private String name;
    @NotBlank
    private String thumbnail;
    private String gender;
    private UUID uuid;
    @NotBlank(message = "Title is required..!")
    private String title;
    @NotEmpty
    private List<String> categoriesList;

}
