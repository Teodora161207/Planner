package organizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import organizer.domain.Event;
import organizer.domain.Note;
import organizer.domain.Task;
import organizer.repository.*;

@Controller

public class HomeController {



    private final JpaCategoryRepository categoryRepository;
    private final JpaEventRepository eventRepository;
    private final JpaTaskRepository taskRepository;
    private final JpaNoteRepository noteRepository;
    private final JpaPriorityRepository priorityRepository;

    public HomeController(JpaCategoryRepository categoryRepository, JpaEventRepository eventRepository, JpaTaskRepository taskRepository, JpaNoteRepository noteRepository, JpaPriorityRepository priorityRepository) {
        this.categoryRepository = categoryRepository;
        this.eventRepository = eventRepository;
        this.taskRepository = taskRepository;
        this.noteRepository = noteRepository;
        this.priorityRepository = priorityRepository;
    }



    @GetMapping("/index")

    public String index(Model model){
        model.addAttribute("tasks",taskRepository.findAll());
        model.addAttribute("notes",noteRepository.findAll());
        model.addAttribute("events",eventRepository.findAll());
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("priorities",priorityRepository.findAll());

        return "index";
    }


    @GetMapping("/task/add")
    public String addTask(Model model) {
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("priorities",priorityRepository.findAll());
        model.addAttribute("task", new Task());

        return "addTask";

    }

    @PostMapping("/task/add")
    public String addTask(@ModelAttribute Task task) {
        taskRepository.save(task);
        return "redirect:/index/";

    }


    @GetMapping("/task/edit/{id}")
    public String editTask(@PathVariable long id,Model model) {
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("priorities",priorityRepository.findAll());
        model.addAttribute("task", taskRepository.getOne(id));

        return "editTask";

    }

    @PostMapping("/task/update/{id}")
    public String updateTask(@ModelAttribute Task task,@PathVariable long id) {
        task.setId(id);
        taskRepository.save(task);
        return "redirect:/index/";

    }




    @GetMapping("/task/{id}")
    public String taskDetails(@PathVariable Long id, Model model) {

        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("priorities",priorityRepository.findAll());
        model.addAttribute("task",taskRepository.getOne(id));

        return "taskDetails";
    }


    @PostMapping("/task/delete/{id}")
    public String taskDelete(@PathVariable Long id, Model model) {

        Task t = taskRepository.getOne(id);
        taskRepository.delete(t);


        model.addAttribute("tasks",taskRepository.findAll());
        model.addAttribute("notes",noteRepository.findAll());
        model.addAttribute("events",eventRepository.findAll());
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("priorities",priorityRepository.findAll());

        return "redirect:/index/";
    }

    @GetMapping("/note/add")
    public String addNote(Model model) {
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("priorities",priorityRepository.findAll());
        model.addAttribute("note", new Note());

        return "addNote";

    }

    @PostMapping("/note/add")
    public String addNote(@ModelAttribute Note note) {
        noteRepository.save(note);
        return "redirect:/index/";

    }


    @GetMapping("/note/{id}")
    public String noteDetails(@PathVariable Long id, Model model) {

        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("priorities",priorityRepository.findAll());
        model.addAttribute("note",noteRepository.getOne(id));

        return "noteDetails";
    }


    @PostMapping("/note/delete/{id}")
    public String noteDelete(@PathVariable Long id, Model model) {

        Note n = noteRepository.getOne(id);
        noteRepository.delete(n);


        model.addAttribute("tasks",taskRepository.findAll());
        model.addAttribute("notes",noteRepository.findAll());
        model.addAttribute("events",eventRepository.findAll());
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("priorities",priorityRepository.findAll());

        return "redirect:/index/";
    }


    @GetMapping("/note/edit/{id}")
    public String noteTask(@PathVariable long id,Model model) {
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("priorities",priorityRepository.findAll());
        model.addAttribute("note", noteRepository.getOne(id));

        return "editNote";

    }

    @PostMapping("/note/update/{id}")
    public String noteTask(@ModelAttribute Note note,@PathVariable long id) {
        note.setId(id);
        noteRepository.save(note);
        return "redirect:/index/";

    }



    @GetMapping("/event/edit/{id}")
    public String editEvent(@PathVariable long id,Model model) {
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("priorities",priorityRepository.findAll());
        model.addAttribute("event", eventRepository.getOne(id));

        return "editEvent";

    }

    @PostMapping("/event/update/{id}")
    public String updateEvent(@ModelAttribute Event event,@PathVariable long id) {
        event.setId(id);
        eventRepository.save(event);
        return "redirect:/index/";

    }


    @GetMapping("/event/add")
    public String addEvent(Model model) {
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("priorities",priorityRepository.findAll());
        model.addAttribute("event", new Event());

        return "addEvent";

    }

    @PostMapping("/event/add")
    public String addEvent(@ModelAttribute Event event) {
        eventRepository.save(event);
        return "redirect:/index/";

    }


    @GetMapping("/event/{id}")
    public String eventDetails(@PathVariable Long id, Model model) {

        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("priorities",priorityRepository.findAll());
        model.addAttribute("event",eventRepository.getOne(id));

        return "eventDetails";
    }


    @PostMapping("/event/delete/{id}")
    public String eventDelete(@PathVariable Long id, Model model) {

        Event e = eventRepository.getOne(id);
        eventRepository.delete(e);


        model.addAttribute("tasks",taskRepository.findAll());
        model.addAttribute("notes",noteRepository.findAll());
        model.addAttribute("events",eventRepository.findAll());
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("priorities",priorityRepository.findAll());

        return "redirect:/index/";
    }


    @GetMapping("/category/{id}")
    public String getByCategoryId(@PathVariable long id, Model model) {

        model.addAttribute("tasks",taskRepository.findByCategoryId(id));
        model.addAttribute("events",eventRepository.findByCategoryId(id));
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("priorities",priorityRepository.findAll());
        model.addAttribute("info",categoryRepository.findById(id).get().getName());

        return "indexBy";
    }


    @GetMapping("/priority/{id}")
    public String getByPriorityId(@PathVariable long id, Model model) {

        model.addAttribute("tasks",taskRepository.findByPriorityId(id));
        model.addAttribute("events",eventRepository.findByPriorityId(id));
        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("priorities",priorityRepository.findAll());
        model.addAttribute("info",priorityRepository.findById(id).get().getName());

        return "indexBy";
    }


}
