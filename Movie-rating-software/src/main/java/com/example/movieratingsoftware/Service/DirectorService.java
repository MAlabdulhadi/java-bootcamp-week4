package com.example.movieratingsoftware.Service;


import com.example.movieratingsoftware.ApiException.ApiException;
import com.example.movieratingsoftware.Model.Director;
import com.example.movieratingsoftware.Repository.DirectorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DirectorService {

    private final DirectorRepository directorRepository;

    public List<Director> getDirectors() {
        List<Director> directors = directorRepository.findAll();
        if (directors.isEmpty()) {
            throw new ApiException("not have any director");
        }
        return directors;
    }

    public void addDirector(Director director) {
        directorRepository.save(director);
    }

    public void updateDirector(Integer id, Director director) {
        Director oldDirector = directorRepository.findDirectorById(id);
        if (director == null) {
            throw new ApiException("do not have any director by this id");
        }
        oldDirector.setName(director.getName());
        directorRepository.save(oldDirector);
    }

    public void deleteDirector(Integer id) {
        Director oldDirector = directorRepository.findDirectorById(id);
        if (oldDirector == null) {
            throw new ApiException("do not have any director by this id");
        }
        directorRepository.delete(oldDirector);
    }


}
