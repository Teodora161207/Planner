package organizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import organizer.domain.Note;

import java.util.List;

public interface JpaNoteRepository extends JpaRepository<Note, Long> {

    List<Note> findAll();



    long count();




    List<Note> findBy();
}
