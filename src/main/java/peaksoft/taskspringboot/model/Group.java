package peaksoft.taskspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "group_gen")
    @SequenceGenerator(name = "group_gen",sequenceName = "group_seq",allocationSize = 1)
    private Long id;
    private String groupName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfStart;
    private String image;

    @ManyToMany(cascade = {PERSIST,MERGE,REFRESH,DETACH},fetch = FetchType.EAGER)
    private List<Course> courses;

    @OneToMany(cascade = {PERSIST,MERGE,REFRESH,DETACH},mappedBy = "group")
    private List<Student> students;

    public void addStudent(Student student){
        students.add(student);
    }




}
