package com.thymeleaf.controller;

import com.thymeleaf.entity.User;
import com.thymeleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ModelAndView selectAll(Model model){
        model.addAttribute("users",userRepository.allUsers());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","usersModel",model);
    }

    @GetMapping("{id}")
    public ModelAndView getById(@PathVariable("id") Long id, Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","usersModel",model);
    }

    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","usersModel",model);
    }

    @PostMapping
    public ModelAndView saveOrUpadate(User user){
        user = userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id){
        userRepository.deleteUserById(id);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id,Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","修改用户");
        return new ModelAndView("users/form","usersModel",model);
    }
}
