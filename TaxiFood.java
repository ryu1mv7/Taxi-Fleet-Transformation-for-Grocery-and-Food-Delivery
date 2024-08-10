import java.util.ArrayList;

public class TaxiFood extends Taxi {

    // instances variables 
    private String foodName;
    private ArrayList<String> foodList;
    private double totalCost;

    // constructor 
    public TaxiFood(VehicleType initVehicle, String initRegoNumber, int initPassengerCapacity,
                    boolean initStatus, String initFoodName, ArrayList<String> initFoodList, double initTotalCost) {
        super(initVehicle, initRegoNumber, initPassengerCapacity, initStatus); // invoke Taxi class constructor
        setFoodName(initFoodName);
        setTotalCost(initTotalCost); // should be 0
        foodList = initFoodList;
    }
    // getter | accessor 

    public String getFoodName() {
        return foodName;
    }

    public ArrayList<String> getFoodList() {
        return foodList;
    }

    public double getTotalCost() {
        return totalCost;
    }

    // setter | mutator 
    public boolean setFoodName(String newFoodName) {
        boolean retVal = false;
        if (newFoodName != null) {
            foodName = newFoodName;
            retVal = true;
        }
        return retVal;
    }

    public boolean setTotalCost(double newTotalCost) {
        boolean retVal = false;
        if (newTotalCost >= 0) {
            totalCost = newTotalCost;
            retVal = true;
        }
        return retVal;
    }

    // other method 

    public void addFoodOrder(String foodName, double foodCost) {
        if (foodName != null && foodList.size() < 30) {
            foodList.add(foodName);
            totalCost += foodCost;
        }
    }

    @Override
    public String sendDelivery() { // used to be deliverFood() // used to be return ->sout
        totalCost = getTotalCost() * 1.2;
        String ret = "";
        ret += "Delivered: " + getFoodList() +  "\n"; // list out all
        ret += "Delivery completed! and total cost is: $" + totalCost;
        return ret;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += super.toString() + "\n";
        ret += "\n"; // make a space
        ret += "Food Name: " + getFoodName() +  "\n";
        ret += "Food List: " + getFoodList() +  "\n";
        ret += "Total Cost: $" + getTotalCost();
        return ret;
    }
}

