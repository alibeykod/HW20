package ir.maktabsharif.service.impl;

import ir.maktabsharif.exception.BookNotFoundException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.repository.impl.BookRepositoryImpl;
import ir.maktabsharif.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookRepositoryImpl bookRepository = new BookRepositoryImpl();

    public void validations(Book book) throws BookNotFoundException {
        if (book.getTitle() == null || book.getTitle().isBlank()) {
            throw new BookNotFoundException("Book did Not Found !!!");
        }
        if (book.getPublicationYear() <= 0) {
            throw new BookNotFoundException("Book did Not Found !!!");
        }
        if (book.getPrice() < 0) {
            throw new BookNotFoundException("Book did Not Found !!!");
        }
        if (book.getPublisherAddress() == null) {
            throw new BookNotFoundException("Book did Not Found !!!");
        }
    }

    @Override
    public void save(Book entity) throws BookNotFoundException {
        validations(entity);
        bookRepository.save(entity);
    }

    @Override
    public Book update(Book entity) throws BookNotFoundException {
        validations(entity);
        Book book = bookRepository.update(entity);
        if (book == null) {
            throw new BookNotFoundException("Book did Not Found !!!");
        }
        return book;
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public long delete(long id) {
        bookRepository.delete(id);
        return id;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }



}
