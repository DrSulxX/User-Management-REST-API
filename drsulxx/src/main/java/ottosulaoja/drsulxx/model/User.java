package ottosulaoja.drsulxx.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Specifies that this class is an entity which maps to a database table
@Table(name = "users") // Specifies the name of the database table to which this entity maps
public class User {

    @Id // Specifies that the id field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
    private Long id; // Unique identifier for the user

    private String username; // Username of the user
    private String email; // Email address of the user

    // Getters and setters for the user's attributes

    // Getter method for retrieving the user ID
    public Long getId() {
        return id;
    }

    // Setter method for setting the user ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter method for retrieving the username
    public String getUsername() {
        return username;
    }

    // Setter method for setting the username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method for retrieving the email address
    public String getEmail() {
        return email;
    }

    // Setter method for setting the email address
    public void setEmail(String email) {
        this.email = email;
    }
}