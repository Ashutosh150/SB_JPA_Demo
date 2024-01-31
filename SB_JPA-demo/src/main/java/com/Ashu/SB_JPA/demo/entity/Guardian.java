package com.Ashu.SB_JPA.demo.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

// Mapping column of guardian with exact same column that already existed in stu_Table
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "Email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "Mobile",
                column = @Column(name = "guardian_mobile")
        )
})

public class Guardian {


    private String name;
    private String Email;
    private String Mobile;

}
