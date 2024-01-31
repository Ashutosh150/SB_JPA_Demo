package com.Ashu.SB_JPA.demo.repository;

import com.Ashu.SB_JPA.demo.entity.Course;
import com.Ashu.SB_JPA.demo.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder().coursetitle("DSA").credit(6).build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.dcb.com")
//                .course(course)
                .build();

//        CourseMaterial courseMaterial = CourseMaterial.builder()
//                .url("www.GOOGLE.com")
//                .course(course)
//                .build();


        repository.save(courseMaterial);
    }
    
    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }

}