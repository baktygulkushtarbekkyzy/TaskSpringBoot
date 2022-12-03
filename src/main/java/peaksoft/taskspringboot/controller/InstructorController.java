package peaksoft.taskspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.taskspringboot.model.Instructor;
import peaksoft.taskspringboot.service.CourseService;
import peaksoft.taskspringboot.service.InstructorService;

@Controller
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;
    private final CourseService courseService;



    @GetMapping("/getAll/{courseId}")
    public String getAll(Model model,@PathVariable Long courseId){
        model.addAttribute("instructors",instructorService.getAllInstructor(courseId));
        model.addAttribute("courseId",courseId);
        return "/instructor/allInstructors";
    }

    @GetMapping("/add/{courseId}")
    public String addInstructor(Model model,@PathVariable Long courseId){
        model.addAttribute("newInstructor",new Instructor());
        model.addAttribute("courseId",courseId);
        return "/instructor/newInstructor";
    }

    @PostMapping("/save/{courseId}")
    public String saveInstructor(@PathVariable("courseId") Long courseId,
                                @ModelAttribute("instructor") Instructor instructor) {
        instructorService.saveInstructor(courseId, instructor);
        return "redirect:/instructors/getAll/{courseId}";
    }



    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable(name = "id") Long id,@ModelAttribute Instructor instructor){
        ModelAndView modelAndView=new ModelAndView("/instructor/update");
        instructor.setCourse(instructorService.getById(id).getCourse());
       Instructor instructor1= instructorService.getById(id);
        modelAndView.addObject("instructor1",instructor1);
        return modelAndView;
    }

    @GetMapping("/delete/{id}/{courseId}")
    public String delete(@PathVariable Long id,@PathVariable Long courseId){
        instructorService.deleteInstructorById(id);
        return "redirect:/instructors/getAll/{courseId}";
    }
}
