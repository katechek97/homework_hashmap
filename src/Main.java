
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;


public class Main {
    public static void main(String[] args) {
//        ArrayList<String> strings = new ArrayList<>();
//
//        for (int i = 0; i < 100; i++) {
//            if (i % 7 == 0) {
//                strings.add("Семь");
//            } else if (i % 5 == 0) {
//                strings.add("Пять");
//            } else if (i % 3 == 0) {
//                strings.add("Три");
//            } else if (i % 2 == 0) {
//                strings.add("Два");
//            }
//        }
//        System.out.println(strings);
//
//
//        HashSet<String> hashSet = new HashSet<>(strings);
//        System.out.println(hashSet);
//
//        ArrayList<String> arrayListFromHashSet = new ArrayList<>(hashSet);
//        System.out.println(arrayListFromHashSet);
//
//
//        HashMap<Integer, List<String>> hashMap = new HashMap<>();
//
//        for (int i = 0; i < 100; i++) {
//            hashMap.put(i+1, new ArrayList<>());
//            System.out.println(hashMap.get(i+1));
//
//        }
//
//        ArrayList<String> peopleFromFirstFlat = new ArrayList<>();
//        peopleFromFirstFlat.add("Ivan");
//        peopleFromFirstFlat.add("Sasha");
//
//        ArrayList<String> peopleFromFifteenthFlat = new ArrayList<>();
//        peopleFromFifteenthFlat.add("Katya");
//        peopleFromFifteenthFlat.add("Vasya");
//
//        ArrayList<String> peopleFromFortysixthFlat = new ArrayList<>();
//        peopleFromFortysixthFlat.add("Sonya");
//
//        hashMap.put(1, peopleFromFirstFlat);
//        hashMap.put(15, peopleFromFifteenthFlat);
//        hashMap.put(46, peopleFromFortysixthFlat);
//        System.out.println(peopleFromFifteenthFlat);
//        peopleFromFifteenthFlat.add("Petr");
//        System.out.println(peopleFromFifteenthFlat);
//        hashMap.forEach((integer, strings1) -> System.out.println(integer + strings1.toString()));
//        ArrayList<String> newList = (ArrayList<String>) hashMap.remove(15);
//        System.out.println(hashMap);
//        hashMap.put(15, newList.contains("Petr") ? List.of("Petr") : new ArrayList<>());
//        newList.remove("Petr");
//        hashMap.put(70, newList);
//        System.out.println(newList);
//        System.out.println(hashMap);


        class House {
            int houseNumber;
            int builtDate;
            double distanceFromStreet;
            String street;

            public House(int houseNumber, int builtDate, double distanceFromStreet, String street) {
                this.houseNumber = houseNumber;
                this.builtDate = builtDate;
                this.distanceFromStreet = distanceFromStreet;
                this.street = street;
            }
            public void setHouseNumber(int houseNumber) {this.houseNumber = houseNumber;
            }
            public void setDistanceFromStreet(double distanceFromStreet) {this.distanceFromStreet = distanceFromStreet;
            }
            public int getHouseNumber() {
                return houseNumber;
            }
            public int getBuiltDate() {
                return builtDate;
            }

            public double getDistanceFromStreet() {
                return distanceFromStreet;
            }

            public String getStreet() {return street;}

            public void setStreet(String street) {this.street = street;}

            public String toString() {
                return "Дом " + "№" + houseNumber + " год постройки " + builtDate + ", расстояние " + distanceFromStreet + " м";
        }
        }

        // Первый вариант (ключ - улица)
        HashMap<String, List<House>> mapByStreets= new HashMap<>();


            List<House> houseOnLeninStreet = new ArrayList<>();

            houseOnLeninStreet.add(new House(1, 2023, 15, "улица Ленина"));
            houseOnLeninStreet.add(new House(2, 2023, 15, "улица Ленина"));
            houseOnLeninStreet.add(new House(3, 2023, 15, "улица Ленина"));

            mapByStreets.put("улица Ленина", houseOnLeninStreet);

        List<House> houseOnLanskayaStreet = new ArrayList<>();
        houseOnLanskayaStreet.add(new House(4, 2022, 40, "улица Ланская"));
        houseOnLanskayaStreet.add(new House(5, 2022, 40, "улица Ланская"));
        houseOnLanskayaStreet.add(new House(6, 2022, 40, "улица Ланская"));

        mapByStreets.put("улица Ланская", houseOnLanskayaStreet);
        System.out.println(mapByStreets);

        // добавление новых домов на улицу
        List<House> newHouses = mapByStreets.get("улица Ланская");
        newHouses.add(new House(7, 2024, 40, "улица Ланская"));
        System.out.println(mapByStreets);

        //изменение номера дома и расположения
        List<House> houseChange1 = mapByStreets.get("улица Ленина");
        for(House house : houseChange1) {
            if (house.houseNumber == 1) {
                house.setHouseNumber(8);
                house.setDistanceFromStreet(17);
                break;
            }
        }

        List<House> houseChange2 = mapByStreets.get("улица Ланская");
        for(House house : houseChange2) {
            if (house.houseNumber == 6) {
                house.setHouseNumber(9);
                house.setDistanceFromStreet(50);
                break;
            }
        }

        System.out.println(mapByStreets);

        //снос домов
        List<House> houseToRemove1 = mapByStreets.get("улица Ленина");
        houseToRemove1.removeIf(house -> house.houseNumber == 8 && house.builtDate == 2023 && house.distanceFromStreet == 17);

        List<House> houseToRemove2 = mapByStreets.get("улица Ланская");
        houseToRemove2.removeIf(house -> house.houseNumber == 9 && house.builtDate == 2022 && house.distanceFromStreet == 50);
        System.out.println(mapByStreets);

        // Второй вариант (ключ - номер дома)

        Map<Integer, House> mapByHouseNumbers = new HashMap<>();
        for (House house : mapByStreets.get("улица Ленина")) {
            house.setStreet("улица Ленина");
            mapByHouseNumbers.put(house.getHouseNumber(), house);
        }
        for (House house : mapByStreets.get("улица Ланская")) {
            house.setStreet("улица Ланская");
            mapByHouseNumbers.put(house.getHouseNumber(), house);
        }

        for (Integer key : mapByHouseNumbers.keySet()) {
            House house = mapByHouseNumbers.get(key);
            System.out.println("Дом № " + key + ": " + house.getBuiltDate() + ", " + house.getStreet() + " " + house.getDistanceFromStreet() + " м");

        }
       // добавление дома на улицу
        House newHouse = new House (13, 2025, 140, "улица Ленина");
        mapByHouseNumbers.put(newHouse.getHouseNumber(), newHouse);
        System.out.println(mapByHouseNumbers);

        // удаление дома
        mapByHouseNumbers.remove(4);
        System.out.println(mapByHouseNumbers);

        // изменение информации о доме
        House houseToChange = mapByHouseNumbers.get(3);
        houseToChange.setDistanceFromStreet(28);
        System.out.println(mapByHouseNumbers);



























    }
}



