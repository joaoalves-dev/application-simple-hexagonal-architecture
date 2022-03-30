package com.alvesjv.hexagonalproject.app.ports.in;

import com.alvesjv.hexagonalproject.app.domain.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserPort {
    public ResponseEntity<User> create(User user);
    public ResponseEntity<User> find(UUID id);
    public ResponseEntity<List<User>> list();
    public ResponseEntity<User> update(User user);
    public ResponseEntity<?> delete(UUID id);
}
