package com.Ashu.SB_JPA.demo.repository;

import com.Ashu.SB_JPA.demo.entity.Guardian;
import com.Ashu.SB_JPA.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;



    @Test
    public void saveStudent(){
        Student student = Student.builder().emailId("abc@yohoo.com").firstName("Ashu").lastName("Pal")
//                .guardianName("geetu").guardianEmail("geetu@gmail.com").guardianMobile("9322596201") // this arised due to emmedded & emmebedable

                .build();

        studentRepository.save(student);

    }

    // due to Emmebadable method now entire guardian is an different object
    @Test
    public void saveStudentwithNewGuardianDetails(){
        Guardian guardian = Guardian.builder()
                .name("geetu")
                .Email("geetu@gmail.com")
                .Mobile("9322596201")
                .build();

        Student student1 = Student.builder()
                .firstName("shivam")
                .emailId("shivam@gmail.com")
                .lastName("kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student1);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Ashu");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("sh");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("geetu");
        System.out.println("studentList = " + studentList);
    }


    @Test
    public void printgetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("ashu@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String FN = studentRepository.getStudentFirstNameByEmailAddress("ashu@gmail.com");
        System.out.println("FN = " + FN);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("ashu@gmail.com");
        System.out.println("student = " + student);
    }


    @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("ashu@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("Ashutosh", "ashu@gmail.com");


    }


}