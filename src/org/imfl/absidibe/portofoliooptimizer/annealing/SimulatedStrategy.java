package org.imfl.absidibe.portofoliooptimizer.annealing;


public abstract class SimulatedStrategy {

    protected double temperature;
    protected double minTemperature;
    protected int interationMax = 100000;
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

    public int getIteration() {
        return iteration;
    }

    public double getCurrentTemperature() {
        return temperature;
    }

}
