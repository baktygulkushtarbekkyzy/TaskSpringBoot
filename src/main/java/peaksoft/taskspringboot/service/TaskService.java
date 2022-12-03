package peaksoft.taskspringboot.service;

import org.springframework.stereotype.Service;
import peaksoft.taskspringboot.model.Task;

import java.util.List;
@Service
public interface TaskService {

    void saveTask(Long lessonId, Task task );

    Task updateTask(Long id,Task task );

    Task getById(Long id);

    List<Task> getAllTask(Long lessonId);

    void deleteTaskById(Long id);

}
