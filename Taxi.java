public abstract class Taxi implements Delivery {

    // instances variables 
    public enum VehicleType {Sedan, Suv, Van}

    private VehicleType vehicle;
    private String regoNumber;
    private int passengerCapacity;
    private boolean status;

    // constructor 
    public Taxi(VehicleType initVehicle, String initRegoNumber, int initPassengerCapacity, boolean initStatus){
        setVehicle(initVehicle);
        setRegoNumber(initRegoNumber);
        setPassengerCapacity(initPassengerCapacity);
        setStatus(initStatus);
    }
    // getter | accessor 

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public String getRegoNumber() {
        return regoNumber;
    }

    public boolean getStatus() {
        return status;
    }

    public VehicleType getVehicle(){
        return vehicle;
    }

    // setter | mutator
    public boolean setPassengerCapacity(int newPassengerCapacity){
        boolean retVal = false;
        boolean sedanRequirement = (getVehicle().equals(VehicleType.Sedan)  &&  newPassengerCapacity<= 4);
        boolean suvRequirement = (getVehicle().equals(VehicleType.Suv) &&  newPassengerCapacity<= 6);
        boolean vanRequirement = (getVehicle().equals(VehicleType.Van)  &&  newPassengerCapacity<= 8);

        if  (sedanRequirement || suvRequirement || vanRequirement)
        {
            retVal = true;
            passengerCapacity = newPassengerCapacity;
        }
        return retVal;
    }

    public boolean setRegoNumber(String newRegoNumber) {
        boolean retVal = false;

        if(newRegoNumber.length() == 6)
        {
            retVal = true;
            regoNumber = newRegoNumber;
        }
        else
        {
            retVal = false;
        }
        return retVal;
    }

    public boolean setStatus(boolean newStatus) {
        boolean retVal = false;
        if ((newStatus == false) || (newStatus == true))
        {
            retVal = true;
            status = newStatus;
        }
        return retVal;
    }

    public boolean setVehicle(VehicleType newVehicle) {
        boolean isSuccess = false;
        switch (newVehicle){
            case Sedan:
                vehicle = newVehicle;
                setPassengerCapacity(4);
                isSuccess = true;
                break;
            case Suv:
                vehicle = newVehicle;
                setPassengerCapacity(6);
                isSuccess = true;
                break;
            case Van:
                vehicle = newVehicle;
                setPassengerCapacity(8);
                isSuccess = true;
                break;
            default:
                System.out.println("Make sure input vehicle is valid");
                isSuccess = false;
        }
        return isSuccess;
    }

    // other method 
    @Override
    public String toString(){
        String ret = "";
        ret+= "Vehicle: " + getVehicle() + "\n";
        ret+= "Registration Number: " + getRegoNumber() + "\n";
        ret+= "Passenger Capacity: " + getPassengerCapacity()+ "\n";
        ret+= "Availability Status: " + getStatus();
        return ret;
    }
    
    public abstract String sendDelivery();
}



