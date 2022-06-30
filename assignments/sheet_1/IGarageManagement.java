package assignments.sheet_1;

/**
 * IGarageManagement provides interface for the parking space allocation in automated car parks.
 *
 */
public interface IGarageManagement {

    /**
     * Method for depositing cars at the garage
     * @param licensePlateID the licensePlateID of the car
     * @return Ticket with information where the car was deposited
     */
    public Ticket depositCar(String licensePlateID);

    /** 
     * Method for retrieving the car from the garage
     * @param ticket with information on car to retrieve
     */
    public boolean pickupCar(Ticket ticket);

    /**
     * Dump tickets for currently allocated parking spaces to commandline
     */
    public void printTickets();
}
