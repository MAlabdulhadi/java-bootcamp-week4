package com.example.exercises.Controller;

import com.example.exercises.Model.Book;
import com.example.exercises.Model.Librarian;
import com.example.exercises.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/librarian")
@AllArgsConstructor
public class LibrarianController {

    private final LibrarianService librarianService;

    @GetMapping("/get-all-librarians")
    public ResponseEntity getAllBooks() {
        List<Librarian> librarians = librarianService.getAllLibrarian();
        return ResponseEntity.status(200).body(librarians);
    }

    @PostMapping("/add-librarian")
    public ResponseEntity addBook(@RequestBody @Valid Librarian librarian) {
        librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body("done add");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @Valid @RequestBody Librarian librarian) {
        librarianService.updateLibrarian(id, librarian);
        return ResponseEntity.status(200).body("done update");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id) {
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body("done delete");
    }

    @GetMapping("/get-librarian-by-id/{id}")
    public ResponseEntity getLibrarianById(@PathVariable Integer id) {
        Librarian librarian = librarianService.getLibrarianById(id);
        return ResponseEntity.status(200).body(librarian);
    }

    @GetMapping("/check-login/{username}/{password}")
    public ResponseEntity checkLogin(@PathVariable String username, @PathVariable String password) {
        Librarian librarian = librarianService.checkLogin(username, password);
        return ResponseEntity.status(200).body(librarian);
    }

    @GetMapping("/get-by-email/{email}")
    public ResponseEntity findLibrarianByEmail(@PathVariable String email) {
        Librarian librarian = librarianService.findLibrarianByEmail(email);
        return ResponseEntity.status(200).body(librarian);
    }

}
