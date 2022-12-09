package fa.training.services;

import fa.training.entities.AirPorts;
import fa.training.entities.Fixedwing;
import fa.training.entities.Helicopters;

import java.util.ArrayList;
import java.util.List;

public class AirPortsService {

    List<AirPorts> airPortsList;
    List<Fixedwing> fixedwingList;
    List<Helicopters> helicoptersList;
    public AirPortsService() {
        airPortsList = new ArrayList<>();
        airPortsList.add(new AirPorts("AP00001", "Danang", 5, 2, 3));
        airPortsList.add(new AirPorts("AP00002", "HCM", 5, 2, 3));
        airPortsList.add(new AirPorts("AP00003", "Hanoi", 5, 2, 3));
        airPortsList.add(new AirPorts("AP00004", "Dalat", 5, 2, 3));
        fixedwingList = new ArrayList<>();
        helicoptersList = new ArrayList<>();
    }

    public void add(AirPorts airPorts) {
        airPortsList.add(airPorts);
    }

    public void addHelicopters(String id, List<Helicopters> helicoptersList) {
        for (AirPorts a : airPortsList
        ) {
            if (a.getId().equals(id)) {
                a.setHelicoptersList(helicoptersList);
                System.out.println(a.toString());
            }
        }
    }


    public void updateFixedwing(String id, List<Fixedwing> fixedwingList) {
        for (AirPorts a : airPortsList
        ) {
            if (a.getId().equals(id)) {
                a.setFixedwingList(fixedwingList);
                System.out.println(a.toString());
            }
        }
    }

    public void removeFixedwing(String id) {
        for (Fixedwing f: fixedwingList) {
            if (f.getId().equals(id)) {
                fixedwingList.remove(f);
            }
        }
    }

    public void updatefix(String s1, String s2, Double d1) {
        for (Fixedwing f: fixedwingList
             ) {
            if (f.getId().equals(s1)) {
                f.setPlaneType(s2);
                f.setMinRunwaySize(d1);
            }
        }
    }
}
