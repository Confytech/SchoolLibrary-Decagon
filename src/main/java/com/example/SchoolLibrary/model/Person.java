package com.example.SchoolLibrary.model;

import com.example.SchoolLibrary.enums.Gender;
import com.example.SchoolLibrary.enums.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString


public class Person {
    private String name;
    private Gender gender;
    private String book;
    private Role role;

    public Person(String name, Gender gender, String book, Role role) {
        this.name = name;
        this.gender = gender;
        this.book = book;
        this.role = role;
    }

    public static <U extends Comparable<? super U>, T> U getPersonLevel(T t) {
        return null;
    }
}
