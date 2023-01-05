package src.be.technifutur.event.activities;

import java.time.LocalDateTime;

public class Meal extends Activity
{
    private String          dish;

    public          Meal() {
    }

    public String   getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", dish=" + dish +
                '}';
    }
}
