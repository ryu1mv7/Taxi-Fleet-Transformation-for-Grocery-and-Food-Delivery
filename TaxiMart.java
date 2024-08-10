import java.util.ArrayList;

public class TaxiMart extends Taxi{ // suclass of Taxi

    // instances variables 
    private int bootSpace;
    private double grocerySize;
    private ArrayList<String> groceryList;
    private double totalCost; // double or float?

    // constructor 

    public TaxiMart(VehicleType initVehicle, String initRegoNumber, int initPassengerCapacity,
                    boolean initStatus,int initBootSpace, double initGrocerySize){
        super(initVehicle,initRegoNumber,initPassengerCapacity,initStatus);

        setBootSpace(initBootSpace);
        setGrocerySize(initGrocerySize);
        //Default:
        groceryList = new ArrayList<>(); // initialise ArrayList
        totalCost = 0; // Absolutely must be initialed as 0 for calculating total cost
    }
    // getter | accessor 
    public int getBootSpace() {
        return bootSpace;
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public double getGrocerySize() {
        return grocerySize;
    }

    public double getTotalCost() {
        return totalCost;
    }

    // setter | mutator 
    public boolean setBootSpace(int NewBootSpace){
        boolean retVal = false;
        if (0<= NewBootSpace){ // negative num cannot be accepted
            bootSpace = NewBootSpace;
            retVal = true;
        }
        return retVal;
    }
    public boolean setGrocerySize(double NewGrocerySize) {
        boolean retVal = false;
        if (0.0 <= NewGrocerySize){ // negative num cannot be accepted
            grocerySize = NewGrocerySize;
            retVal = true;
        }
        return retVal;
    }

    // other method 

    public void addGroceriesItem(String itemName, double itemCost){
        if (itemName != null && groceryList.size() < 30){
            groceryList.add(itemName);
            totalCost+= itemCost;
        }
    }

    @Override
    public String sendDelivery(){ // used to be deliverGroceries() // used to be return ->sout
        totalCost = getTotalCost() * 1.1;
        String ret = "";
        ret += "Delivered: " + getGroceryList()+ "\n";
        ret += "Delivery completed! and total cost is: $"+ totalCost;
        return ret;
    }

    @Override
    public String toString(){
        String ret = "";
        ret += super.toString()+ "\n";
        ret+= "\n"; // make a space
        ret += "BootSpace: " + getBootSpace() + " litre"+ "\n";
        ret += "Grocery Size: " + getGrocerySize()+ " litre"+ "\n";
        ret += "Grocery List: " +getGroceryList()+ "\n";
        ret += "Total Cost: $" + getTotalCost();
        return ret;
    }
}
