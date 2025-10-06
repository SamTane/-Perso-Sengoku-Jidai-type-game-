package events;
import core.*;

public class Event {
    public String name;
    public String description;
    public int id;
    public Province province;

    public Event (int id, String name, String description, Province province) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.province = province;
    }

     public void triggerEvent() {
     }

}
