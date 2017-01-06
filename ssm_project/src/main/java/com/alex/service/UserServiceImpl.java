package com.alex.service;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
  
import com.alex.dao.UserDao; 
import com.alex.domain.User;

/** 
 * 功能概要：UserService实现类 
 *  
 * @author AlexJones 
 * @since  2017年1月6日  
 */  
@Service  
public class UserServiceImpl implements UserService{  
    @Autowired  
    private UserDao userDao;  
  
    public User selectUserById(Integer userId) {  
        return userDao.selectUserById(userId);  
          
    }  
  
} 
