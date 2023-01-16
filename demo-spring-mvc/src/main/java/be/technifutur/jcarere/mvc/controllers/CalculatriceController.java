package be.technifutur.jcarere.mvc.controllers;

import be.technifutur.jcarere.mvc.models.Calculatrice;
import be.technifutur.jcarere.mvc.models.Room;
import be.technifutur.jcarere.mvc.services.CalculatriceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String processInsert(Model model, Calculatrice form){
        float res = 0;
        String result;

        if (form.getOp().equals("+")) {
            res = calculatriceService.addition(form.getNum1(), form.getNum2());
            result = String.valueOf(res);
        }
        else if (form.getOp().equals("-")) {
            res = calculatriceService.substraction(form.getNum1(), form.getNum2());
            result = String.valueOf(res);
        }
        else if (form.getOp().equals("*")) {
            res = calculatriceService.multiplication(form.getNum1(), form.getNum2());
            result = String.valueOf(res);
        }
        else if (form.getOp().equals("/")) {
            res = calculatriceService.division(form.getNum1(), form.getNum2());
            result = String.valueOf(res);
        }
        else
            result = "Not a valid operation";
        Calculatrice newCalc = new Calculatrice();
        newCalc.setNum1(res);
        model.addAttribute("calc", new Calculatrice());

        model.addAttribute("result", result);
        return "/calculatrice";
    }
}
