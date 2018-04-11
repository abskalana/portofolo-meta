package org.imfl.absidibe.portofoliooptimizer.business;

import android.util.ArraySet;
import org.imfl.absidibe.portofoliooptimizer.model.Asset;
import org.imfl.absidibe.portofoliooptimizer.model.Matrix;
import org.imfl.absidibe.portofoliooptimizer.model.Portofolio;
import org.imfl.absidibe.portofoliooptimizer.model.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class PortofolioBuilder {

    private static final int RAND_MAX = 32767;


    public Portofolio setupPortofolio(Portofolio portofolio, int sizeTypeA, int sizeTypeB, int sizeTypeC) {

        int portfolioSize = sizeTypeA + sizeTypeB + sizeTypeC;
        Type typeA = Type.create("A", 0.7, 0.55, 0.99);
        List<Asset> listAssetOfTypeA = createAssetByTypeAndSize(typeA, sizeTypeA);
        portofolio.add(listAssetOfTypeA);

        Type typeB = Type.create("B", 0.7, 0.55, 0.99);
        List<Asset> listAssetOfTypeB = createAssetByTypeAndSize(typeB, sizeTypeB);
        portofolio.add(listAssetOfTypeB);

        Type typeC = Type.create("C", 0.7, 0.54, 0.98);
        List<Asset> listAssetOfTypeC = createAssetByTypeAndSize(typeC, sizeTypeC);
        portofolio.add(listAssetOfTypeC);

        portofolio.setCovariances(createCovariance(portfolioSize));

        return portofolio;
    }

    private List<Asset> createAssetByTypeAndSize(Type type, int sizeType) {
        List<Asset> assets = new ArrayList<Asset>();
        for (int i = 0; i < sizeType; i++) {
            Asset asset = new Asset(10, 0.25, type);
            assets.add(asset);
        }
        return assets;
    }

    public Matrix createCovariance(int n) {
        Random random = new Random();
        Matrix matrix = new Matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix.set(i,i, 0.1 + (4.0 * random.nextInt(RAND_MAX)) / RAND_MAX);
                } else {
                    matrix.set(i,j,  -10 + (20.0 * random.nextInt(RAND_MAX)) / RAND_MAX);
                    matrix.set(j,i,  -10 + (20.0 * random.nextInt(RAND_MAX)) / RAND_MAX);
                }
                }
            }
        return matrix;
    }
}
