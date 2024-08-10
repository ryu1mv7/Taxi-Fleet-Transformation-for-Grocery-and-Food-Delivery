import java.util.ArrayList;

public class TaxiClassDriver {
    public static void main(String[] args) {

        System.out.println( "Instantiation of subclasses object:\n");


        //・Instantiate subclass instances for TaxiMart and TaxiFood
        TaxiMart tm = new TaxiMart(Taxi.VehicleType.Sedan, "BAH932",4,
                true, 471, 300.0);
        TaxiFood tf = new TaxiFood(Taxi.VehicleType.Suv, "WWW345", 4,
                true, "Fried Rice", new ArrayList<>(), 0); // initial cost must be 0

        //・Invoke appropriate methods to add respective items to their own arraylist.
        tm.addGroceriesItem("Vegetables",20.0);
        tm.addGroceriesItem("Meat",23.2);
        tf.addFoodOrder("Burger", 15.0);
        tf.addFoodOrder("Noodle", 12.0);

        //・Print the information of the subclass instances respectively.
        System.out.println(tm +"\n");
        System.out.println(tf);
        System.out.println();

        System.out.println( "Taxi delivery processed polymorphically:\n" );


        //・Instantiate an array of class instances to demonstrate polymorphism (Rule 1 and Rule 3).
        Delivery[] deliveryObjs = new Delivery[2];
        deliveryObjs[0] = tm;
        deliveryObjs[1] = tf;

        //・Print the information by invoke the sendDelivery() method to demonstrate it has been processed polymorphically.
        for (Delivery deliveryObj: deliveryObjs){
            System.out.println(deliveryObj.sendDelivery());
            System.out.println(); // make a space

        }
    }
}
