package ottosulaoja.drsulxx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ottosulaoja.drsulxx.model.User;
import ottosulaoja.drsulxx.repository.UserRepository;

@Service
public class UpdateService {

    private final UserRepository userRepository;

    @Autowired
    public UpdateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Update user by ID.
     * 
     * @param id   The ID of the user to update.
     * @param user Updated user object containing new username and email.
     * @return Updated user object if successful, null if user with given ID is not found.
     */
    public User updateUserById(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    /**
     * Update user by username.
     * 
     * @param username Username of the user to update.
     * @param user     Updated user object containing new username and email.
     * @return Updated user object if successful, null if user with given username is not found.
     */
    public User updateUserByUsername(String username, User user) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    /**
     * Update user by email.
     * 
     * @param email Email of the user to update.
     * @param user  Updated user object containing new username and email.
     * @return Updated user object if successful, null if user with given email is not found.
     */
    public User updateUserByEmail(String email, User user) {
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }
}