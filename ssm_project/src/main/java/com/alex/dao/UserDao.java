package com.alex.dao;
import com.alex.domain.User;;
/** 
 * 功能概要：User的DAO类 
 *  
 * @author AlexJones 
 * @since 2017年1月6日 
 */  
public interface UserDao {  
    /** 
     *  
     * @author AlexJones 
     * @since 2017年1月6日 
     * @param userId 
     * @return 
     */  
    public User selectUserById(Integer userId);  
  
} 
