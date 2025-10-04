import java.util.ArrayList;

public class Clan {
    public int id;
    public String name;
    public int golds;
    public ArrayList<Province> provinces;

    public Clan(int id, String name, int golds) {
        this.id = id;
        this.name = name;
        this.golds = golds;
        this.provinces = new ArrayList<>();

    }

    public void addProvince(Province province) {
        provinces.add(province);
    }

    public void removeProvince(Province province) {
        provinces.remove(province);
    }


}
