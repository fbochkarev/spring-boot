package com.jm.web.controller;

import com.jm.model.Role;
import com.jm.model.User;
import com.jm.service.RoleService;
import com.jm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class HelloController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "/index";
    }

    @GetMapping("/admin/users")
    public String userList(Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
//        System.out.println(getClass() + " - userList - " + userService.listUsers());
        return "users";
    }

    @GetMapping("/profile")
    public String user(@AuthenticationPrincipal User user, Model model) {
        System.out.println(getClass().getName() + "- user -" + user);
        model.addAttribute("user", user);
//        model.addAttribute("users", userService.listUsers());
//        model.addAttribute("role", user.getRoles());
        return "profile";
    }

/*    @ModelAttribute("roles")
    public List<Role> initializeRoles(){
        return roleService.listRoles();
    }*/

    @RequestMapping("/admin/new")
    public String newCustomerForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "new_user";
    }

    @PostMapping("/admin/saveUser")
    public String saveUser(@ModelAttribute("user") User user, @RequestParam("roles") String[] rolesFromHtml) {
        // save user to database
//        user.getRoles();
        System.out.println(getClass() + " - saveUserBefore - " + user);
        Set<Role> roleSet = user.getRoles();
        for (String roleId : rolesFromHtml) {
            roleSet.add(roleService.findOne(Long.valueOf(roleId))); // создадим Set с одним значением
        }
        System.out.println(getClass() + " - saveUserAfter - " + user);
        System.out.println(getClass() + " - rolesFromHtml - " + Arrays.toString(rolesFromHtml));
        userService.add(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/showNewUserForm")
    public String showNewUserForm(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @GetMapping("/admin/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
        // get user from the service
        User user = userService.getUserById(id);
        user.setPassword("");
        // set user as a model attribute to pre-populate the form
        model.addAttribute("user", user);
//        model.addAttribute("rolesFromController", user.getRoles());
        return "update_user";
    }

    @GetMapping("/admin/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        // call delete user method
        this.userService.removeUser(id);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

}