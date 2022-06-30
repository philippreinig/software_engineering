package assignments.sheet_3;

import java.util.Comparator;

public class GarageAllocationAnalyzer {
    private Comparator<Car> comparator;
    private IGarageManagement garage;

    public GarageAllocationAnalyzer(Comparator<Car> comparator, IGarageManagement garage){
        this.comparator = comparator;
        this.garage = garage;
    }

    public void outputConsole(){
        
    }
}
