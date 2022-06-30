package assignments.sheet_2;

import java.util.ArrayList;

public class Example {

	static ArrayList<Car> cars = new ArrayList<Car>();

	static {
		// --Add example cars
		cars.add(new Car( "MD-AS-035", 524, 984));
		cars.add(new Car( "MD-DE-8957", 524, 234));
		cars.add(new Car( "MD-VF-4578", 524, 7325));
		cars.add(new Car("MD-KP-360", 2134, 524));
		cars.add(new Car("MD-AS-5785", 6732, 6327345));
		cars.add(new Car( "MD-RH-0674", 84234, 2452));
		cars.add(new Car( "MD-VG-7485", 634, 624));
		cars.add(new Car( "MD-JH-3957", 1262, 6234));
		cars.add(new Car( "MD-AD-0024", 6, 624));
		cars.add(new Car( "MD-JB-0007", 1262, 753));
		cars.add(new Car( "MD-VI-03", 1252, 632));
		cars.add(new Car( "MD-CS-027", 151, 95621));
		cars.add(new Car( "MD-AB-827", 6623, 6326));
		cars.add(new Car( "MD-AW-0024", 6325, 742563));
		cars.add(new Car( "MD-AW-0027", 7353, 65));
	}

	public static void scenario1() {
		OttoGarage ottoGarage = new OttoGarage();

		System.out.println("Deposit cars");
		Ticket tickets[] = new Ticket[cars.size()];
		for (int i = 0; i < 11; i++) {
			tickets[i] = ottoGarage.depositCar(cars.get(i));
		}
		ottoGarage.printTickets();

		ConfigurablePriorityComparator comparator = new ConfigurablePriorityComparator();
		comparator.setComparisonPriority(new ConfigurablePriorityComparator.ATTRIBUTE[] { ConfigurablePriorityComparator.ATTRIBUTE.WEIGHT,  ConfigurablePriorityComparator.ATTRIBUTE.PLATE, ConfigurablePriorityComparator.ATTRIBUTE.VALUE });
		// comparator.setComparisonPriority(new ConfigurablePriorityComparator.ATTRIBUTE[] { ConfigurablePriorityComparator.ATTRIBUTE.WEIGHT,  ConfigurablePriorityComparator.ATTRIBUTE.VALUE, ConfigurablePriorityComparator.ATTRIBUTE.PLATE });
		// comparator.setComparisonPriority(new ConfigurablePriorityComparator.ATTRIBUTE[] { ConfigurablePriorityComparator.ATTRIBUTE.PLATE,  ConfigurablePriorityComparator.ATTRIBUTE.VALUE, ConfigurablePriorityComparator.ATTRIBUTE.WEIGHT });

		GarageAllocationAnalyzer analyzer = new GarageAllocationAnalyzer(comparator, ottoGarage);

		analyzer.outputConsole();
	}

	public static void main(String[] args) {
		scenario1();
	}
}
