package org.imfl.absidibe.portofoliooptimizer.model;

public class Type {

    private String name;
    private double budget;
    private double error;
    private double risk;


    private Type() {
    }

    public static Type create(String name, double budget, double error, double risk) {
        Type type = new Type();
        type.budget = budget;
        type.error = error;
        type.name = name;
        type.risk = risk;
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        return name.equals(type.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public double getBudget() {
        return budget;
    }


    public double getError() {
        return error;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public double getRisk() {
        return risk;
    }
}
