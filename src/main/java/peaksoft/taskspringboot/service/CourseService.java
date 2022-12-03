package peaksoft.taskspringboot.service;

import org.springframework.stereotype.Service;
import peaksoft.taskspringboot.model.Course;

import java.io.IOException;
import java.util.List;
@Service
public interface CourseService {

    void saveCourse(Long companyId, Course course) throws IOException;

    Course updateCourse(Long id, Course course);

    Course getById(Long id);

    List<Course> getAllCourse(Long companyId);

    void deleteCourseById(Long id);
}
