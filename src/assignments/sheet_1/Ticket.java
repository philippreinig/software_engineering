package assignments;

/**
 * Ticket class holds information on parking space allocations
 */
public class Ticket {
	public final int level; // on which level the car is at
	public final int position; // which position on the level the car is at
	public final String licensePlateID;

	public Ticket(int level, int position, String licensePlateID){
		this.level = level;
		this.position = position;
		this.licensePlateID = licensePlateID;
	}

	@Override
	public String toString(){
		return "The car " + licensePlateID + " is located at " + level + "-" + position + ".";
	}
}

