package com.Ashu.SB_JPA.demo.repository;

import com.Ashu.SB_JPA.demo.entity.Course;
import com.Ashu.SB_JPA.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher(){
        Course courseDBA = Course.builder().coursetitle("DBA").credit(5).build();

        Course courseJAVA = Course.builder().coursetitle("JAVA").credit(8).build();


        Teacher teacher = Teacher.builder().firstName("qutub").lastName("khan")
//                .courses(List.of(courseDBA, courseJAVA))
                .build();

        teacherRepository.save(teacher);

    }

}