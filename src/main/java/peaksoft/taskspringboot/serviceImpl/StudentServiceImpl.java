package peaksoft.taskspringboot.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.taskspringboot.model.Group;
import peaksoft.taskspringboot.model.Student;
import peaksoft.taskspringboot.repository.GroupRepository;
import peaksoft.taskspringboot.repository.StudentRepository;
import peaksoft.taskspringboot.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    private final GroupRepository groupRepository;
    @Override
    public void saveStudent(Long groupId, Student student) {
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );
        group.addStudent(student);
        student.setGroup(group);

        studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return null;
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                ()->new RuntimeException("not found!!!")
        );
    }

    @Override
    public List<Student> getAllStudent(Long groupId) {
        return studentRepository.getAll(groupId);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
