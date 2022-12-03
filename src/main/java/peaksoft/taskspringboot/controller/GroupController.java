package peaksoft.taskspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.taskspringboot.model.Group;
import peaksoft.taskspringboot.service.CompanyService;
import peaksoft.taskspringboot.service.GroupService;


import java.io.IOException;

@Controller
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;
    private final CompanyService companyService;

    @Autowired
    public GroupController(GroupService groupService, CompanyService companyService) {
        this.groupService = groupService;
        this.companyService = companyService;
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("groups", groupService.getAllGroup());
        return "/group/allGroup";
    }

    @GetMapping("/add")
    public String addGroup(Model model) {
        model.addAttribute("newGroup", new Group());
        return "/group/newGroup";
    }

    @PostMapping("/save")
    public String saveGroup(Group group) throws IOException {
        groupService.saveGroup(group);
        return "redirect:/groups/getAll";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Long id) {
        ModelAndView modelAndView=new ModelAndView("/group/updateGroup");
        Group group = groupService.getById(id);
        modelAndView.addObject("group",group);
        return modelAndView;
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        groupService.deleteGroupById(id);
        return "redirect:/groups/getAll";
    }


}
