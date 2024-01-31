package com.Ashu.SB_JPA.demo.repository;

import com.Ashu.SB_JPA.demo.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

}
