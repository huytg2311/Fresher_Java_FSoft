package main;

import entity.Manager;
import entity.Mission;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== List Mission ===");
        listMission();
    }

    public static void listMission() {
        List<Mission> missionList = new ArrayList<>();
        missionList.add(new Manager(1, "Nguyen Van Hieu", 1, "Lam Cu Ly"));
        missionList.add(new Manager(2, "Le Ngoc Khoi", 2, "Lam Boc Vat"));
        missionList.add(new Manager(3, "Nguyen Van Hieu", 3, "Lam Tro"));
        missionList.add(new Manager(4, "Le Ngoc Khoi", 4, "Hay Ra De"));
        missionList.add(new Manager(5, "Nguyen Van Hieu", 5, "Lam Mau"));
        for (Mission ms : missionList
             ) {
            System.out.println(ms.toString());
        }
    }

}
