package peaksoft.taskspringboot.service;

import org.springframework.stereotype.Service;
import peaksoft.taskspringboot.model.Group;

import java.io.IOException;
import java.util.List;
@Service

public interface GroupService {

    void saveGroup( Group group) throws IOException;

    Group updateGroup(Long id,Group group);

    Group getById(Long id);

    List<Group> getAllGroup();

    void deleteGroupById(Long id);

    void assignGroupToCourse(Long groupId,Long courseId);

    void assignGroupToStudent(Long groupId, Long studentId);

}
