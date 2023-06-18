package com.example.SchoolLibrary;

import com.example.SchoolLibrary.enums.Gender;
import com.example.SchoolLibrary.enums.Role;
import com.example.SchoolLibrary.model.*;
import com.example.SchoolLibrary.service.Implementation.LibraryServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

@SpringBootApplication
public class SchoolLibraryApplication {

    public static void main(String[] args) {
        Book book1 = new Book("Essential Physics", "Dr. Anyanko", 2);
        Book book2 = new Book("Essential Chemistry", "Ben", 2);
        Book book3 = new Book("Modern Biology", "Benjamin", 2);
        Book book4 = new Book("New General Mathematics", "Peter", 2);

        ArrayList<Book> bookList = new ArrayList<>();
        LibraryServiceImpl libraryService = new LibraryServiceImpl();

        bookList.add(book3);
        bookList.add(book2);
        bookList.add(book1);
        bookList.add(book4);

        Library library = new Library();
        library.setBooks(bookList);
        System.out.println(library.getBooks());

        Teacher teacher = new Teacher("Peter", Gender.MALE, "Essential Physics",Role.TEACHER );

        Student student1 = new Student("Paul", Gender.MALE, "Modern Biology", Role.JUNIOR);
        Student student2 = new Student("Peace", Gender.FEMALE, "Essential Chemistry", Role.SENIOR);

        Queue<Person> personInQueue = new LinkedList<>();

        personInQueue.add(teacher);
        personInQueue.add(student2);
        personInQueue.add(student1);

        library.setPeopleInQueue(personInQueue);


        PriorityQueue<Person> peopleQueue= new PriorityQueue<>(new UserComparator());
        peopleQueue.addAll(personInQueue);
        library.setPeopleInQueue(peopleQueue);


        System.out.println(library.getPeopleInQueue());



        int size = library.getPeopleInQueue().size();

        for(int x=0; x<size; x++){
            System.out.println(libraryService.borrowBook(library));
            library.getPeopleInQueue().poll();
        }
    }
}
