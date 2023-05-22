package com.example.homework17.Controller;

import com.example.homework17.Model.User;
import com.example.homework17.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("done add");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdate = userService.update(id, user);
        if (isUpdate) {
            userService.update(id, user);
            return ResponseEntity.status(200).body("done update");
        }
        return ResponseEntity.status(400).body("user not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        boolean isDelete = userService.delete(id);
        if (isDelete) {
            userService.delete(id);
            return ResponseEntity.status(200).body("done delete");
        }
        return ResponseEntity.status(400).body("wrong Id ");

    }

}
