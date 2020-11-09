package com.lumosss.controller;

import com.lumosss.entity.User;
import com.lumosss.entity.UserVO;
//import com.lumosss.feign.OrderFeign;
import com.lumosss.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserFeign userFeign;
//    @Autowired
//    private OrderFeign orderFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        return userFeign.findAll(page, limit);
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;
    }

    @PostMapping("/save")
    public String save(User user){
        userFeign.save(user);
        return "redirect:/user/redirect/user_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
//        orderFeign.deleteByUid(id);
        userFeign.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }
}
