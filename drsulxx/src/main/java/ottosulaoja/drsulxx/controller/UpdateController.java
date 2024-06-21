package ottosulaoja.drsulxx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ottosulaoja.drsulxx.model.User;
import ottosulaoja.drsulxx.service.UpdateService;

@RestController
@RequestMapping("/api/users/update")
public class UpdateController {

    private final UpdateService updateService;

    @Autowired
    public UpdateController(UpdateService updateService) {
        this.updateService = updateService;
    }

    /**
     * Update a user by ID.
     * 
     * @param id   The ID of the user to update.
     * @param user Updated user object containing new username and email.
     * @return ResponseEntity containing the updated user object with HTTP status 200 (OK),
     *         or HTTP status 404 (Not Found) if user with given ID is not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = updateService.updateUserById(id, user);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update a user by username.
     * 
     * @param username Username of the user to update.
     * @param user     Updated user object containing new username and email.
     * @return ResponseEntity containing the updated user object with HTTP status 200 (OK),
     *         or HTTP status 404 (Not Found) if user with given username is not found.
     */
    @PutMapping("/username/{username}")
    public ResponseEntity<User> updateUserByUsername(@PathVariable String username, @RequestBody User user) {
        User updatedUser = updateService.updateUserByUsername(username, user);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update a user by email.
     * 
     * @param email Email of the user to update.
     * @param user  Updated user object containing new username and email.
     * @return ResponseEntity containing the updated user object with HTTP status 200 (OK),
     *         or HTTP status 404 (Not Found) if user with given email is not found.
     */
    @PutMapping("/email/{email}")
    public ResponseEntity<User> updateUserByEmail(@PathVariable String email, @RequestBody User user) {
        User updatedUser = updateService.updateUserByEmail(email, user);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}