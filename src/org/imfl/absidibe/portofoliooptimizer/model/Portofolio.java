package org.imfl.absidibe.portofoliooptimizer.model;

import java.util.ArrayList;
import java.util.List;

public class Portofolio {

    public static final int MAX_ASSET_SIZE = 30;

    private List<Asset> assets = new ArrayList<Asset>();
    private double[][] covariances = new double[MAX_ASSET_SIZE][MAX_ASSET_SIZE];

    public void add(List<Asset> assets) {
        this.assets.addAll(assets);
    }


    public double[][] getCovariances() {
        return covariances;
    }

    public void setCovariances(double[][] covariances) {
        this.covariances = covariances;
    }

    public int getSize() {
        return assets.size();
    }

    public int getSizeByType(Type type) {
        if (type == null || assets == null) {
            return 0;
        }
        int size = 0;
        for (Asset asset : assets) {
            if (asset != null && type.equals(asset.getType())) {
                size++;
            }
        }
        return size;
    }
}
