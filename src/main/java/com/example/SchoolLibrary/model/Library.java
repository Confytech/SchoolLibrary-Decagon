package com.example.SchoolLibrary.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class Library {


    private Queue<Person> peopleInQueue = new LinkedList<>();
    private List<Book> books = new ArrayList<>();

    public Object getLibrarian() {
    }
}


