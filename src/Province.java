import java.util.ArrayList;

public class Province {
    public int id;
    public String name;
    public int[] neighbors;
    public Clan owner;
    public ArrayList<Event> availableEvents;

    public Province(int id, String name, int[] neighbors, Clan owner) {
        this.id = id;
        this.name = name;
        this.neighbors = neighbors;
        this.owner = owner;
        this.availableEvents = new ArrayList<>();
    }
    public void addEvent(Event event) {
        availableEvents.add(event);
    }


}
