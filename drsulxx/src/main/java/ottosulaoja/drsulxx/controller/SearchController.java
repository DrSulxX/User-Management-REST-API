package ottosulaoja.drsulxx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ottosulaoja.drsulxx.model.User;
import ottosulaoja.drsulxx.service.UserSearchService;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final UserSearchService userSearchService;

    @Autowired
    public SearchController(UserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }

    /**
     * Endpoint to fetch all users.
     * @return the list of all users.
     */
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userSearchService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Endpoint to fetch a user by ID.
     * @param id the ID of the user to fetch.
     * @return the user if found, or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userSearchService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint to fetch a user by email.
     * @param email the email of the user to fetch.
     * @return the user if found, or 404 if not found.
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userSearchService.getUserByEmail(email);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint to fetch a user by username.
     * @param username the username of the user to fetch.
     * @return the user if found, or 404 if not found.
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userSearchService.getUserByUsername(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}