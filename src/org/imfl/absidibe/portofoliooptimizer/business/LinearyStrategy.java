package org.imfl.absidibe.portofoliooptimizer.business;


public class LinearyStrategy extends TemperatureDecroissanceStrategy {

    private int factor;

    public LinearyStrategy(int temperature, int minTemperature, int factor) {
        super(temperature, minTemperature);
        this.factor = factor;
    }

    @Override
    public double getNext() {
        return getCurrentTemperature() * factor;
    }


}
