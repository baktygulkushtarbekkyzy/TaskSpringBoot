package peaksoft.taskspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.taskspringboot.model.Company;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    @Query("select t from Company t")
     List<Company> getAllCompany();
}
