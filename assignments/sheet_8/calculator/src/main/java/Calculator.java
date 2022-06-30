public class Calculator{
    private final IAdder adder;
    private final IMultiplier multiplier;

    public Calculator(){
        this.adder = new AdderImpl();
        this.multiplier = new MultiplierImpl();
    }

    public double add(double a, double b){
        return this.adder.add(a,b);
    }

    public double substract(double a, double b){
        return this.adder.substract(a, b);
    }

    public double multiply(double a, double b){
        return this.multiplier.multiply(a, b);
    }

    public double divide(double a, double b){
        return this.multiplier.divide(a, b);
    }

    public static void main(String[] args){
        int x = 5;
        int y = 7;
        int z = -3;

        Calculator c = new Calculator();

        System.out.println(c.multiply(c.substract(c.add(x,y), z), x));
    }
}