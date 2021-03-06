package com.teamtreehouse.instateam.web.controller;

import com.teamtreehouse.instateam.model.Role;
import com.teamtreehouse.instateam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/roles")
    public String listRoles(Model model) {
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roles", roleList);
        model.addAttribute("newRole", new Role());
        return "roles";
    }

    @RequestMapping(value="/roles", method = RequestMethod.POST)
    public String addRole(Role role) {
        roleService.save(role);
        return "redirect:/roles";
    }
}
