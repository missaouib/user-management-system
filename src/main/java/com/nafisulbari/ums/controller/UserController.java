package com.nafisulbari.ums.controller;

import com.nafisulbari.ums.persistence.dao.PrivilegeRepository;
import com.nafisulbari.ums.persistence.dao.RoleToPrivilegeRepository;
import com.nafisulbari.ums.persistence.model.Privilege;
import com.nafisulbari.ums.persistence.model.Role;
import com.nafisulbari.ums.persistence.model.RoleToPrivilege;
import com.nafisulbari.ums.persistence.model.User;
import com.nafisulbari.ums.persistence.dao.RoleRepository;
import com.nafisulbari.ums.persistence.dao.UserRepository;
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

    @Autowired
    PrivilegeRepository privilegeRepository;

    @Autowired
    RoleToPrivilegeRepository roleToPrivilegeRepository;


    @RequestMapping("/")
    public ModelAndView getHomePage(Model model) {

        return new ModelAndView("index");
    }


    @GetMapping("user-list")
    public ModelAndView showUserList(Model model) {
        model.addAttribute("listOfUsers", userRepository.findAll());

        return new ModelAndView("user-management/user-list");
    }


    @GetMapping("add-user")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());

        return "user-management/add-user";
    }


    @PostMapping("add-user")
    public ModelAndView submitAddUserForm(@Valid @ModelAttribute("user") User user,
                                          BindingResult result,
                                          @RequestParam(name = "selectedRoles", required = false, defaultValue = "NOROLE") String selectedRoles,
                                          Model model) {

        if (result.hasErrors()) {
            model.addAttribute("roles", roleRepository.findAll());
            return new ModelAndView("user-management/add-user");
        }

        setSelectedRolesToUser(user, selectedRoles);
        userRepository.save(user);

        return new ModelAndView("redirect:/user-list");
    }


    @GetMapping("edit-user/{id}")
    public ModelAndView showEditUserForm(@PathVariable("id") int id, Model model) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return new ModelAndView("redirect:/error");
        }
        User user = new User(optionalUser);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleRepository.findAll());

        return new ModelAndView("user-management/edit-user");
    }


    @PostMapping("update-user/{id}")
    public ModelAndView submitEditUserForm(@Valid @ModelAttribute("user") User user,
                                           BindingResult result,
                                           @PathVariable("id") int id,
                                           @RequestParam(name = "selectedRoles", required = false,
                                                   defaultValue = "NOROLE") String selectedRoles) {

        // somehow if we are not calling the tempUser for nothing, user is not consisting any id.
        // also it wont work without the @PathVariable for unknown reason.
        Optional<User> tempUser = userRepository.findById(user.getId());
        if (result.hasErrors() || !tempUser.isPresent()) {
            return new ModelAndView("user-management/edit-user");
        }

        setSelectedRolesToUser(user, selectedRoles);
        userRepository.saveAndFlush(user);

        return new ModelAndView("redirect:/user-list");
    }


    @PostMapping("delete-user/{id}")
    public ModelAndView deleteUser(@PathVariable("id") int id) {

        userRepository.deleteById(id);

        return new ModelAndView("redirect:/user-list");
    }


    //-------------------------------------------------------------------------

    @GetMapping("role-list")
    public String showRoleList(Model model) {
        model.addAttribute("listOfRoles", roleRepository.findAll());

        return "role-management/role-list";
    }


    @GetMapping("add-role")
    public String showAddRoleForm(Model model) {
        model.addAttribute("role", new Role());

        return "role-management/add-role";
    }


    @PostMapping("add-role")
    public ModelAndView submitAddRoleForm(@Valid @ModelAttribute("role") Role role,
                                          BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("role-management/add-role");
        }
        roleRepository.save(role);

        return new ModelAndView("redirect:/role-list");
    }


    @GetMapping("edit-role/{id}")
    public ModelAndView showEditRoleForm(@PathVariable("id") int id, Model model) {
        Optional<Role> optionalRole = roleRepository.findById(id);

        if (!optionalRole.isPresent()) {
            return new ModelAndView("redirect:/error");
        }
        Role role = new Role(optionalRole);
        model.addAttribute("role", role);

        return new ModelAndView("role-management/edit-role");
    }


    @PostMapping("update-role/{id}")
    public ModelAndView submitEditRoleForm(@Valid @ModelAttribute("role") Role role,
                                           BindingResult result,
                                           @PathVariable("id") int id) {
        // somehow if we are not calling the tempUser for nothing, user is not consisting any id.
        // also it wont work without the @PathVariable for unknown reason.
        Optional<Role> tempRole = roleRepository.findById(id);
        if (result.hasErrors() || !tempRole.isPresent()) {
            return new ModelAndView("role-management/edit-role");
        }

        role.setId(tempRole.get().getId());
        roleRepository.save(role);

        return new ModelAndView("redirect:/role-list");
    }


    @PostMapping("delete-role/{id}")
    public ModelAndView deleteRole(@PathVariable("id") int id, Model model) {


        //todo if exception found(roles been assigned) therefore don't allow delete
        try {
            roleRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            Optional<Role> optionalRole = roleRepository.findById(id);
            Role role = new Role(optionalRole);
            model.addAttribute("role", role);
            model.addAttribute("message", "Unable to delete role because its been assigned to users");

            return new ModelAndView("role-management/edit-role");
        }

        return new ModelAndView("redirect:/role-list");
    }


    //-------------------------------------------------------------------------

    @GetMapping("add-privilege")
    public ModelAndView getAddPrivilegeView(Model model) {

        model.addAttribute("privilege", new Privilege());

        return new ModelAndView("privilege-management/add-privilege");
    }


    @PostMapping("add-privilege")
    public ModelAndView addPrivilegeAction(@Valid @ModelAttribute("privilege") Privilege privilege,
                                           BindingResult result) {
        if (result.hasErrors()) {

            return new ModelAndView("privilege-management/add-privilege");
        }
        privilegeRepository.save(privilege);

        return new ModelAndView("redirect:/privilege-list");
    }


    @GetMapping("edit-privilege/{id}")
    public ModelAndView getEditPrivilegeView(@PathVariable("id") int id, Model model) {
        Optional<Privilege> optionalPrivilege = privilegeRepository.findById(id);

        if (!optionalPrivilege.isPresent()) {
            return new ModelAndView("redirect:/error");
        }
        Privilege privilege = new Privilege(optionalPrivilege);
        model.addAttribute("privilege", privilege);

        return new ModelAndView("privilege-management/edit-privilege");
    }


    @PostMapping("update-privilege/{id}")
    public ModelAndView updatePrivilege(@Valid @ModelAttribute("privilege") Privilege privilege,
                                        BindingResult result,
                                        @PathVariable("id") int id) {

        // somehow if we are not calling the tempPrivilege for nothing, user is not consisting any id.
        // also it wont work without the @PathVariable for unknown reason.
        Optional<Privilege> tempPrivilege = privilegeRepository.findById(id);
        if (result.hasErrors() || !tempPrivilege.isPresent()) {
            return new ModelAndView("privilege-management/edit-privilege");
        }

        privilege.setId(tempPrivilege.get().getId());
        privilegeRepository.save(privilege);

        return new ModelAndView("redirect:/privilege-list");
    }


    @PostMapping("delete-privilege/{id}")
    public ModelAndView deletePrivilege(@PathVariable("id") int id, Model model) {


        //todo if exception found(privileges been assigned) therefore don't allow delete
        try {
            privilegeRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            Optional<Privilege> optionalPrivilege = privilegeRepository.findById(id);
            Privilege privilege = new Privilege(optionalPrivilege);

            model.addAttribute("privilege", privilege);
            model.addAttribute("message", "Unable to delete Privilege because its been assigned to Roles");

            return new ModelAndView("privilege-management/edit-privilege");
        }

        return new ModelAndView("redirect:/privilege-list");
    }


    @RequestMapping("privilege-list")
    public ModelAndView getPrivilegeListView(Model model) {
        model.addAttribute("listOfPrivileges", privilegeRepository.findAll());

        return new ModelAndView("privilege-management/privilege-list");
    }


    @GetMapping("roles-privileges/{id}")
    public ModelAndView getRolesToPrivilegesView(@PathVariable("id") int id, Model model) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        Role role = new Role(optionalRole);

        List<Privilege> rolesPrivileges = new ArrayList<>();
        role.getRoleToPrivileges().forEach(rtp -> {
            rolesPrivileges.add(rtp.getPrivilege());
        });

        model.addAttribute("role", role);
        model.addAttribute("rolesPrivileges", rolesPrivileges);
        model.addAttribute("listOfPrivileges", privilegeRepository.findAll());

        return new ModelAndView("role-management/roles-privileges");
    }

    @PostMapping("roles-privileges/add/{roleId}/{privilegeId}")
    public ModelAndView addPrivilegeToRole(@PathVariable("roleId") int roleId,
                                           @PathVariable("privilegeId") int privilegeId) {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        Role role = new Role(optionalRole);
        Optional<Privilege> optionalPrivilege = privilegeRepository.findById(privilegeId);
        Privilege privilege = new Privilege(optionalPrivilege);

        RoleToPrivilege roleToPrivilege = new RoleToPrivilege();
        roleToPrivilege.setRole(role);
        roleToPrivilege.setPrivilege(privilege);
        roleToPrivilegeRepository.save(roleToPrivilege);

        return new ModelAndView("redirect:/roles-privileges/" + roleId);
    }


    @PostMapping("roles-privileges/remove/{roleId}/{privilegeId}")
    public ModelAndView removePrivilegeFromRole(@PathVariable("roleId") int roleId,
                                                @PathVariable("privilegeId") int privilegeId) {

          roleToPrivilegeRepository.deleteDistinctByRoleIdAndPrivilegeId(roleId, privilegeId);

        return new ModelAndView("redirect:/roles-privileges/" + roleId);
    }


    /**
     * List of Roles are fetched from the repository and are checked with selectedRoles.
     * If they match a Set of roles is being created.
     * Then it is assigned to the user entity.
     * <p>
     * Params: selectedRoles - Contains comma separated roles in String
     * user - Contains an entity
     */
    private void setSelectedRolesToUser(User user, String selectedRoles) {
//        List<Role> listOfAvailableRoles = (List<Role>) roleRepository.findAll();
//        List<Role> setOfRolesToAdd = new ArrayList<>();
//
//        for (Role role : listOfAvailableRoles) {
//            if (selectedRoles.contains(role.getRoleName())) {
//                setOfRolesToAdd.add(role);
//            }
//        }
//
//        user.setUserToRoles(setOfRolesToAdd);
    }


}
