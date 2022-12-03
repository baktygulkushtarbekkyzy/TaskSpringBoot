package peaksoft.taskspringboot.service;

import org.springframework.stereotype.Service;
import peaksoft.taskspringboot.model.Company;

import java.io.IOException;
import java.util.List;
@Service
public interface CompanyService {

    void saveCompany(Company company) throws IOException;

    Company updateCompany(Long id, Company company);

    Company getById(Long id);

    List<Company> getAllCompany();

    void deleteCompanyById(Long id);

    int numberOfStudents();
}
