package org.imfl.absidibe.portofoliooptimizer.model;

import java.util.ArrayList;
import java.util.List;


public class Type {

    private String name;
    private double budget;
    private double error;
    private double risk;
    private List<Double> bornesup = new ArrayList<Double>();


    public static Type create(String name,double budget,double error, double risk){
        return new Type(budget,error,name,risk);
    }

    private  Type(double budget, double error, String name, double risk) {
        this.budget = budget;
        this.error = error;
        this.name = name;
        this.risk = risk;
    }

    public void add(double borne){
        this.bornesup.add(borne);
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
}
