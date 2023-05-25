package com.example.exercises.Service;

import com.example.exercises.ApiException.ApiException;
import com.example.exercises.Model.Book;
import com.example.exercises.Repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            throw new ApiException("do not have any book");
        }
        return books;
    }

    public void addBook(Book newbook) {
        bookRepository.save(newbook);
    }

    public void updateBook(Integer id, Book book) {
        Book oldBook = bookRepository.findBookById(id);
        if (oldBook == null) {
            throw new ApiException("do not hava any book for this id");
        }
        oldBook.setAuthor(book.getAuthor());
        oldBook.setISBN(book.getISBN());
        oldBook.setCategory(book.getCategory());
        oldBook.setNumberOfPages(book.getNumberOfPages());
        oldBook.setTitle(book.getTitle());
        bookRepository.save(oldBook);
    }

    public void deleteBook(Integer id) {
        Book book = bookRepository.findBookById(id);
        if (book == null) {
            throw new ApiException("do not hava any book for this id");
        }
        bookRepository.delete(book);
    }

    public List<Book> getAllByCategory(String category) {
        List<Book> books = bookRepository.findAllByCategory(category);
        if (books.isEmpty()) {
            throw new ApiException("the category do not have any book");
        }
        return books;
    }

    public List<Book> findBooksByNumberOfPagesGreaterThanEqual(Integer numberOfPages) {
        List<Book> books = bookRepository.findBooksByNumberOfPagesGreaterThanEqual(numberOfPages);
        if (books.isEmpty()) {
            throw new ApiException("do not have any book page >=500");
        }
        return books;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> book = bookRepository.findBooksByAuthor(author);
        if (book == null) {
            throw new ApiException("do not have any book for this author");
        }
        return book;

    }

    public Book findBooksByTitle(String title) {
        Book book = bookRepository.findBooksByTitle(title);
        if (book == null) {
            throw new ApiException("do not have any book by this title");
        }
        return book;

    }

}
