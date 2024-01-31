package com.Ashu.SB_JPA.demo.repository;

import com.Ashu.SB_JPA.demo.entity.Course;
import com.Ashu.SB_JPA.demo.entity.Student;
import com.Ashu.SB_JPA.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void printCourses(){
        List<Course> courses = repository.findAll();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder().firstName("priyanka").lastName("singh").build();

        Course course = Course.builder().coursetitle("python").credit(7).teacher(teacher).build();

        repository.save(course);
    }

    // pagination
    @Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords = PageRequest.of(0,3);
        Pageable secondPagewithTwoRecords = PageRequest.of(1,2);


        List<Course> courses = repository.findAll(secondPagewithTwoRecords).getContent();

        long totaElements = repository.findAll(secondPagewithTwoRecords).getTotalElements();

        long totalPages = repository.findAll(secondPagewithTwoRecords).getTotalPages();

        System.out.println("courses = " + courses);
        System.out.println("totaElements = " + totaElements);
        System.out.println("totalPages = " + totalPages);

    }

    //pagination with sorting
    @Test
    public void findAllPaginationSorting(){
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("coursetitle"));

        Pageable sortByCreditDecendingOrder = PageRequest.of(1, 2, Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDecendingOrder = PageRequest.of(2, 2, Sort.by("title").descending().and(Sort.by("credit").descending()));

        List<Course> courses = repository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);

        System.out.println("sortByTitle = " + sortByTitle);
        System.out.println("sortByCreditDecendingOrder = " + sortByCreditDecendingOrder);
        System.out.println("sortByTitleAndCreditDecendingOrder = " + sortByTitleAndCreditDecendingOrder);

    }


    //trying custom methods created for Sorting part Only
    @Test
    public void printfindByTitleContaining(){
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> courses = repository.findByCoursetitleContaining("D", firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }


    // testing m-to-m implementation
    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder().firstName("Prince").lastName("Pal").build();

        Student student = Student.builder().firstName("Abhishek").lastName("singh").emailId("abhi@gmail.com").build();

        Course course = Course.builder()
                .coursetitle("AI").credit(4).teacher(teacher)
                .build();

        course.addStudent(student);

        repository.save(course);
    }

}