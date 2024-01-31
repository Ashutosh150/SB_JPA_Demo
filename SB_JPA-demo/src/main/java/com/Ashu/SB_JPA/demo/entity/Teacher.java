package com.Ashu.SB_JPA.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;

    // 1 teacher can have many courses.. so teacher can have list of course

//    @OneToMany(
//            cascade = CascadeType.ALL
//
//    )
//    as this is 1 teacher to many course relation so there would be 1 extra column in course table as teacher_id
//    @JoinColumn(
//            name = "teacher_id",
//            referencedColumnName = "teacherId"
//    )
//    private List<Course> courses;




}
