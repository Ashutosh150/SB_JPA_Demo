package com.Ashu.SB_JPA.demo.repository;

import com.Ashu.SB_JPA.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // custom methods created by user to fetch DATA
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

//    List<Student> findByLastNameNotNull(String lastname);


    List<Student> findByGuardianName(String guardianName);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);


    // jpql queries(these are based on class_NAME(Student) & attributes(emailId) that are defined in class)
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    // Native sql queries(these are based on class_NAME(Student) & attributes(emailId) that are defined in class)
    @Query(
            value = "select * from tbl_Student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);


    // Native named parameters if we have lot of parameters passing through query
    @Query(
            value = "select * from tbl_Student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);



    // custom methods created by user to update DATA   (Modifying annotation)

    @Modifying
    @Transactional // whenever there is an update in DB so there would be a transaction update nd this will finally commit the update in DB ... usually transaction are done in service layer
    @Query(
            value = "update tbl_Student set first_Name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);


}
