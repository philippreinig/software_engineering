package assignments.sheet_2;

/**
 * Represents a car in OttoPark
 */
public class Car {
    public String licensePlateID;
    public float weight;
    public float value;

    public Car(String licensePlateID, float weight, float value)
    {
        this.licensePlateID = licensePlateID;
        this.weight = weight;
        this.value = value;
    }
}
