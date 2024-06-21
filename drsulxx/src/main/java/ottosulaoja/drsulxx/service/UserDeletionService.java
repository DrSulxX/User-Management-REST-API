package ottosulaoja.drsulxx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ottosulaoja.drsulxx.repository.UserRepository;

@Service
public class UserDeletionService {

    private final UserRepository userRepository;

    @Autowired
    public UserDeletionService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Delete a user by email.
     * @param email The email of the user to delete.
     * @return true if deletion was successful, false otherwise.
     */
    public boolean deleteByEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            userRepository.deleteByEmail(email);
            return true;
        }
        return false;
    }

    /**
     * Delete a user by username.
     * @param username The username of the user to delete.
     * @return true if deletion was successful, false otherwise.
     */
    public boolean deleteByUsername(String username) {
        if (userRepository.existsByUsername(username)) {
            userRepository.deleteByUsername(username);
            return true;
        }
        return false;
    }

    /**
     * Delete a user by ID.
     * @param id The ID of the user to delete.
     * @return true if deletion was successful, false otherwise.
     */
    public boolean deleteById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}