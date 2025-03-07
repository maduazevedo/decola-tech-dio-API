package me.dio.service.impl;
import me.dio.model.User;
import me.dio.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        if(user.getUser_id() == null){
            throw new IllegalArgumentException("User id can't be null");
        }
        if(userRepository.existsById(user.getUser_id())){
            throw new IllegalArgumentException("User already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id_user) {
         return userRepository.findById(id_user)
                 .orElseThrow(NoSuchElementException::new);
    }


}
