package organizer.domain;

import javax.persistence.*;

@Entity

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String description;
    @ManyToOne
    @JoinColumn(name = "pri_id")
    private Priority priority;
    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;


    public Task(Long id, String name, String description, Priority priority, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.category = category;
    }

    public Task() {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
