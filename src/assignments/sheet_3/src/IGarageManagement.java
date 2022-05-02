import java.util.ArrayList;

public interface IGarageManagement {
    public Ticket depositCar(Car car);

    public boolean pickupCar(Ticket ticket);

    public void printTickets();

    public ArrayList<Car> getAllCars();
}
