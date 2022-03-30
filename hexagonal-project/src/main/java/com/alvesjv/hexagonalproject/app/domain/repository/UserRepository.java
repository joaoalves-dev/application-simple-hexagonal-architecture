package com.alvesjv.hexagonalproject.app.domain.repository;

import com.alvesjv.hexagonalproject.app.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>{

}
