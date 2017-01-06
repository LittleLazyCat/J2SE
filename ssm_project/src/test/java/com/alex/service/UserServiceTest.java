package com.alex.service;

import com.alex.baseTest.SpringTestCase;

import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;  
  
import com.alex.domain.User;  
  
/** 
 * 功能概要：UserService单元测试 
 *  
 * @author AlexJones 
 * @since  2017年1月6日  
 */  
public class UserServiceTest extends SpringTestCase {  
    @Autowired  
    private UserService userService;  
    Logger logger = Logger.getLogger(UserServiceTest.class);  
      
    @Test  
    public void selectUserByIdTest(){  
        User user = userService.selectUserById(10);  
        logger.debug("查找结果" + user);  
    }  
      
  
} 
