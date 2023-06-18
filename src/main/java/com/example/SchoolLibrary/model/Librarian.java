package com.example.SchoolLibrary.model;

import com.example.SchoolLibrary.enums.Gender;
import com.example.SchoolLibrary.enums.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString



public class Librarian extends Person{
    public Librarian(String name, Gender gender, String book, Role role) {
        super(name, gender, book, role);
    }


}
