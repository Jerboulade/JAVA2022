package src.be.technifutur.event.activities;

import java.time.LocalDateTime;

public class Housing extends Activity
{
    public int  room;

    public      Housing(LocalDateTime startTime) {
        super (startTime);
    }

    public int  getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
