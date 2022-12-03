package peaksoft.taskspringboot.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.taskspringboot.model.Lesson;
import peaksoft.taskspringboot.model.Task;
import peaksoft.taskspringboot.repository.LessonRepository;
import peaksoft.taskspringboot.repository.TaskRepository;
import peaksoft.taskspringboot.service.TaskService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    private final LessonRepository lessonRepository;

    @Override
    public void saveTask(Long lessonId, Task task) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );

        lesson.addTask(task);
        task.setLesson(lesson);

        taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        return null;
    }

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(
                ()->new RuntimeException("not found!!!")
        );
    }

    @Override
    public List<Task> getAllTask(Long lessonId) {
        return taskRepository.getAll(lessonId);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
