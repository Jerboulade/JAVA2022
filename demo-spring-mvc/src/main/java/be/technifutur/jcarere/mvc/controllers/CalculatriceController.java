package be.technifutur.jcarere.mvc.controllers;

import be.technifutur.jcarere.mvc.models.Calculatrice;
import be.technifutur.jcarere.mvc.models.Room;
import be.technifutur.jcarere.mvc.services.CalculatriceService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatriceController {
    private final CalculatriceService calculatriceService;

    public CalculatriceController(CalculatriceService calculatriceService) {
        this.calculatriceService = calculatriceService;
    }

    @GetMapping("/calculatrice")
    public String insertForm(Model model){

        model.addAttribute("calc", new Calculatrice());
        return "/calculatrice";
    }


    @PostMapping("/calculatrice")
    public String processInsert(Model model, @Valid Calculatrice form){
        Float res = null;

        switch (form.getOp()) {
            case "+" -> res = calculatriceService.addition(form.getNum1(), form.getNum2());
            case "-" -> res = calculatriceService.substraction(form.getNum1(), form.getNum2());
            case "*" -> res = calculatriceService.multiplication(form.getNum1(), form.getNum2());
            case "/" -> res = calculatriceService.division(form.getNum1(), form.getNum2());
            //default -> throw new IllegalStateException("Not a valid operation");
        }
        Calculatrice newCalc = new Calculatrice();
        if (res != null)
            newCalc.setNum1(res);
        model.addAttribute("calc", newCalc);
        model.addAttribute("result", res == null ? "Not a valid operation" : res);
        return "/calculatrice";
    }
}
