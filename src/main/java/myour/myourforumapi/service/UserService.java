package myour.myourforumapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean isUsernameExisted(String userName) {
        if (userRepository.existsByUsername(userName)) return true;
        else return false;
    }

    public String register(User newUser) {
        if (isEmailExisted(newUser.getEmail())) return "email";
        if (isUsernameExisted(newUser.getUsername())) return "username";
        userRepository.save(newUser);
        if (userRepository.existsByEmail(newUser.getEmail())) return "OK";
        else return "FAIL";
    }
}
