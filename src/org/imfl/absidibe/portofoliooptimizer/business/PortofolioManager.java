package org.imfl.absidibe.portofoliooptimizer.business;

import org.imfl.absidibe.portofoliooptimizer.model.Asset;
import org.imfl.absidibe.portofoliooptimizer.model.Portofolio;
import org.imfl.absidibe.portofoliooptimizer.model.Type;

import java.util.Random;

/**
 * Created by absidibe on 07/04/2018.
 */
public class PortofolioManager {

    private static final int RAND_MAX = 32767;

    public void build(Portofolio portofolio){
        addAsset(portofolio,10,10,10);
        setUpCovariance(portofolio);
    }

    public void setUpCovariance(Portofolio portofolio) {
        int n = portofolio.getSize();
        Random random = new Random();
        double[][] covariances = new double[30][30];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    covariances[i][j] = 0.1 + (4.0 * random.nextInt(RAND_MAX)) / RAND_MAX;
                } else {
                    covariances[i][j] = -10 + (20.0 * random.nextInt(RAND_MAX)) / RAND_MAX;
                    covariances[j][i] = covariances[i][j];
                }
            }
        }
        portofolio.setCovariances(covariances);
    }

    public static Asset create(double esperance,double std, Type type){
        return new Asset(esperance,std,type);
    }

    public void addAsset(Portofolio portofolio, int sizeType1, int sizeType2, int sizeType3){
        Type typeA = Type.create("A",0.7,0.55,0.99);
        Type typeB = Type.create("B",0.7,0.55,0.99);
        Type typeC = Type.create("C",0.7,0.54,0.98);

        int nt = sizeType1+sizeType2+sizeType3;
        for (int i = 0; i < sizeType1; i++) {
            typeA.add(1/nt);
        }
        for (int i = 0; i < sizeType2; i++) {
            typeB.add(1/nt);
        }
        for (int i = 0; i < sizeType3; i++) {
            typeC.add(1/nt);

        }

        for(int i  = 0 ; i<sizeType1; i++){
            Asset asset = create(10,0.25,typeA);
            portofolio.add(asset);
        }
        for(int i  = 0 ; i<sizeType2; i++){
            Asset asset = create(10,0.25,typeB);
            portofolio.add(asset);
        }
        for(int i  = 0 ; i<sizeType3; i++){
            Asset asset = create(10,0.25,typeC);
            portofolio.add(asset);
        }
    }
}
