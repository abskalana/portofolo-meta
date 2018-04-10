package org.imfl.absidibe.portofoliooptimizer.model;


public class Asset  implements  Comparable<Asset>{

    private double esperance;
    private double std;
    private double weight;
    private Type type;

    public Asset(double esperance, double std, Type type) {
        this.esperance = esperance;
        this.std = std;
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public Type getType() {
        return type;
    }

    @Override
    public int compareTo(Asset asset) {
        return this.type.compareTo(asset.type);
    }
}
