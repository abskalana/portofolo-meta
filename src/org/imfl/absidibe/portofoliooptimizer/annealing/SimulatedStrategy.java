package org.imfl.absidibe.portofoliooptimizer.annealing;


public abstract class SimulatedStrategy {

    protected double temperature;
    protected double minTemperature;


    public SimulatedStrategy(double temperature, double minTemperature) {
        this.temperature = temperature;
        this.minTemperature = minTemperature;
    }

    public boolean shouldContinue() {
        return this.temperature > minTemperature;
    }

    public abstract double getNext();


    public double getCurrentTemperature() {
        return temperature;
    }

}
