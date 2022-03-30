package com.alvesjv.hexagonalproject.app.adapters.out;

import com.alvesjv.hexagonalproject.app.domain.entity.User;
import com.alvesjv.hexagonalproject.app.domain.repository.UserRepository;
import com.alvesjv.hexagonalproject.app.ports.out.DataBaseIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
@Qualifier("user")
public class UserDataBaseAdapter implements DataBaseIntegration<User, UUID> {

    @Autowired
    private UserRepository repository;

    @Override
    public User save(User t) {
        return repository.saveAndFlush(t);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findAll(Example<User> example) {
        return repository.findAll(example);
    }

    @Override
    public Optional<User> findOne(Example<User> example) {
        return repository.findOne(example);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
