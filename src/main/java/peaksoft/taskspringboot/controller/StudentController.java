package peaksoft.taskspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.taskspringboot.model.Group;
import peaksoft.taskspringboot.model.Student;
import peaksoft.taskspringboot.service.GroupService;
import peaksoft.taskspringboot.service.StudentService;


@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    private final GroupService groupService;

    @Autowired
    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping("/getAll/{groupId}")
    public String getAll(@PathVariable Long groupId, Model model,@ModelAttribute("group") Group group){
        model.addAttribute("students",studentService.getAllStudent(groupId));
        model.addAttribute("groupId",groupId);
        model.addAttribute("groups",groupService.getAllGroup());
        return "/student/allStudent";
    }

    @GetMapping("/add/{groupId}")
    public String add(@PathVariable Long groupId,Model model){
        model.addAttribute("newStudent",new Student());
        model.addAttribute("groupId",groupId);
        return "/student/newStudent";
    }


    @PostMapping("/saveStudent/{groupId}")
    public String save(@ModelAttribute("student") Student student, @PathVariable Long groupId){
        studentService.saveStudent(groupId, student);
        return "redirect:/students/getAll/{groupId}";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable(name = "id") Long id ,@ModelAttribute Student student){
        ModelAndView modelAndView=new ModelAndView("/student/updateStudent");
        student.setGroup(studentService.getById(id).getGroup());
        Student student1=studentService.getById(id);
        modelAndView.addObject("student1",student1);
        return modelAndView;
    }



    @PostMapping("/delete/{id}/{groupId}")
    public String delete(@PathVariable Long id,@PathVariable Long groupId){
        studentService.deleteStudentById(id);
        return "redirect:/students/getAll/{groupId}";
    }



    @PostMapping("/{groupId}/{studentId}/saveAssign")
    private String saveAssign(@PathVariable("studentId") Long studentId,
                              @ModelAttribute("group")Group group,
                              @PathVariable("groupId") Long groupId){
        System.out.println(group);
        groupService.assignGroupToStudent(group.getId(),studentId);
        return "redirect:/students/getAll/{groupId}";
    }
}
