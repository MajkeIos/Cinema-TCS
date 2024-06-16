package com.uj.cinema.repository;

import com.uj.cinema.model.entity.User;
import com.uj.cinema.model.exception.user.UserNotFoundException;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    default User getByGuid(final String guid) {
        return this.findById(guid).orElseThrow(() -> new UserNotFoundException("User with id " + guid + " not found"));
    }

    default User getByUsername(final String username) {
        return this.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User with username " + username + " not found"));
    }

    Optional<User> findByUsername(final String username);
}
