package springBoot.task8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller(value = "/")
public class HelloController {
   @GetMapping
    public String printWelcome(Model model){
       List<String> messages = new ArrayList<>();
       messages.add("Message from HelloController");
       model.addAttribute("messages", messages);
       return "index";
    }
}
