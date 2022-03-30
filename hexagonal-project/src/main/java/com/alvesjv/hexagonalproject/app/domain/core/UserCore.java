package com.alvesjv.hexagonalproject.app.domain.core;

import com.alvesjv.hexagonalproject.app.domain.entity.User;
import com.alvesjv.hexagonalproject.app.domain.exception.CustomException;
import com.alvesjv.hexagonalproject.app.domain.exception.UserException;
import com.alvesjv.hexagonalproject.app.domain.repository.UserRepository;
import com.alvesjv.hexagonalproject.app.ports.out.DataBaseIntegration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserCore {

    @Autowired
    @Qualifier("user")
    private DataBaseIntegration userDataBase;

    @Autowired
    private UserRepository userRepository;

    //@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    @PostMapping
    public User saveOrPutUser(@RequestBody User user){
        try {
            user.setData(LocalDateTime.now());
            return userRepository.saveAndFlush(user);
        }catch (Throwable t){
            log.error("Error save or patch User: ", t);
            throw new CustomException(t);
        }
    }

    @PatchMapping
    public User update(String id, User user){
        try {
            UUID uuid = UUID.fromString(id);
            Optional<User> opUser = userDataBase.findById(uuid);

            if(!opUser.isPresent()){
                throw new UserException("Task not found", HttpStatus.UNPROCESSABLE_ENTITY);
            }

            User userUpdate = opUser.get();
            if(!Objects.isNull(user.getNome())){
                userUpdate.setNome(user.getNome());
            }
            if(!Objects.isNull(user.getSobrenome())){
                userUpdate.setSobrenome(user.getSobrenome());
            }
            if(!Objects.isNull(user.getIdade())){
                userUpdate.setIdade(user.getIdade());
            }

            userDataBase.save(userUpdate);

            log.info("User updated successfuly - {}", user);

            return user;

        }catch(Throwable t){
            log.error("Error update task: {}", t);
            throw new CustomException(t);
        }
    }

    @GetMapping
    public List<User> getUsersList(){
        try {
            return userRepository.findAll();
        }catch (Throwable t){
            log.error("Error list Users: ", t);
            throw new CustomException(t);
        }
    }

    @GetMapping("/listUser/{id}")
    public User getUser(@PathVariable UUID id) {
        try {
            return userRepository.findById(id).get();
        }catch (Throwable t){
            log.error("Error find User: ", t);
            throw new CustomException(t);
        }
    }

    @DeleteMapping("/delUser/{id}")
    public void deleteUser(@PathVariable UUID id){
        try {
            userRepository.deleteById(id);
        }catch(Throwable t){
            log.error("Error delete User by id: {}", t);
            throw new CustomException(t);
        }
    }
}
