package P269_Ex5;



import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ---------------------------------------
 * Created by Theo Dimopoulos on 9/10/16.|
 * Email: dimopoulosth.td@gmail.com     |
 * ---------------------------------------
 */
public class Main {

    public static final int SLOTS=100;

    public static void main(String args[]){


        Scanner myScanner=new Scanner(System.in);//Get user input
        Garage garage =new Garage(SLOTS);//Collection of vehicle objects

        int choice;// user option

        //Main Menu
        do{

            printMenu();//Show menu

            try {
                choice = myScanner.nextInt();//Scan choice
            }catch (InputMismatchException e){
                if(myScanner.hasNext())//Flush the scanner to avoid an endless loop
                    myScanner.next();
                choice=-1;//Indicate invalid choide
            }

            switch (choice){
                case 1:
                    optionAddVehicle(garage);
                    break;
                case 2:
                    optionPrintVehicle(garage);
                    break;
                case 3:
                    optionDeleteVehicle(garage);
                    break;
                case 4://Do nothing...
                    break;
                default:
                    System.out.println("Please type a valid option.[1-4]");

            }
        }while (choice !=4);
    }

    //Option 1. Add Vehicle
    private static void optionAddVehicle(Garage garage) {

        System.out.println("Option 1. Add Vehicle\n");
        Object object = createVehicleFromInput();

        if(object != null) {
            garage.addObject(object);
            System.out.println("Vehicle added successfully");
        }

    }
    //Option 2. Print Vehicle details
    private static void optionPrintVehicle(Garage garage) {

        Scanner keyboard=new Scanner(System.in);

        System.out.println("Give index:");
        int index = keyboard.nextInt();

        if (index>0 && index<=garage.getNumOfVehicles())
            printVehicleDetails(garage.searchObject(index-1));
        else
            System.out.println("No vehicle in this position");

    }
    //Option 3. Delete Vehicle
    private static void optionDeleteVehicle(Garage garage){
        Scanner keyboard=new Scanner(System.in);

        System.out.println("Give vehicle index:");
        int index = keyboard.nextInt();

        if(garage.deleteObject(index-1))
            System.out.println("Vehicle deleted.");
        else
            System.out.println("Vehicle not found.");
    }

    /*------------------------Auxiliary Methods-----------------------------------*/

    //Print Vehicle details
    private static void printVehicleDetails(Object object) {
        Vehicle vehicle;

        if(object instanceof Vehicle){
            vehicle=(Vehicle) object;
            System.out.println("Vehicle Details:\n");
            System.out.println("Registration Number:"+vehicle.getRegNo());
            System.out.println("Make:"+vehicle.getMake());
            System.out.println("Year of manufacture:"+vehicle.getYearOfManufacture());
            System.out.println("Value:"+vehicle.getValue());

            if(vehicle instanceof SecondHandVehicle)
                System.out.println("Number of previous owners:"+((SecondHandVehicle) vehicle).getNumberOfOwners());

        }
    }
    //Builder method for Vehicle
    private static Object createVehicleFromInput() {
        Scanner keyboard = new Scanner(System.in);
        Object object;

        try {

            System.out.println("Registration number:");
            String regNo = keyboard.nextLine();

            System.out.println("Make:");
            double make = keyboard.nextDouble();

            System.out.println("Year of manufacture:");
            int yearOfManufacture = keyboard.nextInt();
            //Check year integrity
            if( yearOfManufacture<1900)
                throw new InputMismatchException();

            System.out.println("Value:");
            double value = keyboard.nextDouble();
            //Check value integrity
            if( value<0.0)
                throw new InputMismatchException();

            System.out.println("Is a second hand Car? (Y/N)");
            char c = keyboard.next(".").charAt(0);

            //Check Vehicle category
            if (Character.toLowerCase(c) == 'y') {
                System.out.println("Number of previous owners:");

                object = new SecondHandVehicle(regNo, make, yearOfManufacture, value, keyboard.nextInt());
            } else
                object = new Vehicle(regNo, make, yearOfManufacture, value);

            return object;

        }catch (IllegalArgumentException|InputMismatchException e){
            System.out.println("Invalid values. You will navigate back to menu");
            return null;//indicate invalid input
        }
        finally {
            //Do nothing more...
        }
    }
    //Auxiliary method for printing to screen
    private static void printMenu() {
        System.out.println("----------MENU----------\n");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Display a list of vehicle details");
        System.out.println("3. Delete a vehicle");
        System.out.println("4. Quit");
    }
}
