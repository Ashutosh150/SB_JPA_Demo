package com.Ashu.SB_JPA.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
             generator = "course_sequence"
    )
    private Long courseId;
    private String coursetitle;
    private Integer credit;


    // bidirectional 1 to 1 mapping , this is also done to get data from both class that into 1 to 1 mapping relation
    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;


    // JPA always prefer Many to One instead of One to Many relationShip
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    //Many-to-Many relationship(M-to-M works like we would introduce 3rd new table to display relation between 2 tables that follows M-to-M relationship)

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    // JoinTable is used to create 3rd new required table to display relation between 2 tables that follows M-to-M relationship
    @JoinTable(
            name = "student_course_map",

            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ), inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "StudentId"
            )
    )
    private List<Student> students;

    // as we are working with List of student in M-to-M so we can also add methos to store List of students
    public void addStudent(Student student){
        if (students == null){
            students = new ArrayList<>();
        } else {
            students.add(student);
        }
    }

}
