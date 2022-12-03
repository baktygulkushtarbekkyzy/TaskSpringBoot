package peaksoft.taskspringboot.service;

import org.springframework.stereotype.Service;
import peaksoft.taskspringboot.model.Instructor;

import java.util.List;
@Service
public interface InstructorService {
    void saveInstructor(Long courseId, Instructor instructor);

    Instructor updateInstructor(Long id,Instructor instructor);

    Instructor getById(Long id);

    List<Instructor> getAllInstructor(Long courseId);

    void deleteInstructorById(Long id);

    void assignInstructorToCourse(Long instructorId, Long courseId);
}
