import java.util.ArrayList;
import java.util.Arrays;

 class Event {
    public String name;
    public String description;
    public int id;
    public Province province;
    public Clan clan;

    public Event (int id, String name, String description, Province province, Clan clan) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.province = province;
        this.clan = clan;
    }

     public void triggerEvent() {
        System.out.println("[" + clan.name + "] triggers event : |" + name + "| in " + province.name);
        System.out.println(description);
     }

}
