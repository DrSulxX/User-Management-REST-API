package ottosulaoja.drsulxx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ottosulaoja.drsulxx.service.UserDeletionService;

@RestController
@RequestMapping("/api/delete")
public class DeleteController {

    private final UserDeletionService userDeletionService;

    @Autowired
    public DeleteController(UserDeletionService userDeletionService) {
        this.userDeletionService = userDeletionService;
    }

    /**
     * Endpoint to delete a user by ID.
     * @param id the ID of the user to delete.
     * @return HTTP status indicating the outcome.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean deleted = userDeletionService.deleteById(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint to delete a user by email.
     * @param email the email of the user to delete.
     * @return response message indicating the outcome.
     */
    @DeleteMapping("/email/{email}")
    public ResponseEntity<String> deleteUserByEmail(@PathVariable String email) {
        boolean deleted = userDeletionService.deleteByEmail(email);
        if (deleted) {
            return new ResponseEntity<>("User with email " + email + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with email " + email + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint to delete a user by username.
     * @param username the username of the user to delete.
     * @return response message indicating the outcome.
     */
    @DeleteMapping("/username/{username}")
    public ResponseEntity<String> deleteUserByUsername(@PathVariable String username) {
        boolean deleted = userDeletionService.deleteByUsername(username);
        if (deleted) {
            return new ResponseEntity<>("User with username " + username + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with username " + username + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}