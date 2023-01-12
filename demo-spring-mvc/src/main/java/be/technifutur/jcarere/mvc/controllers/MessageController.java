package be.technifutur.jcarere.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
