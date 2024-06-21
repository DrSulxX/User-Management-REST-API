package ottosulaoja.drsulxx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ottosulaoja.drsulxx.model.User;
import ottosulaoja.drsulxx.repository.UserRepository;

import java.util.List;

@Service
public class UserSearchService {

    private final UserRepository userRepository;

    @Autowired
    public UserSearchService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieve a user by email.
     * @param email The email of the user to retrieve.
     * @return The user if found, otherwise null.
     */
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Retrieve a user by username.
     * @param username The username of the user to retrieve.
     * @return The user if found, otherwise null.
     */
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Retrieve a user by ID.
     * @param id The ID of the user to retrieve.
     * @return The user if found, otherwise null.
     */
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Retrieve all users.
     * @return List of all users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}