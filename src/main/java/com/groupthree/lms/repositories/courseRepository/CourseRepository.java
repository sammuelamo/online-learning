package com.groupthree.lms.repositories.courseRepository;

import com.groupthree.lms.models.courseModel.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
