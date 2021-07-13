package com.example.spring.exercise.service;

import com.example.spring.exercise.dao.UserDao;
import com.example.spring.exercise.dao.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserByUserId(String userId){
        return userDao.selectUserByUserId(userId);
    }
    public void insertUserTotTab(User user){
        int r = userDao.insertUser(user);
        System.out.println("userDao.insertUser="+r);
        LOGGER.info("userDao.insertUser={}",r);
    }
    public void updateUserbyId(User user){
        int r = userDao.updateUser(user);
        System.out.println("userDao.insertUser="+r);
    }
    public void deleteUserByUid(String uid){
        userDao.deleteUser(uid);
    }

    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }
}
