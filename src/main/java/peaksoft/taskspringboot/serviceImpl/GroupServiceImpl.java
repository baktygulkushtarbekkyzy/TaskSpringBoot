package peaksoft.taskspringboot.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.taskspringboot.model.Group;
import peaksoft.taskspringboot.repository.GroupRepository;
import peaksoft.taskspringboot.service.GroupService;

import java.io.IOException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public void saveGroup(Group group) throws IOException {
        groupRepository.save(group);
    }

    @Override
    public Group updateGroup(Long id, Group group) {
        return null;
    }

    @Override
    public Group getById(Long id) {
        return groupRepository.findById(id).orElseThrow(
                ()->new RuntimeException("not found!!!")
        );
    }

    @Override
    public List<Group> getAllGroup() {
        return groupRepository.getAll();
    }

    @Override
    public void deleteGroupById(Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public void assignGroupToCourse(Long groupId, Long courseId) {

    }

    @Override
    public void assignGroupToStudent(Long groupId, Long studentId) {

    }
}
