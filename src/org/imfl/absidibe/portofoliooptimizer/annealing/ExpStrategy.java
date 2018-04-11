package org.imfl.absidibe.portofoliooptimizer.annealing;

/**
 * Created by absidibe on 11/04/2018.
 */
public class ExpStrategy extends SimulatedStrategy {


    private double factor;

    public ExpStrategy(double temperature, double minTemperature, double factor) {
        super(temperature, minTemperature);
        this.factor = factor;
    }

    @Override
    public double getNext() {
        this.temperature = temperature* Math.pow(0.95,factor);
        return temperature;
    }

}
