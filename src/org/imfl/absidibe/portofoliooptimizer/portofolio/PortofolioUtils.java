package org.imfl.absidibe.portofoliooptimizer.portofolio;

import org.imfl.absidibe.portofoliooptimizer.model.Asset;
import org.imfl.absidibe.portofoliooptimizer.model.Matrix;
import org.imfl.absidibe.portofoliooptimizer.model.Portofolio;
import org.imfl.absidibe.portofoliooptimizer.model.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public final class PortofolioUtils {

    private PortofolioUtils() {

    }

    private static void printCovariance(Matrix matrix) {
        int n = matrix.getN();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("  " +matrix.get(i,j) + "  ");
            }
            System.out.println("\n");
        }
    }

    public static void print(Portofolio portofolio) {
        System.out.println(" =========== Portofolio ======== ");
        System.out.println("Size : "+ portofolio.getSize());
        System.out.println("Type : "+ portofolio.getTypes());
        System.out.println("Covariance : ");
        printCovariance(portofolio.getCovariances());
    }

    public static void printAsset(Portofolio portofolio) {
        System.out.println("Asset : "+ portofolio.getAssets());
        System.out.println("Value : "+ PortofolioBuilder.getValue(portofolio));
    }

}
