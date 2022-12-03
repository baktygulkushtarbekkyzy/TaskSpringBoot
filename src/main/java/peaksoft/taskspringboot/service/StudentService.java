package peaksoft.taskspringboot.service;

import org.springframework.stereotype.Service;
import peaksoft.taskspringboot.model.Student;

import java.util.List;
@Service
public interface StudentService {

    void saveStudent(Long groupId, Student student);

    Student updateStudent(Long id,Student student);

    Student getById(Long id);

    List<Student> getAllStudent(Long groupId);

    void deleteStudentById(Long id);



}
