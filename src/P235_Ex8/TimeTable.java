package P235_Ex8;

import com.sun.org.glassfish.gmbal.ParameterNames;

/**
 * ---------------------------------------
 * Created by Theo Dimopoulos on 9/9/16.|
 * Email: dimopoulosth.td@gmail.com" )   |
 * ---------------------------------------
 */
public
class TimeTable {

    private Booking[][] times;

    /*Constructor.
     *Accepts the days of the week and the periods that the booking is available
     *to allocate the memory of the array
     */
    public TimeTable(int periods,int days){
        if(days>0 && periods>0)
            times= new Booking[periods][days];
    }


    //Add a booking to the timetable.
    //Returns true if booking is successful, false otherwise.
    public boolean makeBooking(int period,int day,Booking booking){


        if (day<getNumberOfDays() && day>=0 && period<getNumberOfPeriods() && period>=0) //Integrity Constraint
        {
            if (isFree(period, day)) {
                times[period][day] = booking;
                return true;
            } else
                return false;
        }
        //Parameters Out Of Bounds
        else
            return false;
    }

    //Cancel a booking in the timetable
    //Returns true if the cancellation was successful
    public boolean cancelBooking(int period,int day){
        if (day<getNumberOfDays() && day>=0 && period<getNumberOfPeriods() && period>=0) //Integrity Constraint
        {
            if (!isFree(period, day)) {//Booking exist,cancel it and return true.
                times[period][day] = null;
                return true;
            } else    //Booking doesn't exist, return false.
                return false;
        }
        else //Parameters Out Of Bounds
            return false;

    }

    //Return true if slot is empty and false if it is already booked
    public boolean isFree(int period, int day) {
        if (day<getNumberOfDays() && day>=0 && period<getNumberOfPeriods() && period>=0) //Integrity Constraint
        {
            if (times[period][day] == null)
                return true;
            else
                return false;
        }

        else //Parameters Out Of Bounds
            return false;

    }

    public Booking getBooking(int period,int day){

        if (day<getNumberOfDays() && day>=0 && period<getNumberOfPeriods() && period>=0) //Integrity Constraint
        {
            if (!isFree(period, day))
                return times[period][day];
            else //empty slot
                return null;
        }
        else //Parameters Out Of Bounds
            return null;
    }

    public int getNumberOfPeriods(){
        return times.length;//Periods are equal with the number of the rows
    }
    public int getNumberOfDays(){
        return times[0].length;//Days are equal with the number of the columns
    }

}
