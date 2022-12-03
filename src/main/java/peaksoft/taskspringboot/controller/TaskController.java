package peaksoft.taskspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.taskspringboot.model.Task;
import peaksoft.taskspringboot.service.LessonService;
import peaksoft.taskspringboot.service.TaskService;


@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final LessonService lessonService;
    private final TaskService taskService;

    @Autowired
    public TaskController(LessonService lessonService, TaskService taskService) {
        this.lessonService = lessonService;
        this.taskService = taskService;
    }

    @GetMapping("/getAll/{lessonId}")
    public String getAll(Model model, @PathVariable Long lessonId) {
        model.addAttribute("tasks", taskService.getAllTask(lessonId));
        model.addAttribute("lessonId", lessonId);
        return "/task/allTask";
    }

    @GetMapping("addTask/{lessonId}")
    public String addTask(@PathVariable Long lessonId, Model model) {
        model.addAttribute("newTask", new Task());
        model.addAttribute("lessonId", lessonId);
        return "/task/newTask";

    }

    @PostMapping("/saveTask/{lessonId}")
    public String saveTask(@PathVariable Long lessonId, @ModelAttribute("task") Task task) {
        taskService.saveTask(lessonId, task);
        return "redirect:/tasks/getAll/{lessonId}";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateTask(@PathVariable(name = "id") Long id,@ModelAttribute Task task) {
        ModelAndView modelAndView=new ModelAndView("/task/updateTask");
        task.setLesson(taskService.getById(id).getLesson());
        Task task1=taskService.getById(id);
        modelAndView.addObject("task1",task1);
        return modelAndView;
    }


    @PostMapping("/delete/{taskId}/{lessonId}")
    public String delete(@PathVariable Long taskId,@PathVariable Long lessonId){
        taskService.deleteTaskById(taskId);
        return "redirect:/tasks/getAll/{lessonId}";
    }


}




