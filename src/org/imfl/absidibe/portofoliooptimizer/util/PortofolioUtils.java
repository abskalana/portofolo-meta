package org.imfl.absidibe.portofoliooptimizer.util;

public final class PortofolioUtils {

    private PortofolioUtils() {
    }

    public static void printCovariance(double[][] covariances) {
        int n = covariances.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(covariances[i][j]);
            }
        }

    }

}
