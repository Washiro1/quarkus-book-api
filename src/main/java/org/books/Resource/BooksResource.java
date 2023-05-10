package org.books.Resource;

import java.util.List;

import org.books.entity.Book;
import org.books.service.BooksService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/book")
public class BooksResource {

    @Inject
    BooksService service;

    @GET
    public List<Book> list() {
        return service.list();
    }
    
    @POST
    public Book create(Book book) {
        return service.create(book);
    }

}
