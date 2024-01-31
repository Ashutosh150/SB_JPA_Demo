package com.Ashu.SB_JPA.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


@ToString(
        exclude = "course"
)

public class CourseMaterial {


    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;


    // Mapping is done in such wa that courseMaterial cant exist without a course
    @OneToOne(
            // cascading is done as course_Material(eg. child) cant be saved if there is no course(eg. parent) present for it So we can cascade nd force to save parent along with child
            cascade = CascadeType.ALL,

            // fetch is used to get data as per need between 2 class related to each other
            // FetchType.LAZY -- this will fetch data for child (courseMaterial), unless we specifically ask for parent as well
            // FetchType.EAGER -- this will fetch data for child as well as parent (courseMaterial & courseMaterial)
            fetch = FetchType.LAZY,

            // optional = true -- is used that this class can be treated as optional to have so Course can be created even if courseMaterial is not created
            // optional = true -- is used that this is to be treated as mandatory thar course cant be created without creating courseMaterial
            optional = false

    )
    // then defining foreign key using join column
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
