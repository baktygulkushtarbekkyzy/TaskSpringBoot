package peaksoft.taskspringboot.service;

import org.springframework.stereotype.Service;
import peaksoft.taskspringboot.model.Lesson;

import java.util.List;
@Service
public interface LessonService {
    void saveLesson(Long courseId, Lesson lesson);

    Lesson updateLesson(Long id,Lesson lesson);

    Lesson getById(Long id);

    List<Lesson> getAllLesson(Long courseId);

    void deleteLessonById(Long id);
}
