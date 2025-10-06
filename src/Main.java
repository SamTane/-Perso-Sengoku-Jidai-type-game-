import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        //Clans :
        Clan clan1 = new Clan(1, "Central", 120, 60, 2);
        Clan clan2 = new Clan(2, "Bandits", 70, 35, 1);
        Clan clan3 = new Clan(3, "The Craftmen", 100, 50, 2);
        Clan clan4 = new Clan(4, "Happy Merchants", 140, 70, 2);
        Clan clan5 = new Clan(5, "Nun Institute", 100, 50, 3);


        //Provinces :
        Province province1 = new Province(1, "The Middle", new int[]{2, 3, 4, 5}, clan1);
        clan1.addProvince(province1);
        Province province2 = new Province(2, "Rififi Forest", new int[]{1, 3, 5}, clan2);
        clan2.addProvince(province2);
        Province province3 = new Province(3, "Coco Hills", new int[]{1, 2, 4, 6}, clan1);
        clan3.addProvince(province3);
        Province province4 = new Province(4, "Porto Maestro", new int[]{1, 3, 5, 6}, clan1);
        clan4.addProvince(province4);
        Province province5 = new Province(5, "Miko Mountains", new int[]{1, 3, 4}, clan1);
        clan5.addProvince(province5);
        Province province6 = new Province(6, "Talmud", new int[]{3, 4}, clan1);
        clan4.addProvince(province6);


        // Clans & provinces list
        Clan[] clans = {clan1, clan2, clan3, clan4, clan5};
        ArrayList<Clan> clanList = new ArrayList<>(Arrays.asList(clans));
        Province[] allProvinces = {province1, province2, province3, province4, province5, province6};
        ArrayList<Province > provinceList = new ArrayList<>(Arrays.asList(allProvinces));

        // Turn
        TurnManager tm = new TurnManager(clanList, provinceList);
        for (int i = 0; i <= 2; i++) {
            tm.nextTurn();
            tm.resetActions();
            System.out.println("************");
            System.out.println("** Turn " + tm.turn + " **");
            System.out.println("************");
            for (Clan clan : clans) {

                System.out.println("< " + clan.name + " owns " + clan.provinces.size() + " provinces : >");
                for (Province province : clan.provinces) {
                    System.out.println(province.name + "." + " Borders :");
                     for (int neighborId : province.neighbors) {
                        for (Province p : allProvinces)
                            if (p.id == neighborId)
                                System.out.println(p.id + " : " + p.name + ".");
                     }
                }
                System.out.println(clan.actions + " actions");
                 System.out.println(clan.golds + " G");
                do {
                    tm.SimulateActions(clan, clan.provinces.get(0));
                    System.out.println(clan.actions + " actions left.");
                } while (clan.actions > 0);
            }
            tm.income();


        }
    }

}