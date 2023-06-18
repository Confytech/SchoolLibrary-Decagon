package com.example.SchoolLibrary.service;

import com.example.SchoolLibrary.model.Library;

public interface LibraryService {


    public String borrowBook(Library library);

    String sortQueue(Library library);
}


