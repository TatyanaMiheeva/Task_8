package springBoot.task8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springBoot.task8.model.Person;
import springBoot.task8.service.PersonService;


@Controller
@RequestMapping(value = "/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String getAllPersons(Model model) {
        model.addAttribute("person", personService.getAllPersons());
        return "index";
    }

    @GetMapping("/{id}")
    public String getPersonById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", personService.getPersonById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "new";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("person") Person person) {
        personService.savePerson(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id){
        model.addAttribute("people", personService.getPersonById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("people") Person person, @PathVariable("id") Long id){
        personService.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        personService.delete(id);
        return "redirect:/people";
    }
}
