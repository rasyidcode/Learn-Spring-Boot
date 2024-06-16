package com.rasyidcode.projectstructureexample.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getUsers() {
        return this.userRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return this.userRepository.findById(id);
    }

    public void createUser(User user) {
        this.userRepository.save(user);
    }

    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);;
    }

}
