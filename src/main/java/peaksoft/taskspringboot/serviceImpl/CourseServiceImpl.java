package peaksoft.taskspringboot.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.taskspringboot.model.Company;
import peaksoft.taskspringboot.model.Course;
import peaksoft.taskspringboot.repository.CompanyRepository;
import peaksoft.taskspringboot.repository.CourseRepository;
import peaksoft.taskspringboot.service.CourseService;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    private final CompanyRepository companyRepository;

    @Override
    public void saveCourse(Long companyId, Course course) throws IOException {
        Company company = companyRepository.findById(companyId).orElseThrow(
                () -> new RuntimeException("not found")
        );
        company.addCourse(course);
        course.setCompany(company);
        courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        return null;
    }

    @Override
    public Course getById(Long id) {
        return  courseRepository.findById(id).orElseThrow(
                ()->new RuntimeException("not found")
        );
    }

    @Override
    public List<Course> getAllCourse(Long companyId) {
        return courseRepository.getAll(companyId);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }
}
