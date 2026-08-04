package ir.maktabsharif.repository.impl;

import ir.maktabsharif.model.Book;
import ir.maktabsharif.repository.BookRepository;
import ir.maktabsharif.util.HibernateUtil;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public Book save(Book entity) {
        return HibernateUtil.inTxReturn(entityManager -> {
            entityManager.persist(entity);
            return entity;
        });
    }

    @Override
    public Book update(Book entity) {
        return HibernateUtil.inTxReturn(entityManager -> {
            Book book = entityManager.find(Book.class, entity.getId());
            if (book == null) {
                return null;
            }
            book.setTitle(entity.getTitle());
            book.setISBN(entity.getISBN());
            book.setBookStockStatus(entity.getBookStockStatus());
            book.setPublisherAddress(entity.getPublisherAddress());
            book.setPrice(entity.getPrice());
            book.setPublicationYear(entity.getPublicationYear());
            return book;
        });
    }

    @Override
    public Book findById(long id) {
        return HibernateUtil.inTxReturn(entityManager -> entityManager.find(Book.class, id));
    }

    @Override
    public void delete(long id) {
        HibernateUtil.inTxReturn(entityManager -> {
            Book book = entityManager.find(Book.class, id);
            if (book == null) {
                return null;
            }
            entityManager.remove(book);
            return id;
        });
    }

    @Override
    public List<Book> findAll() {
        return HibernateUtil.inTxReturn(entityManager -> entityManager.createQuery("FROM Book ", Book.class).getResultList());
    }
}
