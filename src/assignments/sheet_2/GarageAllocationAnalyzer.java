package assignments.sheet_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.stream.Stream;


/**
 * Compares cars by weight 
 */
class ComparatorWeight implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return Float.compare(o1.weight, o2.weight);
    }
}

/**
 * Compares cars by value 
 */
class ComparatorValue implements Comparator<Car> {
	@Override
    public int compare(Car o1, Car o2){
        return Float.compare(o1.value, o2. value);
    }
}

/**
 * Compares cars by license plate 
 */
class ComparatorPlate implements Comparator<Car> {
	@Override
    public int compare(Car o1, Car o2){
        return o1.licensePlateID.compareTo(o2.licensePlateID);
    }
}

/**
 * Compares cars based on multiple attributes (value, weight, plate) in the defined priority,
 * e.g. if two cars are equal according to the first attribute, then the second attribute decides,
 * if two cars are equal according to the second attribute, then the third attribute decides and so on
 *
 */
class ConfigurablePriorityComparator implements Comparator<Car> {
    enum ATTRIBUTE {PLATE, WEIGHT, VALUE}

    private ArrayList<Comparator<Car>> comparators = new ArrayList<>();

    /**
     * Perform comparison based on last priorities defined by setComparisonPriority.
     */
    @Override
    public int compare(Car o1, Car o2) {
    	for(Comparator c : this.comparators){
            int comparison = c.compare(o1, o2);
            if (comparison != 0) return comparison;
        }
        return 0;
    }

    /**
     * Set priorities for comparison
     */
    public void setComparisonPriority(ATTRIBUTE[] comparisonPriority) {


        this.comparators = new ArrayList<>(Stream.of(comparisonPriority).map(x -> generateComparator(x)).toList());
    }

    private static Comparator<Car> generateComparator(ATTRIBUTE a){
        switch(a){
            case PLATE: return new ComparatorPlate();
            case WEIGHT: return new ComparatorWeight();
            case VALUE: return new ComparatorValue();
            default:
                throw new IllegalArgumentException("This attribute is invalid");
        }
    }
}

/**
 * GarageAllocationAnalyzer allows operators to analyze the current allocations of parking spaces automated car parks.
 * The order in which parking space allocations are presented can be configured by providing a suitable comparator.
 *
 */
public class GarageAllocationAnalyzer {

    private Comparator<Car> comparator = null;
    private IGarageManagement garage = null;

    /**
     * Create new GarageAllocationAnalyzer
     * @param comparator used when sorting cars for output
     * @param garage garage to analyze
     */
    public GarageAllocationAnalyzer(Comparator<Car> comparator, IGarageManagement garage) {
        this.comparator = comparator;
        this.garage = garage;
    }

    /**
     * Outputs cars to console in the order specified by the configured comparator
     */
    public void outputConsole() {
        ArrayList<Car> cars = garage.getAllCars();

        cars.sort(comparator);

        for (Car car : cars) {
            System.out.println(car.licensePlateID + ", " + car.weight + ", " + car.value);
        }
    }
}
