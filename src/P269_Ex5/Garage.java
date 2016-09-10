package P269_Ex5;

/**
 * ---------------------------------------
 * Created by Theo Dimopoulos on 9/10/16.|
 * Email: dimopoulosth.td@gmail.com     |
 * ---------------------------------------
 */
public class Garage {


    private Object[] objects;// Collection of objects
    private int numOfVehicles;//Array numOfVehicles

    public Garage(int numOfGarageSlots) {
        objects = new Object[numOfGarageSlots];
    }
    //Add object to array
    public void addObject(Object object){

        objects[numOfVehicles]=object;
        numOfVehicles++;

    }
    //Delete object from array
    public boolean deleteObject(int index){

        //Integrity and array length check
        if(index>=0 && index<this.numOfVehicles) {
            //Overwrite items by shifting
            for (int i = index; i < this.numOfVehicles - 1; i++)
                objects[i] = objects[i + 1];

            numOfVehicles--;
            return true;
        }else
            return false;//indicate object not deleted
    }
    //Return an element of the collection
    public Object searchObject(int index){
        return objects[index];
    }

    public int getNumOfVehicles() {
        return numOfVehicles;
    }
}