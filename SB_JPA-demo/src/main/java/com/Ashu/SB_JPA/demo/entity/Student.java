package com.Ashu.SB_JPA.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(
        name = "tbl_Student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailId_unique",
                columnNames = "email_address"
        )
)  // to rename table Name in DB(1) + addigng contranint(2)



public class Student {


    @Id
    @SequenceGenerator(
            name = "student_seq",
            sequenceName = "student_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_seq"
    )
    private Long StudentId;
    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false        // everytime we add student it should contain this parameter if data not entered then it will throw an exception
    )  // to rename column Name in DB(1) + (2)
    // adding constraint to a column to contain unique value (2)
    private String emailId;

    //Embedded & Embeddable
    @Embedded
    private Guardian guardian;




}
