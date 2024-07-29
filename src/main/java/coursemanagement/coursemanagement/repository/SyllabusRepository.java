package coursemanagement.coursemanagement.repository;

import coursemanagement.coursemanagement.entities.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusRepository extends JpaRepository<Syllabus, Long> {
}
