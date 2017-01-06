package com.alex.controller;
import javax.annotation.Resource;  

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;  
  
import com.alex.domain.User;  
import com.alex.service.UserService;  
  
/** 
 * ���ܸ�Ҫ��UserController 
 *  
 * @author AlexJones 
 * @since  2017��1��6��  
 */  
@Controller  
public class UserController {  
    @Resource  
    private UserService userService;  
      
    @RequestMapping("/")    
    public ModelAndView getIndex(){      
        ModelAndView mav = new ModelAndView("index");   
        User user = userService.selectUserById(1);  
        mav.addObject("user", user);   
        return mav;    
    }    
}
