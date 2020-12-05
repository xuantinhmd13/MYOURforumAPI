package myour.myourforumapi.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myour.myourforumapi.model.User;
import myour.myourforumapi.repository.UserRepository;
import myour.myourforumapi.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    //REGISTER.
    @PostMapping("/users/register")
    public String registerUser(@RequestBody User newUser) {
        return userService.registerUser(newUser);
    }

    //LOGIN.
    @PostMapping("/users/login")
    public ResponseEntity<?> login(String email) {
        if (userRepository.existsByEmail(email))
            return new ResponseEntity<>(userRepository.findByEmail(email), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
