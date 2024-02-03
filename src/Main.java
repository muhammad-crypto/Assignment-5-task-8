import java.util.ArrayList;

// City class
class City {
    private String name;
    private ArrayList<Building> buildings;

    public City(String name) {
        this.name = name;
        this.buildings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public void removeBuilding(Building building) {
        buildings.remove(building);
    }

    public Building findBuilding(String streetName, String houseNumber) {
        for (Building building : buildings) {
            if (building.getStreetName().equals(streetName) && building.getHouseNumber().equals(houseNumber)) {
                return building;
            }
        }
        return null; // Building not found
    }
}

// Building class
class Building {
    private String streetName;
    private String houseNumber;
    private double basicMonthlyPayment;
    private ArrayList<Room> rooms;

    public Building(String streetName, String houseNumber, double basicMonthlyPayment) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.basicMonthlyPayment = basicMonthlyPayment;
        this.rooms = new ArrayList<>();
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public double getBasicMonthlyPayment() {
        return basicMonthlyPayment;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (Room room : rooms) {
            totalArea += room.getArea();
        }
        return totalArea;
    }
}

// Room class
class Room {
    private int number;
    private double area;
    private Building building;

    public Room(int number, double area, Building building) {
        this.number = number;
        this.area = area;
        this.building = building;
    }

    public int getNumber() {
        return number;
    }

    public double getArea() {
        return area;
    }

    public Building getBuilding() {
        return building;
    }
}

public class Main {
    public static void main(String[] args) {
        City city = new City("Metropolis");
        Building building1 = new Building("Main St", "888", 10.0);
        Building building2 = new Building("Ross", "092", 8.0);

        Room room1 = new Room(98, 20.0, building1);
        Room room2 = new Room(67, 15.0, building1);
        Room room3 = new Room(74, 18.0, building2);
        city.addBuilding(building1);
        city.addBuilding(building2);
        City astanaCity = new City("Astana");
        Building astanaBuilding = new Building("Kabanbay batyr", "50", 12.0);
        Room astanaRoom = new Room(57, 25.0, astanaBuilding);
        astanaCity.addBuilding(astanaBuilding);

        building1.addRoom(room1);
        building1.addRoom(room2);
        building2.addRoom(room3);
        System.out.println("Building Information:");
        System.out.println("Street: " + building1.getStreetName());
        System.out.println("House Number: " + building1.getHouseNumber());
        System.out.println("Basic Monthly Payment: " + building1.getBasicMonthlyPayment());
        System.out.println("Total Area: " + building1.getTotalArea());

        System.out.println("\nRooms in Building 1:");
        for (Room room : building1.getRooms()) {
            System.out.println("Room Number: " + room.getNumber() + ", Area: " + room.getArea());
        }

        String searchStreet = "Kabanbay batyr";
        String searchHouseNumber = "50";
        Building foundBuilding = city.findBuilding(searchStreet, searchHouseNumber);

        if (foundBuilding != null) {
            System.out.println("\nBuilding Found:");
            System.out.println("Street: " + foundBuilding.getStreetName());
            System.out.println("House Number: " + foundBuilding.getHouseNumber());
            System.out.println("Basic Monthly Payment: " + foundBuilding.getBasicMonthlyPayment());
            System.out.println("Total Area: " + foundBuilding.getTotalArea());
        } else {
            System.out.println("\nBuilding not in Astana.");
        }
    }
}
