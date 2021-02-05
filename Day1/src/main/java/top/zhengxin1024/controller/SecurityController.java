package top.zhengxin1024.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.zhengxin1024.entity.User;
import top.zhengxin1024.service.UserService;

import java.util.Map;

@Controller
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private UserService userService ;

    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @ResponseBody
    @PostMapping(value="/login")
    public Boolean login(@RequestBody User user, Map<String, Object> map) {

        System.out.println(user);
        if(userService.getById(user.getUserNo()) != null){
            User user1=userService.getById(user.getUserNo());
            return user1.getUserPwd().equals(user.getUserPwd());
        }

        return false;
    }

}
