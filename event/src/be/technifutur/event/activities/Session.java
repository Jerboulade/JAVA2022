package src.be.technifutur.event.activities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Session extends Activity
{
    public SessionCategory  category;

    public                  Session(LocalDateTime startTime) {
        super (startTime);
    }

    public SessionCategory  getCategory() {
        return category;
    }

    public void             setCategory(SessionCategory category) {
        this.category = category;
    }
}
