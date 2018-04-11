package org.imfl.absidibe.portofoliooptimizer.model;


public class Matrix {

    private double[][] A;
    private int  n;


    public Matrix(int n) {
        this.n = n;
        A = new double[n][n];
    }

    public int getN() {
        return n;
    }

    public double get(int i, int j) {
        return A[i][j];
    }

    public double set(int i, int j, double s) {
        return A[i][j] = s;
    }
}
