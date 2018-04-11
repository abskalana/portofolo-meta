package org.imfl.absidibe.portofoliooptimizer.annealing;


public class FastStrategy extends SimulatedStrategy {

    private double factor;

    public FastStrategy(double temperature, double minTemperature, double factor) {
        super(temperature, minTemperature);
        this.factor = factor;
    }

    @Override
    public double getNext() {
        this.temperature = temperature /factor;
        return temperature;
    }

}
