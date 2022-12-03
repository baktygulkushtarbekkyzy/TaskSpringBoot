package peaksoft.taskspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.taskspringboot.model.Group;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {

    @Query("select g from Group g")
    List<Group> getAll();
}
