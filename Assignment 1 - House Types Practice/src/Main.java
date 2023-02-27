import Housing.House;
import Housing.SummerHouse;
import Housing.Villa;
import HousingService.HousingService;

public class Main {
    public static void main(String[] args) {
        // Create some houses, villas, and summer houses
        House house1 = new House(120000, 80, 3, 2);
        House house2 = new House(180000, 100, 4, 3);
        House house3 = new House(200000, 120, 5, 4);

        Villa villa1 = new Villa(350000, 200, 5, 3);
        Villa villa2 = new Villa(450000, 300, 6, 4);
        Villa villa3 = new Villa(550000, 400, 7, 5);

        SummerHouse summerHouse1 = new SummerHouse(150000, 100, 2, 1);
        SummerHouse summerHouse2 = new SummerHouse(250000, 160, 1, 1);
        SummerHouse summerHouse3 = new SummerHouse(350000, 180, 3, 2);

        // Create a HousingService and add the houses, villas, and summer houses
        HousingService housingService = new HousingService();
        housingService.addHouse(house1);
        housingService.addHouse(house2);
        housingService.addHouse(house3);

        housingService.addVilla(villa1);
        housingService.addVilla(villa2);
        housingService.addVilla(villa3);

        housingService.addSummerHouse(summerHouse1);
        housingService.addSummerHouse(summerHouse2);
        housingService.addSummerHouse(summerHouse3);

        // Test the methods
        System.out.println("House list: " + housingService.getHouses());
        System.out.println("Villa list: " + housingService.getVillas());
        System.out.println("Summer House list: " + housingService.getSummerHouses());

        System.out.println("Total price of houses: " + housingService.getTotalHousePrice());
        System.out.println("Total price of villas: " + housingService.getTotalVillaPrice());
        System.out.println("Total price of summer houses: " + housingService.getTotalSummerHousePrice());
        System.out.println("Total price of all housing: " + housingService.getTotalPrice());

        System.out.println("Average area of houses: " + housingService.getAverageHouseArea());
        System.out.println("Average area of villas: " + housingService.getAverageVillaArea());
        System.out.println("Average area of summer houses: " + housingService.getAverageSummerHouseArea());
        System.out.println("Average area of all housing: " + housingService.getTotalAverageArea());

        System.out.println("Housing with 3 rooms and 2 living rooms: " +
                housingService.filterHousesByRoomAndLivingRoomCount(3, 2));
    }
}