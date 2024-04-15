package com.project.inventorymanagement.Services;

import com.project.inventorymanagement.DTOs.User;
import com.project.inventorymanagement.Exceptions.AlreadExistObjectException;
import com.project.inventorymanagement.Exceptions.NoSuchObjectExistsException;
import com.project.inventorymanagement.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserFromRepoById(long userId){
        return userRepository.findById(userId).orElse(null);
    }

    public User getUserById(long userId){
        User repoUser = getUserFromRepoById(userId);
        if(repoUser == null){
            throw new NoSuchObjectExistsException("No User Found with ID:"+userId);
        }
        return repoUser;

    }

    public User addUser(User user){
        User repoUser = getUserFromRepoById(user.getUserId());
        if(repoUser == null){
            return userRepository.save(user);
        }
        else{
            throw new AlreadExistObjectException("User already Exists");
        }
    }

    public User updateUser(long userId ,User user){
        User repoUser = getUserFromRepoById(userId);
        if(repoUser == null){
            throw new NoSuchObjectExistsException("No User Found with ID:"+userId);
        }
        else{
            repoUser = user;
            return userRepository.save(repoUser);
        }
    }

    public List<User> getAllUser() {

        List<User> repoUsers = userRepository.findAll();
        if(repoUsers.size()==0){
            throw new NoSuchObjectExistsException("No Users Found");
        }
        return repoUsers;
    }
}
