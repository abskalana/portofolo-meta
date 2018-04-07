package org.imfl.absidibe.portofoliooptimizer.model;


public class Asset {

    private double esperance;
    private double std;
    private Type type;

    public Asset(double esperance, double std, Type type) {
        this.esperance = esperance;
        this.std = std;
        this.type = type;
    }

    public double getEsperance() {
        return esperance;
    }

    public double getStd() {
        return std;
    }

    public Type getType() {
        return type;
    }

}
