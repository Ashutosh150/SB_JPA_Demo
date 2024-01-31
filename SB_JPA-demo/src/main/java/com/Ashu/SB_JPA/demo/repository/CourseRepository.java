package com.Ashu.SB_JPA.demo.repository;

import com.Ashu.SB_JPA.demo.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // creating custom methods for PaginationAndSorting methods for Sorting part only
    Page<Course> findByCoursetitleContaining(String coursetitle, Pageable pageRequest);

}
