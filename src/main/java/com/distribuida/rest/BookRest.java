package com.distribuida.rest;

import com.distribuida.db.Book;
import com.distribuida.servicios.BookRepository;
import io.helidon.common.reactive.Multi;
import io.helidon.common.reactive.Single;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


@Path("/books")
public class BookRest {

@Inject
    private BookRepository bookService;


    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<Book> findAll(){
        // dbConfig.test();
        return bookService.findAll();
    }



    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Single<Book> findById(@PathParam("id") Integer id){

        return bookService.findById(id);
    }
    

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Single<Book> pushBook(Book book){
        return bookService.pushBook(book);
    }
    @DELETE
    @Path("/{id}")
    public Single<Long> deleteBook(@PathParam("id") Integer id){
        return bookService.deleteBook(id);
    }
    

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Single<Long> editBook(Book book, @PathParam("id") Integer id){
        return bookService.editBook(book, id);
    }
    /*
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book editBook(Book book, @PathParam("id") Integer id){
        return bookService.editBook(book, id);
    }*/


}
