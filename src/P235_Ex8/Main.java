package P235_Ex8;

/**
 * ---------------------------------------
 * Created by Theo Dimopoulos on 9/9/16.|
 * Email: dimopoulosth.td@gmail.com     |
 * ---------------------------------------
 *
 * Ex.8 p235
 *
 */
public class Main {

    private static final int DAYS=5; //Days per week that booking is available
    private static final int PERIODS=7;//Periods in a day that booking is available
    public static void main(String argsp[]){

        //Create timetable
        TimeTable timeTable= new TimeTable(PERIODS,DAYS);

        //Successful booking
        Booking booking1=new Booking("Classroom A","Theo Dimopoulos");
        addBookingToTimeTable(timeTable,booking1,0,0);

        //Unsuccessful booking because slot is not available
        Booking booking2=new Booking("Classroom A","George Collins");
        addBookingToTimeTable(timeTable,booking2,0,0);

        //Unsuccessful because slot doesn't exist
        Booking booking3=new Booking("Classroom B","Paul George");
        addBookingToTimeTable(timeTable,booking3,3,6);

        //Another Successful booking
        Booking booking4=new Booking("Classroom C","Peter Jennings");
        addBookingToTimeTable(timeTable,booking4,6,4);

        //Print TimeTable
        printTimeTable(timeTable);

        //Cancel Booking
        cancelBookingToTimeTable(timeTable,6,4);

        //Print TimeTable to check cancellation
        printTimeTable(timeTable);

    }

    //Add booking to timetable
    private static boolean addBookingToTimeTable(TimeTable timeTable, Booking booking1, int period, int day) {
        if(timeTable.makeBooking(period,day,booking1)){
            printSuccessMessage();
            printBookingDetails(period,day,booking1);
            return true;
        }
        else {
            System.out.println("BOOKING FAILED\n");
            return false;
        }

    }
    //Cancel booking
    private static boolean cancelBookingToTimeTable(TimeTable timeTable, int period, int day) {

        //If booking exist , get its information.
        Booking cancelledBooking=null;
        if(!timeTable.isFree(period,day))
            cancelledBooking=timeTable.getBooking(period,day);

        //Cancel the booking
        if(timeTable.cancelBooking(period,day)){
            printCancellationMessage();
            printBookingDetails(period,day,cancelledBooking);
            return true;
        }
        else {
            System.out.println("BOOKING FAILED\n");
            return false;
        }
    }
    //Print booking details
    private static void printBookingDetails(int period,int day,Booking booking){

        System.out.println("DAY: "+day);
        System.out.println("PERIOD: "+period);
        System.out.println("ROOM: "+booking.getRoom());
        System.out.println("NAME: "+booking.getName());
        System.out.println();
    }
    //Print Timetable
    private static void printTimeTable(TimeTable timeTable){

        System.out.println("TIMETABLE");
        System.out.println("------------------");

        for(int i=0;i<timeTable.getNumberOfPeriods();i++)
            for(int j=0;j<timeTable.getNumberOfDays();j++)
                if(!timeTable.isFree(i,j))
                    printBookingDetails(i,j,timeTable.getBooking(i,j));
    }
    //Print a message to indicate the success
    private static void printSuccessMessage() {
        System.out.println("BOOKING SUCCESSFUL");
        System.out.println("------------------");
    }
    //Print a message to indicate the cancellation
    private static void printCancellationMessage() {
        System.out.println("BOOKING CANCELLED");
        System.out.println("------------------");
    }

}
