package organizer.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import organizer.domain.Task;

import java.util.List;

public interface JpaTaskRepository extends JpaRepository<Task,Long> {


    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"priority"})
    List<Task> findAll();

    List<Task> findByCategoryId(Long id);
    List<Task> findByPriorityId(Long id);


    long count();

    long countByCategoryId(Long categoryId);


    List<Task> findBy();




}
