import java.util.ArrayList;

public class OttoGarage implements IGarageManagement{
    private int levels;
    private int positionsPerLevel;
    private Ticket[] slots;

    public OttoGarage(){}

    public Ticket depositCar(Car car){
        return null;
    }

    public boolean pickupCar(Ticket ticket){
        return false;
    }

    public ArrayList<Car> getAllCars(){
        return null;
    }

    public void printTickets(){

    }

    public int getNextFreeSlot(){
        return 0;
    }
}
