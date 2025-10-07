package core;

import java.util.ArrayList;
import java.lang.reflect.Array;

public class Clan {
    public int id;
    public String name;
    public int golds;
    public ArrayList<Province> provinces;
    public int income;
    public int actions;
    public int maxActions; //I plan to add ways to have more actions


    public Clan(int id, String name, int golds, int income, int maxActions) {
        this.id = id;
        this.name = name;
        this.golds = golds;
        this.provinces = new ArrayList<>();
        this.income = income;
        this.maxActions = maxActions;

    }



    public void addProvince(Province province) { provinces.add(province);}
    public void removeProvince(Province province) { provinces.remove(province);}

    //Add or remove a province to the clan



}
