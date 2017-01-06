package com.alex.service;

import com.alex.baseTest.SpringTestCase;

import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;  
  
import com.alex.domain.User;  
  
/** 
 * ���ܸ�Ҫ��UserService��Ԫ���� 
 *  
 * @author AlexJones 
 * @since  2017��1��6��  
 */  
public class UserServiceTest extends SpringTestCase {  
    @Autowired  
    private UserService userService;  
    Logger logger = Logger.getLogger(UserServiceTest.class);  
      
    @Test  
    public void selectUserByIdTest(){  
        User user = userService.selectUserById(10);  
        logger.debug("���ҽ��" + user);  
    }  
      
  
} 
