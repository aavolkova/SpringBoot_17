package me.anna.demo.controllers;


import me.anna.demo.SSUserDetailsService;
import me.anna.demo.models.Role;
import me.anna.demo.models.User;
import me.anna.demo.repositories.RoleRepo;
import me.anna.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Controller
public class HomeController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    SSUserDetailsService ssUserDetailsService;




    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    // Modifications to Controller: ("Roles and Users" Exercise):
//    @RequestMapping("/admin")
//    public String admin(){
//        return "admin";
//    }





    // ============= Allow user to Sign Up =============
    @GetMapping("/signup")
    public String createUser(Model model)
    {
        model.addAttribute("newUser", new User());
        return "signup";
    }

    // Validate entered information and if it is valid display the result
    // Person must have first name, last name, and email address
    @PostMapping("/signup")
    public String postPerson(@ModelAttribute("newUser") User newUser, Model model)
    {
//
//        user.setEnabled(true);
//
//
//
//        user.setRoles(USER);
//        this.roles = roles;
//    }
//
//        userRepo.save(user);
//
////        long userId = user.getId();
////        User =  userRepo.findOne( userId);
////        model.addAttribute("userObject", u);



        newUser.setEnabled(true);
        Role newRole = roleRepo.findOne(new Long(2));

        newRole.setRole(newRole.getRole());

//        Collection<Role> newUserRoles = new ArrayList<Role>();

        Set<Role> newUserRoles = new HashSet<>();
        newUserRoles.add(newRole);
        newUser.setRoles(newUserRoles);


        userRepo.save(newUser);


//    ssUserDetailsService.save(user);

//        ssUserDetailsService.loadUserByUsername(newUser.getUsername());

//        return "redirect:/welcome";




        return "login";








    }





    @RequestMapping("/secure")
    public String secure(){
        return "secure";
    }


}
