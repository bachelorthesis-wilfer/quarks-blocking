package wilfer.books;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookService {

    @Inject
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.listAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findByIdOptional(id);
    }

    @Transactional
    public Book createBook(Book book) {
        bookRepository.persist(book);
        return book;
    }

    @Transactional
    public Optional<Book> updateBook(Book book, Long id) {
        return bookRepository.findByIdOptional(id)
                .map(persistedBook -> {
                    persistedBook.setAuthor(book.getAuthor());
                    persistedBook.setTitle(book.getTitle());
                    persistedBook.setPrice(book.getPrice());
                    persistedBook.setIsbn(book.getIsbn());
                    bookRepository.persist(persistedBook);
                    return Optional.of(persistedBook);
                })
                .orElseGet(Optional::empty);

    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
