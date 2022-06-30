public class MultiplierImpl implements IMultiplier{

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero exception.");
        return a / b;
    }

    
}
