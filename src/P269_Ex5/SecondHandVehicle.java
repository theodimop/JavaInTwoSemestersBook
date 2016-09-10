package P269_Ex5;

/**
 * ---------------------------------------
 * Created by Theo Dimopoulos on 9/10/16.|
 * Email: dimopoulosth.td@gmail.com     |
 * ---------------------------------------
 */
public class SecondHandVehicle  extends Vehicle {

    private int numberOfOwners;

    public SecondHandVehicle(String regNo, double make, int yearOfManufacture, double value,int numberOfOwners) {
        super(regNo, make, yearOfManufacture, value);

        this.numberOfOwners=numberOfOwners;
    }

    public int getNumberOfOwners(){
        return numberOfOwners;
    }
    public boolean hasMultipleOwners(){
        if(numberOfOwners>1)
            return true;
        else
            return false;
    }


}

