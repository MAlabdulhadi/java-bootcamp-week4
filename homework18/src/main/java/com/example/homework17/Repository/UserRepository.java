package com.example.homework17.Repository;

import com.example.homework17.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);

    @Query("SELECT user from User user where user.userName=?1 and user.password=?2 ")
    User singIn(String userName, String password);

    //@Query("SELECT user from User user where user.email=?1")
    User getUserByEmail(String email);

    //@Query("SELECT user from User user where user.role=?1")
    List<User> getAllUserByRole(String role);

    //@Query("SELECT user from User user where user.email=?1")
    List<User> getAllUserByAgeGreaterThanEqual(int age);


}
