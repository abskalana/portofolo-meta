package org.imfl.absidibe.portofoliooptimizer.util;

/**
 * Created by absidibe on 08/04/2018.
 */
public final class PortofolioUtils {

    private PortofolioUtils() {}

    public static void printCovariance(double[][] covariances){
        int count = 0;
        int n = covariances.length;
        for (int i = 0 ; i < n; i++) {
            for (int j = 0 ; j < n ; j++) {
                System.out.println(covariances[i][j]);
                count++;
            }
        }
        System.out.println("Counter = "+ count);
    }
}
