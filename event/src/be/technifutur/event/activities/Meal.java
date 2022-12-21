package src.be.technifutur.event.activities;

import java.time.LocalDateTime;

public class Meal extends Activity
{
    String          dish;

    public          Meal(LocalDateTime startTime) {
        super (startTime);
    }

    public String   getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }
}
