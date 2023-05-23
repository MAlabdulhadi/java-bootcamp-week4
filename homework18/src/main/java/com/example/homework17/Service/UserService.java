package com.example.homework17.Service;

import com.example.homework17.ApiException.ApiException;
import com.example.homework17.Model.User;
import com.example.homework17.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean update(Integer id, User user) {
        User oldUser = userRepository.getById(id);
        if (oldUser == null) {
            return false;
        }
        oldUser.setUserName(user.getUserName());
        oldUser.setName(user.getName());
        oldUser.setAge(user.getAge());
        oldUser.setRole(user.getRole());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        userRepository.save(oldUser);
        return true;
    }

    public boolean delete(Integer id) {
        User oldUser = userRepository.getById(id);
        if (oldUser == null) {
            return false;
        }
        userRepository.delete(oldUser);
        return true;
    }

    public User singIn(String username, String password) {
        User user = userRepository.singIn(username, password);
        if (user == null) {
            throw new ApiException("user name or password not vaild");
        }
        return user;
    }

    public User getUserByEmail(String emaill) {
        User user = userRepository.getUserByEmail(emaill);
        if (user == null) {
            throw new ApiException("email not found");
        }
        return user;
    }

    public List<User> getAllUserByRole(String role) {
        List<User> users = userRepository.getAllUserByRole(role);
        if (users.isEmpty()) {
            throw new ApiException("not have any user by this role");
        }
        return users;
    }

    public List<User> getAllUserByAgeGreaterThanEqual(int age) {
        List<User> users = userRepository.getAllUserByAgeGreaterThanEqual(age);
        if (users.isEmpty()) {
            throw new ApiException("do not have any user by this age or above");
        }
        return users;
    }


}
