package ottosulaoja.drsulxx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ottosulaoja.drsulxx.model.User;
import ottosulaoja.drsulxx.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Create a new user.
     * @param user The user object to create.
     * @return The created user object.
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Retrieve all users.
     * @return List of all users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieve a user by ID.
     * @param id The ID of the user to retrieve.
     * @return The user if found, otherwise null.
     */
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    /**
     * Update an existing user.
     * @param id The ID of the user to update.
     * @param user Updated user object.
     * @return Updated user object if successful, otherwise null.
     */
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id); // Ensure the user object has the correct ID
            return userRepository.save(user);
        } else {
            return null; // User with given ID not found
        }
    }

    /**
     * Delete a user by ID.
     * @param id The ID of the user to delete.
     * @return True if deletion was successful, false otherwise.
     */
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false; // User with given ID not found
        }
    }

    /**
     * Create multiple users in bulk.
     * @param users List of users to create.
     * @return List of created users.
     */
    public List<User> createUsers(List<User> users) {
        // Save each user in the list individually
        for (User user : users) {
            userRepository.save(user);
        }
        return users; // Return the list of created users
    }
}