package com.example.dataanalyticrestfulapi.service.ServiceImpl;

import com.example.dataanalyticrestfulapi.model.User;
import com.example.dataanalyticrestfulapi.model.UserAccount;
import com.example.dataanalyticrestfulapi.repository.UserRepo;
import com.example.dataanalyticrestfulapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;
    UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @Override
    public List<User> findUserByName() {
        return null;
    }

    @Override
    public List<User> allUsers() {
        return userRepo.allUsers();
    }

    @Override
    public User findUserByID(int id) {
        return userRepo.findUserByID(id);
    }

    @Override
    public int createNewUser(User user) {

        return userRepo.createNewUser(user);
    }

    @Override
    public int updateUser(User user, int id) {
        return userRepo.updateUsers(user, user.getUserId());
    }

    @Override
    public int removeUser(int id) {
        return userRepo.removeUser(id);
    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return userRepo.getAllUserAccount();
    }
}