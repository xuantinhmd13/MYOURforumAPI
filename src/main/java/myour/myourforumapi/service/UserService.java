package myour.myourforumapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import myour.myourforumapi.model.User;
import myour.myourforumapi.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean isEmailExisted(String email) {
        if (userRepository.existsByEmail(email)) return true;
        else return false;
    }

    public boolean isUserNameExisted(String userName) {
        if (userRepository.existsByUserName(userName)) return true;
        else return false;
    }

    public String registerUser(User newUser) {
        if (isEmailExisted(newUser.getEmail())) return "email";
        if (isUserNameExisted(newUser.getUserName())) return "username";
        userRepository.save(newUser);
        if (userRepository.existsByEmail(newUser.getEmail())) return "OK";
        else return "FAIL";
    }
}
