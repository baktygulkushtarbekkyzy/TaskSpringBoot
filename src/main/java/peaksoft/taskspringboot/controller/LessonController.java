package peaksoft.taskspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.taskspringboot.model.Lesson;
import peaksoft.taskspringboot.service.CourseService;
import peaksoft.taskspringboot.service.LessonService;


@Controller
@RequestMapping("/lessons")
public class LessonController {
    private final LessonService lessonService;
    private final CourseService courseService;

    @Autowired
    public LessonController(LessonService lessonService, CourseService courseService) {
        this.lessonService = lessonService;
        this.courseService = courseService;
    }

    @GetMapping("/getAll/{courseId}")
    public String getAll(Model model,@PathVariable Long courseId){
        model.addAttribute("lessons",lessonService.getAllLesson(courseId));
        model.addAttribute("courseId",courseId);
        return "/lesson/allLesson";
    }

    @GetMapping("/add/{courseId}")
    public String addLesson(Model model,@PathVariable Long courseId){
        model.addAttribute("newLesson",new Lesson());
        model.addAttribute("courseId",courseId);
        return "/lesson/newLesson";
    }

    @PostMapping("/save/{courseId}")
    public String save(@ModelAttribute("lesson") Lesson lesson, @PathVariable Long courseId){
        lessonService.saveLesson(courseId, lesson);
        return "redirect:/lessons/getAll/{courseId}";
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable(name = "id") Long id,@ModelAttribute Lesson lesson){
            ModelAndView modelAndView=new ModelAndView("/lesson/updateLesson");
            lesson.setCourse(lessonService.getById(id).getCourse());
            Lesson lesson1=  lessonService.getById(id);
            modelAndView.addObject("lesson1",lesson1);
        return modelAndView;
    }

    @PostMapping("/delete/{id}/{courseId}")
    public String delete(@PathVariable Long id,@PathVariable Long courseId){
        lessonService.deleteLessonById(id);
        return "redirect:/lessons/getAll/{courseId}";
    }
}
