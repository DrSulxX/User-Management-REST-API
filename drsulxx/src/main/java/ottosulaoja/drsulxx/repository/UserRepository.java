package ottosulaoja.drsulxx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ottosulaoja.drsulxx.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // Query method to find a user by email
    User findByEmail(String email);

    // Query method to find a user by username
    User findByUsername(String username);

    // Custom query method to delete a user by email
    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.email = ?1")
    void deleteByEmail(String email);

    // Custom query method to delete a user by username
    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.username = ?1")
    void deleteByUsername(String username);

    // Check if a user exists by email
    boolean existsByEmail(String email);

    // Check if a user exists by username
    boolean existsByUsername(String username);
}