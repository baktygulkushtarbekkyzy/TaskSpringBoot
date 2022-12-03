package peaksoft.taskspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_gen")
    @SequenceGenerator(name = "student_gen",sequenceName = "student_seq",allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    private String studyFormat;

    @ManyToOne(cascade = {MERGE,REFRESH,DETACH})
    private Group group;

}
