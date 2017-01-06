package com.alex.service;

import com.alex.domain.User;  
  
/** 
 * 功能概要：UserService接口类 
 *  
 * @author AlexJones 
 * @since  2017年1月6日  
 */  
public interface UserService {  
    User selectUserById(Integer userId);  
  
}
