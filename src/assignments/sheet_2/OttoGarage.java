package assignments.sheet_2;

import java.util.ArrayList;

public class OttoGarage implements IGarageManagement {

	private int levels = 3;
	private int positionsPerLevel = 5;
	private Ticket[] slots;

	public OttoGarage() {
		slots = new Ticket[positionsPerLevel * levels];
	}

	@Override
	public Ticket depositCar(Car car) {
		Ticket newTicket = null;

		int slot = getNextFreeSlot();
		if (slot >= 0 && slot < slots.length) {
			Ticket ticket = new Ticket();
			ticket.position = slot % positionsPerLevel;
			ticket.level = slot / positionsPerLevel;
			ticket.car = car;
			slots[slot] = ticket;

			newTicket = ticket;
		}

		return newTicket;
	}

	@Override
	public boolean pickupCar(Ticket ticket) {
		if (ticket != null) {
			int slot = ticket.position + ticket.level * positionsPerLevel;
			if (slot >= 0 && slot < slots.length) {
				Ticket tmp = slots[slot];
				if (tmp != null && tmp.car.licensePlateID.equals(ticket.car.licensePlateID)) {
					// Ensure only owner of a ticket with the correct licensePlateId can pick up car
					slots[slot] = null;
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public void printTickets() {
		for (int i = 0; i < slots.length; ++i) {
			Ticket ticket = slots[i];
			if (ticket != null)
				System.out.println("[" + ticket.level + "," + ticket.position + "] : " + ticket.car.licensePlateID);
			else
				System.out.println("[" + i / positionsPerLevel + "," + i % positionsPerLevel + "] : EMPTY");
		}
	}

	@Override
	public ArrayList<Car> getAllCars() {
		ArrayList<Car> cars = new ArrayList<>();
		for (int i = 0; i < slots.length; ++i)
		{
			if(slots[i] != null)
			{
				cars.add(slots[i].car);
			}
		}

		return cars;
	}

	private int getNextFreeSlot() {
		for (int i = 0; i < slots.length; ++i) {
			if (slots[i] == null)
				return i;
		}
		return -1;
	}
}
