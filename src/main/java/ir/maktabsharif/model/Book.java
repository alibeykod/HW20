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
    @AttributeOverrides({
    @AttributeOverride( name = "city", column = @Column(name = "publisher_city")),
    @AttributeOverride( name = "street", column = @Column(name = "publisher_street")),
    @AttributeOverride( name = "postalCode", column = @Column(name = "publisher_postal_code"))
    })
    private PublisherAddress publisherAddress;

}
