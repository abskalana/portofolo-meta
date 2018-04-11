package org.imfl.absidibe.portofoliooptimizer.annealing;


public class LinearyStrategy extends SimulatedStrategy {

    private double factor;

    public LinearyStrategy(double temperature, double minTemperature, double factor) {
        super(temperature, minTemperature);
        this.factor = factor;
    }

    @Override
    public double getNext() {
        this.temperature = temperature*factor;
        return temperature;
    }


}
