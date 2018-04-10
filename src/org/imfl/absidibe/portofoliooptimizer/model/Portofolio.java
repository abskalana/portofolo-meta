package org.imfl.absidibe.portofoliooptimizer.model;

import android.util.ArraySet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Portofolio {

    public static final int MAX_ASSET_SIZE = 30;

    private List<Asset> assets = new ArrayList<Asset>();
    private double[][] covariances = new double[MAX_ASSET_SIZE][MAX_ASSET_SIZE];

    public Portofolio() {
    }
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


    public List<Asset> getAssets() {
        return assets;
    }

    public Set<Type> getTypes(){
        Set<Type> types = new HashSet<Type>();
        for (Asset asset : assets) {
            types.add(asset.getType());
        }
        return  types;
    }

    public List<Asset> getAssets(Type type){
        List<Asset> results = new ArrayList<Asset>();
        for (Asset asset : assets) {
            if(asset.getType()!=null && asset.getType().equals(type)){
                results.add(asset);
            }
        }
        return  results;
    }
}
