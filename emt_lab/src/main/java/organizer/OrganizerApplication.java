package organizer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import organizer.domain.*;
import organizer.repository.*;

@EnableJpaRepositories
@ComponentScan
@SpringBootApplication
public class OrganizerApplication {

    public static void main (String[] args) {

        SpringApplication.run(OrganizerApplication.class,args);



    }

    @Bean
    CommandLineRunner runner(JpaCategoryRepository catRepo, JpaPriorityRepository priRepo, JpaTaskRepository taskRepo, JpaEventRepository eventRepo, JpaNoteRepository noteRepo) {
        return args -> {

            Category personal =new Category((long) 1,"Personal");
            Category work = new Category((long) 2,"Work");
            catRepo.save(personal);
            catRepo.save(work);

            Priority high = new Priority((long) 1,"High");
            Priority medium = new Priority((long) 2,"Medium");
            Priority low = new Priority((long) 3,"Low");

            priRepo.save(high);
            priRepo.save(medium);
            priRepo.save(low);


            Task task1 = new Task((long) 1, "Go grocery shopping", "Buy eggs and milk",high,personal);
            Task task2 = new Task((long) 2, "Implement GetCartMethod()", "Implement new method and fix bugs",medium,work);
            Task task3 = new Task((long) 3, "Call John", "Call John to keep in touch",low,personal);
            Task task4 = new Task((long) 4, "Schedule meeting ", "Schedule meeting with clients",high,work);

            taskRepo.save(task1);
            taskRepo.save(task2);
            taskRepo.save(task3);
            taskRepo.save(task4);

            Event event = new Event((long)1,"Maya's b-day party","Birthday party, have fun!",priRepo.getOne((long)2),personal,"Maya's home","01/04/2021","21:30");
            Event event1 = new Event((long)2,"Team meeting","Meet the team!",priRepo.getOne((long)1),work,"Office","02/08/2021","10:30");
            Event event2 = new Event((long)3,"Coffee with friends","Meet friends for coffee",priRepo.getOne((long)3),personal,"Joy's cafe","01/08/2021","20:00");

            eventRepo.save(event);
            eventRepo.save(event1);
            eventRepo.save(event2);
            Note note = new Note((long) 1, "Bugs", "New project has many bugs, needs fixing!");
            noteRepo.save(note);














        };

    }
}
