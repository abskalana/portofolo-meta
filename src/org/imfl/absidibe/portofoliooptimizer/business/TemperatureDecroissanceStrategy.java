package org.imfl.absidibe.portofoliooptimizer.business;


public abstract class TemperatureDecroissanceStrategy {

    protected int temperature;
    protected int minTemperature;


    public TemperatureDecroissanceStrategy(int temperature, int minTemperature) {
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
