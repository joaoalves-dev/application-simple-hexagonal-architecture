package com.alvesjv.hexagonalproject.app.adapters.in;

import com.alvesjv.hexagonalproject.app.domain.core.UserCore;
import com.alvesjv.hexagonalproject.app.domain.entity.User;
import com.alvesjv.hexagonalproject.app.ports.in.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/users")
public class UserAdapters implements UserPort {
    @Autowired
    private UserCore core;

    @Override
    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid User user) {
        User u = core.saveOrPutUser(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<User> find(@PathVariable UUID id) {
        User u = core.getUser(id);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<User>> list() {
        List<User> u = core.getUsersList();
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @Override
    @PatchMapping
    public ResponseEntity<User> update(@RequestBody @Valid User user) {
        User u = core.saveOrPutUser(user);
        return new ResponseEntity<>(u, HttpStatus.ACCEPTED);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        core.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
