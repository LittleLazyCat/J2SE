package com.alex.dao;
import com.alex.domain.User;;
/** 
 * ���ܸ�Ҫ��User��DAO�� 
 *  
 * @author AlexJones 
 * @since 2017��1��6�� 
 */  
public interface UserDao {  
    /** 
     *  
     * @author AlexJones 
     * @since 2017��1��6�� 
     * @param userId 
     * @return 
     */  
    public User selectUserById(Integer userId);  
  
} 
