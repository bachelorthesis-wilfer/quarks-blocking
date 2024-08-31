package wilfer.books;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private int price;
    private int isbn;

    public Book() {
    }

    public Book(Long id, String author, String title, int price, int isbn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.price = price;
        this.isbn = isbn;
    }

    public Book(String author, String title, int price, int isbn) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.isbn = isbn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getIsbn() {
        return isbn;
    }
}
