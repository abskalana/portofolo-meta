package org.imfl.absidibe.portofoliooptimizer.model;

import java.util.ArrayList;
import java.util.List;

public class Portofolio {

    public static final int MAX_ASSET_SIZE = 30;

    private List<Asset> assets = new ArrayList<Asset>();
    private double [][] covariances  = new double[MAX_ASSET_SIZE][MAX_ASSET_SIZE];

    public void setCovariances(double[][] covariances) {
        this.covariances = covariances;
    }

    public void add(Asset asset){
       add(asset,1);
   }

    public void add(Asset asset, int number){
        for(int i = 0 ; i<number;i++){
            this.assets.add(asset);
        }
    }

    public List<Asset> getAssets() {
        return assets;
    }
}
