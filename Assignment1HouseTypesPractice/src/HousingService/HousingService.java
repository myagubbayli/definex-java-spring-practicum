package HousingService;

import Housing.House;
import Housing.SummerHouse;
import Housing.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HousingService {
    private List<House> houses;
    private List<Villa> villas;
    private List<SummerHouse> summerHouses;

    public HousingService() {
        houses = new ArrayList<>();
        villas = new ArrayList<>();
        summerHouses = new ArrayList<>();
    }

    public void addHouse(House house) {
        houses.add(house);
    }

    public void addVilla(Villa villa) {
        villas.add(villa);
    }

    public void addSummerHouse(SummerHouse summerHouse) {
        summerHouses.add(summerHouse);
    }

    public List<String> getHouses() {
        return houses.stream()
                .map(house -> "Price: " + house.getPrice() +
                        ", Area: " + house.getArea() +
                        ", Room Count: " + house.getRoomCount() +
                        ", Living Room Count: " + house.getLivingRoomCount())
                .collect(Collectors.toList());
    }


    public List<String> getVillas() {
        return villas.stream()
                .map(villa -> "Price: " + villa.getPrice() +
                        ", Area: " + villa.getArea() +
                        ", Room Count: " + villa.getRoomCount() +
                        ", Living Room Count: " + villa.getLivingRoomCount())
                .collect(Collectors.toList());
    }

    public List<String> getSummerHouses() {
        return summerHouses.stream()
                .map(summerHouse -> "Price: " + summerHouse.getPrice() +
                        ", Area: " + summerHouse.getArea() +
                        ", Room Count: " + summerHouse.getRoomCount() +
                        ", Living Room Count: " + summerHouse.getLivingRoomCount())
                .collect(Collectors.toList());
    }

    public int getTotalHousePrice() {
        return houses.stream().mapToInt(House::getPrice).sum();
    }

    public int getTotalVillaPrice() {
        return villas.stream().mapToInt(Villa::getPrice).sum();
    }

    public int getTotalSummerHousePrice() {
        return summerHouses.stream().mapToInt(SummerHouse::getPrice).sum();
    }

    public int getTotalPrice() {
        return getTotalHousePrice() + getTotalVillaPrice() + getTotalSummerHousePrice();
    }

    public double getAverageHouseArea() {
        return houses.stream().mapToInt(House::getArea).average().orElse(0);
    }

    public double getAverageVillaArea() {
        return villas.stream().mapToInt(Villa::getArea).average().orElse(0);
    }

    public double getAverageSummerHouseArea() {
        return summerHouses.stream().mapToInt(SummerHouse::getArea).average().orElse(0);
    }

    public double getTotalAverageArea() {
        int totalHouseCount = houses.size() + villas.size() + summerHouses.size();
        if (totalHouseCount == 0) {
            return 0;
        }
        int totalArea = Stream.concat(houses.stream(), Stream.concat(villas.stream(), summerHouses.stream()))
                .mapToInt(House::getArea)
                .sum();
        return totalArea / (double) totalHouseCount;
    }

    public Map<String, List<String>> filterHousesByRoomAndLivingRoomCount(int minRooms, int minLivingRooms) {
        return Stream.concat(houses.stream(), Stream.concat(villas.stream(), summerHouses.stream()))
                .filter(house -> house.getRoomCount() == minRooms && house.getLivingRoomCount() == minLivingRooms)
                .collect(Collectors.groupingBy(house -> house.getClass().getSimpleName(),
                        Collectors.mapping(house -> String.format("Price: %s, Area: %s, Room count: %s, Living room count: %s",
                                house.getPrice(), house.getArea(), house.getRoomCount(), house.getLivingRoomCount()), Collectors.toList())));
    }
}
