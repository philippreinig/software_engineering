package assignments;

import java.util.Random;

public class GarageManagement implements IGarageManagement{

    private static final Random rand = new Random();
    private final int levels;
    private final int positionsPerLevel;

    private final Ticket[][] garage;


    public GarageManagement(int levels, int positionsPerLevel){
        this.garage = new Ticket[levels][positionsPerLevel];
        this.levels = levels;
        this.positionsPerLevel = positionsPerLevel;
    }

    /**
     * Method for depositing cars at the garage
     * @param licensePlateID the licensePlateID of the car
     * @return Ticket with information where the car was deposited
     */
    public Ticket depositCar(String licensePlateID){
        if (!this.emptySpotExists()){
            System.err.println("Can't deposit any more cars at the moment. Garage is occupied!");
            return null;
        }
        int level = rand.nextInt(levels);
        int position = rand.nextInt(positionsPerLevel);

        while(this.garage[level][position] != null){
            level = rand.nextInt(levels);
            position = rand.nextInt(positionsPerLevel);
        }

        Ticket newTicket = new Ticket(level, position, licensePlateID);

        this.garage[level][position] = newTicket;

        return newTicket;
    }

    /** 
     * Method for retrieving the car from the garage
     * @param ticket with information on car to retrieve
     */
    public boolean pickupCar(Ticket ticket){
        if (ticket == null) return false;
        for(int i = 0; i < levels; ++i){
            for(int j = 0; j < positionsPerLevel; ++j){
                if (garage[i][j] == ticket){
                    garage[i][j] = null;
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * Dump tickets for currently allocated parking spaces to commandline
     */
    public void printTickets(){
        int counter = 0;
        for(int i = 0; i < this.levels; ++i){
            for(int j = 0; j < this.positionsPerLevel; ++j){
                if (garage[i][j] != null){
                    System.out.println(garage[i][j]);
                    ++counter;
                }
            }
        }
        System.out.println("There are currently " + counter + "/" + levels*positionsPerLevel + " parking lots occupied");
    }

    /** 
     * Check if there is an empty spot in the garage.
     * That is the case if a null value exists in the {@link #garage} matrix.
     * */
    private boolean emptySpotExists(){
        for(int i = 0; i < levels; ++i){
            for(int j = 0; j < positionsPerLevel; ++j){
                if (this.garage[i][j] == null) return true;
            }
        }
        return false;
    }


    
}