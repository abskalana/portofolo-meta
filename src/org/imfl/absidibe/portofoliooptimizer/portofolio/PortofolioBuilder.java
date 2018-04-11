package org.imfl.absidibe.portofoliooptimizer.portofolio;

import org.imfl.absidibe.portofoliooptimizer.model.Asset;
import org.imfl.absidibe.portofoliooptimizer.model.Matrix;
import org.imfl.absidibe.portofoliooptimizer.model.Portofolio;
import org.imfl.absidibe.portofoliooptimizer.model.Type;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PortofolioBuilder {

    private static final int RAND_MAX = 32767;


    public static void setupPortofolio(Portofolio portofolio, Map<Type,Integer> types) {
        for (Map.Entry<Type, Integer> entry : types.entrySet()) {
            Type type = entry.getKey();
            int size = entry.getValue().intValue();
            List<Asset> assets = new ArrayList<Asset>(size);
            for (int i = 0; i < size; i++) {
                Asset asset = new Asset(10, 0.25, type);
                assets.add(asset);
            }
            portofolio.add(assets);
        }

        Matrix covariance = createCovariance(portofolio.getSize());
        portofolio.setCovariances(covariance);

    }

    private static  Matrix createCovariance(int n) {
        DecimalFormat df = new DecimalFormat(".##");
        Random random = new Random();
        Matrix matrix = new Matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix.set(i,i, Double.parseDouble(df.format( 0.1 + (4.0 * random.nextInt(RAND_MAX)) / RAND_MAX)));
                } else {
                    double value = Double.parseDouble(df.format( -10 + (20.0 * random.nextInt(RAND_MAX)) / RAND_MAX));
                    matrix.set(i,j,value );
                    matrix.set(j,i,value);
                }
                }
            }
        return matrix;
    }
}
