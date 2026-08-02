package ir.maktabsharif.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false , updatable = false)
    private UUID id;

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

    public Book(BookStockStatus bookStockStatus , String title , int publicationYear , double price , PublisherAddress publisherAddress){
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
}
