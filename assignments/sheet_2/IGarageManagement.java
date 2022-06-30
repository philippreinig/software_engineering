package assignments.sheet_2;

import java.util.ArrayList;

/**
 * IGarageManagement provides interface for the parking space allocation in automated car parks.
 *
 */
public interface IGarageManagement {

    /**
     * Method for depositing cars at the garage
     * @param car the car
     * @return Ticket with information where the car was deposited
     */
    public Ticket depositCar(Car car);

    /** 
     * Method for retrieving the car from the garage
     * @param ticket with information on car to retrieve
     */
    public boolean pickupCar(Ticket ticket);

    /**
     * Dump tickets for currently allocated parking spaces to commandline
     */
    public void printTickets();

    /**
     * Method for retrieving all cars from the garage
     * @return
     */
    public ArrayList<Car> getAllCars();
}
