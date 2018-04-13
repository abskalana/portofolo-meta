package org.imfl.absidibe.portofoliooptimizer.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Portofolio implements  Cloneable{
    /**
     * Financial assets
     */
    private List<Asset> assets = new ArrayList<Asset>();
    /**
     * Matrix of covariance between assets
     */
    private Matrix covariances;

    public Portofolio() {
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public Set<Type> getTypes() {
        Set<Type> types = new HashSet<Type>();
        for (Asset asset : assets) {
            types.add(asset.getType());
        }
        return types;
    }

    public List<Asset> getAssets(Type type) {
        List<Asset> results = new ArrayList<Asset>();
        for (Asset asset : assets) {
            if (asset.getType() != null && asset.getType().equals(type)) {
                results.add(asset);
            }
        }
        return results;
    }


    @Override
    public Object clone() {
        Portofolio portofolio = new Portofolio();
        portofolio.setCovariances(this.covariances);
        portofolio.add(this.assets);
        return portofolio;
    }

    public void add(List<Asset> assets) {
        this.assets.addAll(assets);
    }

    public Matrix getCovariances() {
        return covariances;
    }

    public void setCovariances(Matrix covariances) {
        this.covariances = covariances;
    }

    public int getSize() {
        return assets.size();
    }

}
