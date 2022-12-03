package peaksoft.taskspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "instructor_gen")
    @SequenceGenerator(name = "instructor_gen",sequenceName = "instructor_seq",allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String specialization;

    @ManyToOne(cascade = {MERGE,REFRESH,DETACH})
    private Course course;



}
