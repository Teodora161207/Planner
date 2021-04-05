package organizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import organizer.domain.Event;

import java.util.List;

public interface JpaEventRepository extends JpaRepository<Event,Long> {

    List<Event> findAll();

    List<Event> findByCategoryId(Long id);
    List<Event> findByPriorityId(Long id);


    long count();

    long countByCategoryId(Long categoryId);


    List<Event> findBy();
}
