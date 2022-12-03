package peaksoft.taskspringboot.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.taskspringboot.model.Course;
import peaksoft.taskspringboot.model.Lesson;
import peaksoft.taskspringboot.repository.CourseRepository;
import peaksoft.taskspringboot.repository.LessonRepository;
import peaksoft.taskspringboot.service.LessonService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    private final CourseRepository courseRepository;

    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new RuntimeException("not found")
        );
        course.addLesson(lesson);
        lesson.setCourse(course);
        lessonRepository.save(lesson);
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        return null;
    }

    @Override
    public Lesson getById(Long id) {
        return lessonRepository.findById(id).orElseThrow(
                ()->new RuntimeException("not found!!!")
        );
    }

    @Override
    public List<Lesson> getAllLesson(Long courseId) {
        return lessonRepository.getAll(courseId);
    }

    @Override
    public void deleteLessonById(Long id) {
        lessonRepository.deleteById(id);
    }
}
