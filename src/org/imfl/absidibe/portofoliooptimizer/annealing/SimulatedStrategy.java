package org.imfl.absidibe.portofoliooptimizer.annealing;


public abstract class SimulatedStrategy {

    protected double temperature;
    protected double minTemperature;
    protected int interationMax = 10000;
    private int iteration;


    public SimulatedStrategy(double temperature, double minTemperature) {
        this.temperature = temperature;
        this.minTemperature = minTemperature;
    }

    public boolean shouldContinue() {
        boolean shouldContinue = this.temperature > minTemperature && iteration < interationMax;
        iteration++;
        return shouldContinue;
    }

    public abstract double getNext();


    public double getCurrentTemperature() {
        return temperature;
    }

}
