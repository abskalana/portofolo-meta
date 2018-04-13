package org.imfl.absidibe.portofoliooptimizer.model;


public class Asset  {

    /*
     Esperance o
     */
    private double esperance;

    /*

     */
    private double std;
    private double weight;
    private Type type;

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Asset(double esperance, double std, Type type) {
        this.esperance = esperance;
        this.std = std;
        this.type = type;
    }

    @Override
    public String toString() {
        return "{type=" + type + ", weight=" + weight + '}';
    }

    public double getWeight() {
        return weight;
    }

    public Type getType() {
        return type;
    }


}
