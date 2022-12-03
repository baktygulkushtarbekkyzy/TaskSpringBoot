package peaksoft.taskspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.taskspringboot.model.Course;
import peaksoft.taskspringboot.model.Group;
import peaksoft.taskspringboot.model.Instructor;
import peaksoft.taskspringboot.service.CompanyService;
import peaksoft.taskspringboot.service.CourseService;
import peaksoft.taskspringboot.service.GroupService;
import peaksoft.taskspringboot.service.InstructorService;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CompanyService companyService;

    private final GroupService groupService;

    private final CourseService courseService;

    private final InstructorService instructorService;




    @GetMapping("/getAll/{companyId}")
    public String getAll(Model model,
                         @PathVariable Long companyId,
                         @ModelAttribute("group") Group group,Long courseId,
                         @ModelAttribute("instructor")Instructor instructor){
        model.addAttribute("courses",courseService.getAllCourse(companyId));
        model.addAttribute("companyId",companyId);
        model.addAttribute("groups",groupService.getAllGroup());
        model.addAttribute("allInstructor  ",instructorService.getAllInstructor(courseId));
        return "/course/allCourses";
    }

    @GetMapping("/add/{companyId}")
    public String addCourse(Model model,@PathVariable Long companyId){
        model.addAttribute("newCourse",new Course());
        model.addAttribute("companyId",companyId);
        return "/course/newCourse";
    }

    @PostMapping("/save/{companyId}")
    public String saveCourse(@ModelAttribute("course") Course course,@PathVariable("companyId") Long companyId) throws IOException {
        courseService.saveCourse(companyId, course);

        return "redirect:/courses/getAll/{companyId}";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable(name = "id") Long id,@ModelAttribute Course course){
        ModelAndView modelAndView=new ModelAndView("/course/updateCourse");
        course.setCompany(courseService.getById(id).getCompany());
        Course course1 = courseService.getById(id);
        modelAndView.addObject("course1",course1);
        return modelAndView;
    }


    @PostMapping("/delete/{id}/{companyId}")
    public String delete(@PathVariable Long id,@PathVariable Long companyId){
        courseService.deleteCourseById(id);
        return "redirect:/courses/getAll/{companyId}";
    }

    @PostMapping("/{companyId}/{courseId}/saveAssign")
    private String saveAssign(@PathVariable("courseId") Long courseId,
                              @ModelAttribute("group") Group group,
                              @PathVariable Long companyId) {
        System.out.println(group);
        groupService.assignGroupToCourse(group.getId(), courseId);
        return "redirect:/courses/getAll/{companyId}";
    }

    @PostMapping("/{companyId}/{courseId}/saveAssignInstructor")
    private String saveAssignInstructor(@PathVariable("courseId") Long courseId,
                              @ModelAttribute("instructor") Instructor instructor,
                              @PathVariable Long companyId) {
        instructorService.assignInstructorToCourse(instructor.getId(),courseId);
        return "redirect:/courses/getAll/{companyId}";
    }
}
