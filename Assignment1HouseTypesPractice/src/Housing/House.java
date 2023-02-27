package Housing;

public class House {
    private int price;
    private int area;
    private int roomCount;
    private int livingRoomCount;

    public House(int price, int area, int roomCount, int livingRoomCount) {
        this.price = price;
        this.area = area;
        this.roomCount = roomCount;
        this.livingRoomCount = livingRoomCount;
    }

    public int getPrice() {
        return price;
    }

    public int getArea() {
        return area;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public int getLivingRoomCount() {
        return livingRoomCount;
    }
}
