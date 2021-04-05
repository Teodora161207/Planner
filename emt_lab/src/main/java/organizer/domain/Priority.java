package organizer.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_manufacturers")
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "priority", fetch = FetchType.LAZY)
    private List<Task> taskList;


    @OneToMany(mappedBy = "priority", fetch = FetchType.LAZY)
    private List<Event> eventList;

    public Priority(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Priority() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
