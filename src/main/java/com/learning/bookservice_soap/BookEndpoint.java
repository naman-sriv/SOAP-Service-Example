package com.learning.bookservice_soap;

import com.example.soapbookservice.books.*;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/soapbookservice";

    @PayloadRoot(namespace=NAMESPACE_URI, localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getBookResponse(@RequestPayload GetBookRequest request) {
        GetBookResponse response = new GetBookResponse();
        Book book = new Book();
        book.setId(request.getId());
        book.setTitle("The hitchhiker's guide to the Galaxy");
        book.setAuthor("Douglas Adams");
        response.setBook(book);
        return response;
    }

}
