package coursemanagement.coursemanagement.repository;

import coursemanagement.coursemanagement.entities.HomeWork;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeWorkRepository extends JpaRepository<HomeWork, Long> {
}
