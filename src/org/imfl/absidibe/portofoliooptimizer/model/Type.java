package org.imfl.absidibe.portofoliooptimizer.model;

import java.util.ArrayList;
import java.util.List;


public class Type implements Comparable<Type> {

    private String name;
    private double budget;
    private double error;
    private double risk;

    private List<Double> bornesups = new ArrayList<Double>();


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

    public void setupBorneSup(int size, int nt) {
        for (int i = 0; i < size; i++) {
            bornesups.add(1.0 / nt);
        }
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

    public List<Double> getBornesups() {
        return bornesups;
    }

    public void setBornesups(List<Double> bornesups) {
        this.bornesups = bornesups;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRisk() {
        return risk;
    }

    public void setRisk(double risk) {
        this.risk = risk;
    }

    @Override
    public int compareTo(Type type) {
        return this.name.compareTo(type.name);
    }
}
