package com.example.exercises.Service;

import com.example.exercises.ApiException.ApiException;
import com.example.exercises.Model.Book;
import com.example.exercises.Model.Librarian;
import com.example.exercises.Repository.LibrarianRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibrarianService {

    private final LibrarianRepository librarianRepository;

    public List<Librarian> getAllLibrarian() {
        List<Librarian> Librarian = librarianRepository.findAll();
        if (Librarian.isEmpty()) {
            throw new ApiException("do not have any Librarian");
        }
        return Librarian;
    }

    public void addLibrarian(Librarian librarian) {
        librarianRepository.save(librarian);
    }

    public void updateLibrarian(Integer id, Librarian librarian) {
        Librarian oldLibrarian = librarianRepository.findLibrarianById(id);
        if (oldLibrarian == null) {
            throw new ApiException("do not hava any librarian for this id");
        }
        oldLibrarian.setName(librarian.getName());
        oldLibrarian.setEmail(librarian.getEmail());
        oldLibrarian.setUserName(librarian.getUserName());
        oldLibrarian.setPassword(librarian.getPassword());
        librarianRepository.save(oldLibrarian);
    }

    public void deleteLibrarian(Integer id) {
        Librarian librarian = librarianRepository.findLibrarianById(id);
        if (librarian == null) {
            throw new ApiException("do not hava any librarian for this id");
        }
        librarianRepository.delete(librarian);
    }

    public Librarian getLibrarianById(Integer id) {
        Librarian librarian = librarianRepository.findLibrarianById(id);
        if (librarian == null) {
            throw new ApiException("do not have any Librarian by this id");
        }
        return librarian;

    }

    public Librarian checkLogin(String username, String password) {
        Librarian librarian = librarianRepository.checkLogin(username, password);
        if (librarian == null) {
            throw new ApiException("username or password wrong");
        }
        return librarian;
    }

    public Librarian findLibrarianByEmail(String email) {
        Librarian librarian = librarianRepository.findLibrarianByEmail(email);
        if (librarian == null) {
            throw new ApiException("do not have any librarian by this email");
        }
        return librarian;
    }


}
