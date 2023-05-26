package com.example.movieratingsoftware.Controller;


import com.example.movieratingsoftware.Model.Director;
import com.example.movieratingsoftware.Service.DirectorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
@AllArgsConstructor
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping("/get")
    public ResponseEntity getDirectors() {
        List<Director> directors = directorService.getDirectors();
        return ResponseEntity.status(200).body(directors);
    }

    @PostMapping("/add")
    public ResponseEntity addDirector(@Valid @RequestBody Director director) {
        directorService.addDirector(director);
        return ResponseEntity.status(200).body("done add");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDirector(@PathVariable Integer id, @Valid @RequestBody Director director) {
        directorService.updateDirector(id, director);
        return ResponseEntity.status(200).body("done updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDirector(@PathVariable Integer id) {
        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("done deleted");
    }


}
