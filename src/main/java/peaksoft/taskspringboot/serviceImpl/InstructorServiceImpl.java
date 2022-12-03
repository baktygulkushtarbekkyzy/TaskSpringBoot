package peaksoft.taskspringboot.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.taskspringboot.model.Course;
import peaksoft.taskspringboot.model.Instructor;
import peaksoft.taskspringboot.repository.CourseRepository;
import peaksoft.taskspringboot.repository.InstructorRepository;
import peaksoft.taskspringboot.service.InstructorService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    private final CourseRepository courseRepository;


    @Override
    public void saveInstructor(Long courseId, Instructor instructor) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new RuntimeException("not found")
        );
        course.addInstructor(instructor);
        instructor.setCourse(course);
        instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor instructor) {


        return null;
    }

    @Override
    public Instructor getById(Long id) {

        return   instructorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found")
        );
    }

    @Override
    public List<Instructor> getAllInstructor(Long courseId) {
        return instructorRepository.getAll(courseId);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {

    }
}
