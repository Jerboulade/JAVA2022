package src.be.technifutur.event.activities;

import java.time.LocalDateTime;

public class Housing extends Activity
{
    private int  room;

    public      Housing() {
    }

    public int  getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", room=" + room +
                '}';
    }
}
