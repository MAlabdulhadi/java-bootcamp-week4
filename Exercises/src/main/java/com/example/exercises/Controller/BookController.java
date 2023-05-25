package com.example.exercises.Controller;


import com.example.exercises.ApiResponse.ApiResponse;
import com.example.exercises.Model.Book;
import com.example.exercises.Service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping("/get-all-books")
    public ResponseEntity getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.status(200).body(books);
    }

    @PostMapping("/add-book")
    public ResponseEntity addBook(@RequestBody @Valid Book book) {
        bookService.addBook(book);
        return ResponseEntity.status(200).body("done add");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @Valid @RequestBody Book book) {
        bookService.updateBook(id, book);
        return ResponseEntity.status(200).body("done update");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("done delete");
    }

    @GetMapping("/get-all-by-category/{category}")
    public ResponseEntity getAllByCategory(@PathVariable String category) {
        List<Book> books = bookService.getAllByCategory(category);
        return ResponseEntity.status(200).body(books);

    }

    @GetMapping("/get-by-page/{numberOfPage}")
    public ResponseEntity findBooksByNumberOfPagesGreaterThanEqual(@PathVariable Integer numberOfPage) {
        List<Book> books = bookService.findBooksByNumberOfPagesGreaterThanEqual(numberOfPage);
        return ResponseEntity.status(200).body(books);
    }

    @GetMapping("/get-by-author/{author}")
    public ResponseEntity findBooksByAuthor(@PathVariable String author) {
        List<Book> book = bookService.findBooksByAuthor(author);
        return ResponseEntity.status(200).body(book);

    }

    @GetMapping("/get-by-title/{title}")
    public ResponseEntity findBooksByTitle(@PathVariable String title) {
        Book book = bookService.findBooksByTitle(title);
        return ResponseEntity.status(200).body(book);

    }


}
