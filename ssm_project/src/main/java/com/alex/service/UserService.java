package com.alex.service;

import com.alex.domain.User;  
  
/** 
 * ���ܸ�Ҫ��UserService�ӿ��� 
 *  
 * @author AlexJones 
 * @since  2017��1��6��  
 */  
public interface UserService {  
    User selectUserById(Integer userId);  
  
}
