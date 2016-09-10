package P269_Ex5;

/**
 * ---------------------------------------
 * Created by Theo Dimopoulos on 9/10/16.|
 * Email: dimopoulosth.td@gmail.com     |
 * ---------------------------------------
 */
public class Vehicle {
    private String regNo;//vehicle registration number
    private Double make; // no Idea....
    private int yearOfManufacture;
    private double value;//current value/price of vehicle

    public Vehicle(String regNo,/*String*/ double make,int yearOfManufacture,double value){
        this.regNo=regNo;
        this.make=make;
        this.yearOfManufacture =yearOfManufacture;
        this.value=value;
    }

    public String getRegNo(){
        return regNo;
    }

    public Double getMake(){
        return make;
    }

    public int getYearOfManufacture(){
        return yearOfManufacture;
    }

    public double getValue(){
        return value;
    }

    public void setValue(double value){
        if(value>0.0)//check value
            this.value=value;
    }

    public int calculateAge(int currentYear){
        if(currentYear>=2016)
            return currentYear- yearOfManufacture;
        else
            return -1;//indicate invalid value

    }
}
