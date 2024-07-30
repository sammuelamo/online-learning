package com.groupthree.lms.repository;

import com.groupthree.lms.entities.Topics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topics, Long> {
}
