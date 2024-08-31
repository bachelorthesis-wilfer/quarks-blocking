package wilfer.books;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import static jakarta.ws.rs.core.Response.Status.CREATED;
import static jakarta.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/books")
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    public Response getAllBooks() {
        return Response.ok(bookService.getAllBooks()).build();
    }

    @GET
    @Path("{id}")
    @RunOnVirtualThread
    public Response getBookById(@PathParam("id") Long id) {
        var bookOptional = bookService.getBookById(id);
        return bookOptional.map(Response::ok)
                .orElseGet(() -> Response.status(NOT_FOUND)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @RunOnVirtualThread
    public Response addBook(Book book) {
        return Response.ok(bookService.createBook(book)).status(CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @RunOnVirtualThread
    public Response updateBook(@PathParam("id") Long id, Book book) {
        var updatedBook = bookService.updateBook(book, id);
        return updatedBook.map(Response::ok)
                .orElseGet(() -> Response.status(NOT_FOUND)).build();
    }

    @DELETE
    @Path("{id}")
    @RunOnVirtualThread
    public Response deleteBook(@PathParam("id") Long id) {
        bookService.deleteBook(id);
        return Response.noContent().build();
    }
}
