package peaksoft.taskspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_gen")
    @SequenceGenerator(name = "course_gen",sequenceName = "course_seq",allocationSize = 1)
    private Long id;
    private String courseName;
    private int duration;
    private String description;

    @ManyToOne(cascade = {MERGE,REFRESH,DETACH})
    private Company company;

    @ManyToMany(cascade = {PERSIST,MERGE,REFRESH,DETACH},fetch = FetchType.LAZY,mappedBy = "courses")
    private List<Group> groups;

    public  void addGroup(Group group){
        groups.add(group);
    }

    @OneToMany(cascade =ALL,mappedBy = "course")
    private List<Instructor> instructors;

    public void addInstructor(Instructor instructor){
        instructors.add(instructor);
    }

    @OneToMany(cascade = ALL,mappedBy = "course")
    private List<Lesson> lessons;

    public void addLesson(Lesson lesson){
        lessons.add(lesson);
    }

}
