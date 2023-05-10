package org.books.service;

import java.util.List;
import java.util.Objects;

import org.books.entity.Book;
import org.books.repository.BooksRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BooksService {

    @Inject
    BooksRepository repository;

    public List<Book> list() {
        return repository.listAll();
    }

    @Transactional
    public Book create(Book book) {
        if (Objects.nonNull(book.getId())) {
            throw new IllegalStateException("Id should be null!");
        }
        repository.persist(book);
        return book;
    }

    public Book get(Long bookId) {
        return repository.findById(bookId);
    }

    public boolean remove(Long bookId) {
        return repository.deleteById(bookId);
    }
    
}
