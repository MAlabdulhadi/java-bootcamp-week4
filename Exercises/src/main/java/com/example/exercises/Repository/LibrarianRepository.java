package com.example.exercises.Repository;

import com.example.exercises.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

    Librarian findLibrarianById(Integer id);

    @Query("SELECT Librarian from Librarian Librarian where Librarian.userName=?1 and Librarian.password=?2 ")
    Librarian checkLogin(String username, String passwors);

    Librarian findLibrarianByEmail(String email);


}
