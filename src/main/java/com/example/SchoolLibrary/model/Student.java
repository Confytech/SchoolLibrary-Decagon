package com.example.SchoolLibrary.model;

import com.example.SchoolLibrary.enums.Gender;
import com.example.SchoolLibrary.enums.Role;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter



public class Student extends Person {
    public Student(String name, Gender gender, String book, Role role) {

        super(name, gender, book, role);
    }
}
