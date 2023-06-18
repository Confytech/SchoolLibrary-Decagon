package com.example.SchoolLibrary.service.Implementation;

import com.example.SchoolLibrary.model.Book;
import com.example.SchoolLibrary.model.Librarian;
import com.example.SchoolLibrary.model.Library;
import com.example.SchoolLibrary.model.Person;
import com.example.SchoolLibrary.service.LibraryService;

import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Predicate;

public class LibraryServiceImpl implements LibraryService {




//    @Override
//    public String borrowBook(Library library) {
//        int bookSize = library.getBooks().size();
//        int counter = 0;
//
//        Person person;
//
//        person = library.getPeopleInQueue().peek();
//        Book book;
//
//        while (bookSize > 0) {
//            book = library.getBooks().get(counter);
//
//            if (book.getTitle().equals(person.getBook()) && book.getCopiesAvailable() > 0) {
//
//                int currentNumberOfBookCopies = book.getCopiesAvailable() - 1;
//                book.setCopiesAvailable(currentNumberOfBookCopies);
//
//                return person.getName() + " Borrowed " + person.getBook();
//            }
//            counter++;
//            bookSize--;
//        }
//        return "Book unavailable";
//    }
//}




    public String borrowBook(Library library) {
        Object PersonLevel = null;

        Optional<Librarian> librarian = Optional.ofNullable(library.getLibrarian())
                .filter(person -> person.getPersonLevel().equals(PersonLevel.LIBRARIAN));

        if (librarian.isPresent()) {
            Optional<Person> personInQueue = Optional.ofNullable(library.getPeopleInQueue().peek());
            return personInQueue.map(person -> {
                Optional<Book> availableBook = library.getBooks().stream()
                        .filter(book -> book.getTitle().equals(person.getBook()))
                        .filter(book -> book.getCopiesAvailable() > 0)
                        .findFirst();

                if (availableBook.isPresent()) {
                    Book book = availableBook.get();
                    int currentNumberOfBookCopies = book.getCopiesAvailable() - 1;
                    book.setCopiesAvailable(currentNumberOfBookCopies);
                    return person.getName() + " Borrowed " + person.getBook();
                }
                return person.getName() + " We do not have the book you want";
            }).orElse("");
        }
        return "You are not a librarian.";
    }

    @Override
    public String sortQueue(Library library) {

        Queue<Person> priorityQueueOfPersons = new PriorityQueue<>((Comparator.comparing(Person::getPersonLevel)));
        priorityQueueOfPersons.addAll(library.getPeopleInQueue());
        library.setPeopleInQueue(priorityQueueOfPersons);

        return borrowBook(library);
    }

}