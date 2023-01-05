package src.be.technifutur.event.activities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Session extends Activity
{
    public SessionCategory  category;

    public                  Session() {
    }

    public SessionCategory  getCategory() {
        return category;
    }

    public void             setCategory(SessionCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", category=" + category +
                '}';
    }
}
