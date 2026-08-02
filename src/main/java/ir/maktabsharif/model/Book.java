package ir.maktabsharif.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private UUID id;

    @Enumerated(value = EnumType.STRING)
    private BookStockStatus bookStockStatus;

    @Column(nullable = false)
    private String title;

    private int publicationYear;

    private double price;

    @Embedded
    private PublisherAddress publisherAddress;

}
