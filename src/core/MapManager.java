package core;

import java.util.ArrayList;

public class MapManager {
    public ArrayList<Clan> clans;
    public ArrayList<Province> provinces;

    public MapManager(ArrayList<Clan> clans, ArrayList<Province> provinces) {
        this.clans = clans;
        this.provinces = provinces;
    }

    public void neighborsSetting() {
        //Listes des provinces voisines d'une province.
        for (int indexProvince = 0; indexProvince < provinces.size(); indexProvince++) {
            for (int indexId = 0; indexId < provinces.get(indexProvince).neighborsID.length; indexId++) {
                for (Province province : provinces) {
                    if (provinces.get(indexProvince).neighborsID[indexId] == province.id) {
                        if (!provinces.get(indexProvince).neighbors.contains(province)) {
                            provinces.get(indexProvince).addNeighbor(province);
                        }
                    }
                }
            }
        }

        //Liste des provinces voisines d'un clan.
        for (Clan clan : clans) {
            for (Province province : clan.provinces) {
                for (Province provinceNeighbor : province.neighbors) {
                    if (!clan.provinceNeighbors.contains(provinceNeighbor) && !clan.provinces.contains(provinceNeighbor)) {
                        clan.addProvinceNeighbor(provinceNeighbor);
                    }
                }
            }
        }

        //Liste des clans voisins d'un clan.
        for (Clan clan : clans) {
                for (Province province : clan.provinceNeighbors) {
                    if (!clan.clanNeighbors.contains(province.owner) && !(clan == province.owner)) {
                        clan.addClanNeighbor(province.owner);
                    }
                }
        }

    }
}
