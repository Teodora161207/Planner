package organizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import organizer.domain.Priority;

public interface JpaPriorityRepository extends JpaRepository<Priority,Long> {
}
