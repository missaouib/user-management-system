package com.nafisulbari.ums.controller;

import com.nafisulbari.ums.entity.User;
import com.nafisulbari.ums.entity.Role;
import com.nafisulbari.ums.repository.UserRepository;
import com.nafisulbari.ums.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;


@Controller
public class UserController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @GetMapping("/")
    public String getHomePage(Model model) {

        return "index";
    }


    @RequestMapping(value = "user-list")
    public String showUserList(Model model) {
        model.addAttribute("listOfUsers", userRepository.findAll());

        return "user-management/user-list";
    }


    @RequestMapping(value = "add-user-form", method = RequestMethod.GET)
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());

        return "user-management/add-user-form";
    }


    @RequestMapping(value = "add-user", method = RequestMethod.POST)
    public ModelAndView submitAddUserForm(@Valid @ModelAttribute("user") User user,
                                              BindingResult result,
                                              @RequestParam(name = "selectedRoles", required = false, defaultValue = "NOROLE") String selectedRoles,
                                              Model model) {

        if (result.hasErrors()) {
            model.addAttribute("roles", roleRepository.findAll());
            return new ModelAndView("user-management/add-user-form");
        }

        setSelectedRolesToUser(user, selectedRoles);
        userRepository.save(user);

        return new ModelAndView("redirect:/user-list");
    }


    @RequestMapping(value = "edit-user-form/{id}", method = RequestMethod.GET)
    public ModelAndView showEditUserForm(@PathVariable("id") int id, Model model) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return new ModelAndView("redirect:/error");
        }
        User user = new User(optionalUser);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleRepository.findAll());

        return new ModelAndView("user-management/edit-user-form");
    }


    @RequestMapping(value = "update-user/{id}", method = RequestMethod.POST)
    public ModelAndView submitEditUserForm(@Valid @ModelAttribute("user") User user,
                                               BindingResult result,
                                               @PathVariable("id") int id,
                                               @RequestParam(name = "selectedRoles", required = false, defaultValue = "NOROLE") String selectedRoles,
                                               Model model) {

        // somehow if we are not calling the tempUser for nothing, user is not consisting any id.
        // also it wont work without the @PathVariable for unknown reason.
        Optional<User> tempUser = userRepository.findById(user.getId());
        if (result.hasErrors() || !tempUser.isPresent()) {
            return new ModelAndView("user-management/edit-user-form");
        }

        setSelectedRolesToUser(user, selectedRoles);
        userRepository.saveAndFlush(user);

        return new ModelAndView("redirect:/user-list");
    }


    @RequestMapping(value = "delete-user/{id}", method = RequestMethod.POST)
    public ModelAndView deleteUser(@PathVariable("id") int id) {

        userRepository.deleteById(id);

        return new ModelAndView("redirect:/user-list");
    }


    //-------------------------------------------------------------------------

    @RequestMapping(value = "role-list")
    public String showRoleList(Model model) {
        model.addAttribute("listOfRoles", roleRepository.findAll());

        return "role-management/role-list";
    }


    @RequestMapping(value = "add-role-form", method = RequestMethod.GET)
    public String showAddRoleForm(Model model) {
        model.addAttribute("role", new Role());

        return "role-management/add-role-form";
    }


    @RequestMapping(value = "add-role", method = RequestMethod.POST)
    public ModelAndView submitAddRoleForm(@Valid @ModelAttribute("role") Role role,
                                          BindingResult result,
                                          Model model) {
        if (result.hasErrors()) {
            return new ModelAndView("role-management/add-role-form");
        }
        roleRepository.save(role);

        return new ModelAndView("redirect:/role-list");
    }


    @RequestMapping(value = "edit-role-form/{id}", method = RequestMethod.GET)
    public ModelAndView showEditRoleForm(@PathVariable("id") int id, Model model) {
        Optional<Role> optionalRole = roleRepository.findById(id);

        if (!optionalRole.isPresent()) {
            return new ModelAndView("redirect:/error");
        }
        Role role = new Role(optionalRole);
        model.addAttribute("role", role);

        return new ModelAndView("role-management/edit-role-form");
    }


    @RequestMapping(value = "update-role/{id}", method = RequestMethod.POST)
    public ModelAndView submitEditRoleForm(@Valid @ModelAttribute("role") Role role,
                                           BindingResult result,
                                           @PathVariable("id") int id,
                                           Model model) {

        // somehow if we are not calling the tempUser for nothing, user is not consisting any id.
        // also it wont work without the @PathVariable for unknown reason.
        Optional<Role> tempRole = roleRepository.findById(id);
        if (result.hasErrors() || !tempRole.isPresent()) {
            return new ModelAndView("role-management/edit-role-form");
        }

        role.setId(tempRole.get().getId());
        roleRepository.saveAndFlush(role);

        return new ModelAndView("redirect:/role-list");
    }


    @RequestMapping(value = "delete-role/{id}", method = RequestMethod.POST)
    public ModelAndView deleteRole(@PathVariable("id") int id, Model model) {


        //todo if exception found(roles been assigned) therefore don't allow delete
        try {
            roleRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            Role role = roleRepository.getOne(id);
            model.addAttribute("role", role);
            model.addAttribute("message", "Unable to delete role because its been assigned to users");

            return new ModelAndView("role-management/edit-role-form");
        }

        return new ModelAndView("redirect:/role-list");
    }



    /**
     *  List of Roles are fetched from the repository and are checked with selectedRoles.
     *  If they match a Set of roles is being created.
     *  Then it is assigned to the user entity.
     *
     *  Params: selectedRoles - Contains comma separated roles in String
     *          user - Contains an entity
     * */
    private void setSelectedRolesToUser(User user, String selectedRoles) {
        List<Role> listOfAvailableRoles = roleRepository.findAll();
        Set<Role> setOfRolesToAdd = new LinkedHashSet<>();

        for (Role role : listOfAvailableRoles) {
            if (selectedRoles.contains(role.getName())) {
                setOfRolesToAdd.add(role);
            }
        }

        user.setRoles(setOfRolesToAdd);
    }


}
