package be.technifutur.jcarere.mvc.services;

import be.technifutur.jcarere.mvc.models.Calculatrice;
import be.technifutur.jcarere.mvc.models.Room;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CalculatriceService {

    public float addition(float num1, float num2){
        return num1 + num2;
    }
    public float substraction(float num1, float num2){
        return num1 - num2;
    }
    public float multiplication(float num1, float num2){
        return num1 * num2;
    }
    public float division(float num1, float num2){
        return num1 / num2;
    }
}
