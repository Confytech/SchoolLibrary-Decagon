package com.example.SchoolLibrary.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Book {
    private String title;
    private String author;
    private int copiesAvailable;
}
