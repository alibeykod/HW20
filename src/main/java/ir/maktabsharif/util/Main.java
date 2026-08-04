package ir.maktabsharif.util;

import ir.maktabsharif.exception.BookNotFoundException;
import ir.maktabsharif.exception.InvalidDataException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.model.BookStockStatus;
import ir.maktabsharif.model.PublisherAddress;
import ir.maktabsharif.service.impl.BookServiceImpl;

public class Main {
    public static void main(String[] args) throws BookNotFoundException {
        BookServiceImpl bookService = new BookServiceImpl();

        System.out.println("==========     Main Application     ==========");
//1. Create at least three different books.
        Book book1 = new Book("testISBN1", BookStockStatus.IN_STOCK, "Hemology", 2000, 200.25, new PublisherAddress("Newyork", "21JumpStreet", "123"));
        Book book2 = new Book("testISBN2", BookStockStatus.OUT_OF_STOCK, "IT", 1921, 50000, new PublisherAddress("Jiroft", "MirzayeShiraziStreet", "2"));
        Book book3 = new Book("testISBN3", BookStockStatus.COMING_SOON, "TV", 1820, 150, new PublisherAddress("Petersburg", "ShohadayeMoscow", "10"));

//        2. Store them in a database.
        try {
            bookService.save(book1);
            bookService.save(book2);
            bookService.save(book3);
        } catch (BookNotFoundException e) {
            throw new InvalidDataException("Invalid Data");
        }
        //3. Retrieve one book by id.
        Book updateBook = bookService.findById(1);
        System.out.println(updateBook);
/*
        System.out.println(bookService.findAll());
*/
        //4. Change some information of the retrieved book.\
        updateBook.setPrice(252525.252);
        //5. 5. Save the changes.
        try {
            bookService.update(updateBook);
        } catch (BookNotFoundException e) {
            throw new InvalidDataException("Wrong Data");
        }
//        6. Remove one book.

        bookService.delete(2);

        //7. Verify the final database state.
        bookService.findAll().forEach(System.out::println);


//        Entity Life Cycle Test
        /*        1. Create a new Book object.*/

        Book newObject = new Book("ISBN1234", BookStockStatus.IN_STOCK, "new title", 2000, 550.0, new PublisherAddress("test city", "test street", "123456"));

        //save it
        HibernateUtil.inTxReturn(entityManager -> {
            entityManager.persist(newObject);
            //3. Modify one of its fields before finishing the transaction.
            newObject.setTitle("Modify a field of Object");
            //4. Separate the object from Hibernate management.
            entityManager.detach(newObject);
            //5. Modify the object again.
            newObject.setPublicationYear(3002);
            //6. Commit the transaction.
            return newObject;
        });
        //7. Observe which changes are stored.
        bookService.findAll().forEach(System.out::println);

//8. Make the object managed again and save the final changes.
        HibernateUtil.inTxReturn(entityManager -> entityManager.merge(newObject));

        bookService.findAll().forEach(System.out::println);

    }


}
