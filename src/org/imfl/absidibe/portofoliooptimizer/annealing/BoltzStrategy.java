package org.imfl.absidibe.portofoliooptimizer.annealing;


public class BoltzStrategy extends SimulatedStrategy {

    private double factor;

    public BoltzStrategy(double temperature, double minTemperature, double factor) {
        super(temperature, minTemperature);
        this.factor = factor;
    }

    @Override
    public double getNext() {
        this.temperature = temperature* Math.log(factor);
        return temperature;
    }


}
