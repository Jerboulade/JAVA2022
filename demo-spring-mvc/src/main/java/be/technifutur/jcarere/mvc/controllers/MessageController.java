package be.technifutur.jcarere.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Controller
public class MessageController {
    // GET -> recupere page html
    // POST -> envoie formulaire

    // GET    -> https://localhost:8080/messages
    // link request to method
    @GetMapping("/message") // signifie que le methode ci-dessous est utilisée comme réponse à une requête
    public String getMessage(Model model){
        String message = "Mon message depuis le controller";
        model.addAttribute("message", message);
        return "message"; // je lui renvoie un vue qui est la page message.html
    }

    // GET https://localhost:8080/redirect
    @GetMapping("/redirect")
    public String redirect(){
        return "redirect:message";
    }

    // GET https://localhost:8080/forward
    @GetMapping("/forward")
    public String forward(){
        System.out.println("On passe par ici");
        return "forward:message";
    }

    @GetMapping("/text/{number:[0-9]+}")
    public String randomText(Model model, @PathVariable int number)
    {
        List<String> randomStrings = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < number; i++)
        {
            StringBuilder word = new StringBuilder();
            int size = random.nextInt(5) + 5;
            for (int j = 0; j < size; j++)
                word.append((char)('a' + random.nextInt(26)));
            randomStrings.add(word.toString());
        }
        model.addAttribute("words", randomStrings);
        return "/text/random";
    }
}
