package ir.maktabsharif.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false , updatable = false)
    private UUID id;


    private String ISBN;

    @Enumerated(value = EnumType.STRING)
    private BookStockStatus bookStockStatus;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int publicationYear;

    @Column(nullable = false)
    private double price;

    @Embedded
    @AttributeOverrides({
    @AttributeOverride( name = "city", column = @Column(name = "publisher_city")),
    @AttributeOverride( name = "street", column = @Column(name = "publisher_street")),
    @AttributeOverride( name = "postalCode", column = @Column(name = "publisher_postal_code"))
    })
    private PublisherAddress publisherAddress;

    public Book(String ISBN , BookStockStatus bookStockStatus , String title , int publicationYear , double price , PublisherAddress publisherAddress){
        this.ISBN = ISBN;
        this.bookStockStatus = bookStockStatus;
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
        this.publisherAddress = publisherAddress;
    }


    public Book (){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public BookStockStatus getBookStockStatus() {
        return bookStockStatus;
    }

    public void setBookStockStatus(BookStockStatus bookStockStatus) {
        this.bookStockStatus = bookStockStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PublisherAddress getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(PublisherAddress publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(ISBN , book.ISBN) && publicationYear == book.publicationYear && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN , title, publicationYear);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                "ISBN=" + ISBN +
                ", bookStockStatus=" + bookStockStatus +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", price=" + price +
                ", publisherAddress=" + publisherAddress +
                '}';
    }
}
