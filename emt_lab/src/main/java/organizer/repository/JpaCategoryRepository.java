package organizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import organizer.domain.Category;

public interface JpaCategoryRepository extends JpaRepository<Category,Long> {
}
