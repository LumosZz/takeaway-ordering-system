package com.lumosss.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lumosss.entity.User;
import com.lumosss.entity.UserVO;
import com.lumosss.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;

    @GetMapping("/findAll/{page}/{limit}")
    public UserVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit){
        UserVO userVO = new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(userRepository.count());
        userVO.setData(userRepository.findAll((page-1)*limit,limit));
        return userVO;
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        date = new Date();
        user.setRegisterdate(date);
        userRepository.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userRepository.deleteById(id);
    }
}
