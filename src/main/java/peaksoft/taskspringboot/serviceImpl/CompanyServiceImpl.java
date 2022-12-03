package peaksoft.taskspringboot.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.taskspringboot.model.Company;
import peaksoft.taskspringboot.model.Course;
import peaksoft.taskspringboot.model.Group;
import peaksoft.taskspringboot.model.Student;
import peaksoft.taskspringboot.repository.CompanyRepository;
import peaksoft.taskspringboot.service.CompanyService;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository ;

    @Override
    public void saveCompany(Company company) throws IOException {
        companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Long id, Company company) {
        return null;
    }

    @Override
    public Company getById(Long id) {
        return companyRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found")
        );
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.getAllCompany();
    }

    @Override
    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public int numberOfStudents() {
        int r = 0;
        for (Company c : getAllCompany()) {
            for (Course s : c.getCourses()) {
                for (Group g : s.getGroups()) {
                    for (Student e : g.getStudents()) {
                        System.out.println(e);
                        r++;
                    }
                }
            }
        }
        return r;
    }



//    void saveCourse(Long companyId, Course course) throws IOException;
//
//    Course updateCourse(Long id,Course course);
//
//    Course getById(Long id);
//
//    List<Course> getAllCourse(Long companyId);
//
//    void deleteCourseById(Long id);
}
