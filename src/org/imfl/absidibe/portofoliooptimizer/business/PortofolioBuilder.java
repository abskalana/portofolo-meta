package org.imfl.absidibe.portofoliooptimizer.business;

import android.util.ArraySet;
import org.imfl.absidibe.portofoliooptimizer.model.Asset;
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

        double[][] covariances = createCovariance(portfolioSize);
        portofolio.setCovariances(covariances);

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

    public double[][] createCovariance(int n) {
        Random random = new Random();
        double[][] covariances = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    covariances[i][j] = 0.1 + (4.0 * random.nextInt(RAND_MAX)) / RAND_MAX;
                } else {
                    covariances[j][i] = covariances[i][j] = -10 + (20.0 * random.nextInt(RAND_MAX)) / RAND_MAX;
                }
            }
        }
        return covariances;
    }

    public Portofolio voisinage(Portofolio portofolio){

       // Portofolio temp = *this;
       // temp = Voisinage_Ajout();
       // return temp;

        return null;
    }

    Portofolio Voisinage_Ajout(Portofolio p){
        Portofolio temp = p;

        double f;
        int C;
        int a = variabletype1.size();
        int b = variabletype2.size();
        int c = variabletype3.size();

        srand(1);

        Random random = new Random();
        C= 1+random.nextInt(RAND_MAX)%6;
        f= random.nextInt(RAND_MAX)/(RAND_MAX+1.0)/10;

        Set<Type> types = p.getTypes();
        for(Type type :types){
            List<Asset> assets = p.getAssets(type);

        }

        if(c==1){
            for (int i = 0; i < a; i++) {
                if(variabletype1[i]>0.5)
                    return temp;
                else
                    temp.variabletype1[i] = variabletype1[i]+f;
            }
            for (int i = 0; i < b; i++) {
                if(variabletype2[i]<(f/2))
                    temp.variabletype2[i]=(f/2)-variabletype2[i];
                else{
                    temp.variabletype2[i] = variabletype2[i]-(f/2);
                }

            }


            for (int i = 0; i < c; i++) {

                if(variabletype3[i]<(f/2))
                    temp.variabletype3[i]=(f/2)-variabletype3[i];
                else
                    temp.variabletype3[i] = variabletype3[i]-(f/2);
            }


        }
        if(C==2){
            for (int i = 0; i < a; i++) {
                if(variabletype1[i]>0.5)
                    return temp;
                else
                    temp.variabletype1[i] = variabletype1[i]+(f/2);

            }
            for (int i = 0; i < b; i++) {
                if(variabletype2[i]>0.5)
                    return temp;
                else
                    temp.variabletype2[i] = variabletype2[i]+(f/2);

            }
            for (int i = 0; i < c; i++) {

                if(variabletype3[i]< f)
                    temp.variabletype3[i]=f-variabletype3[i];
                else
                    temp.variabletype3[i] = variabletype3[i]-f;
            }}


        if(C==3){
            for (int i = 0; i < a; i++) {
                if(variabletype1[i]<f)
                    temp.variabletype1[i]=f-variabletype1[i];

                else
                    temp.variabletype1[i] = variabletype1[i]-f;
            }
            for (int i = 0; i < b; i++) {
                if(variabletype2[i]>0.5)
                    return temp;
                else
                    temp.variabletype2[i] = variabletype2[i]+(f/2);

            }
            for (int i = 0; i < c; i++) {
                if(variabletype3[i]>0.5)
                    return temp;
                else

                    temp.variabletype3[i] = variabletype3[i]+(f/2);

            }	}

        if(C==4){
            for (int i = 0; i < a; i++) {
                if(variabletype1[i]<(f/2))
                    temp.variabletype1[i]=(f/2)-variabletype1[i];
                else
                    temp.variabletype1[i] = variabletype1[i]-(f/2);
            }
            for (int i = 0; i < b; i++) {
                if(variabletype2[i]<(f/2))
                    temp.variabletype2[i]=(f/2)-variabletype2[i];
                else
                    temp.variabletype2[i] = variabletype2[i]-(f/2);
            }
            for (int i = 0; i < c; i++) {

                if(variabletype3[i]>0.5)
                    return temp;
                else
                    temp.variabletype3[i] = variabletype3[i]+f;

            }}
        if(C==5){
            for (int i = 0; i < a; i++) {
                if(variabletype1[i]>3)
                    return temp;
                else
                    temp.variabletype1[i] = variabletype1[i]+(f/2);

            }
            for (int i = 0; i < b; i++) {
                if(variabletype2[i]<(f))
                    temp.variabletype2[i]=f-variabletype2[i];
                else
                    temp.variabletype2[i] = variabletype2[i]-f;
            }
            for (int i = 0; i < c; i++) {
                if(variabletype3[i]>0.5)
                    return temp;
                else
                    variabletype3[i] = variabletype3[i]+(f/2);

            }}
        if(C==6){
            for (int i = 0; i < a; i++) {
                if(variabletype1[i]<(f/2))
                    temp.variabletype1[i]=f/2-variabletype1[i];

                else
                    temp.variabletype1[i] = variabletype1[i]-(f/2);
            }
            for (int i = 0; i < b; i++) {
                if(variabletype2[i]>0.5)
                    return temp;
                else
                    temp.variabletype2[i] = variabletype2[i]+(f);

            }
            for (int i = 0; i < c; i++) {

                if(variabletype3[i]<(f/2))
                    temp.variabletype3[i]=(f/2)-variabletype3[i];
                else
                    temp.variabletype3[i] = variabletype3[i]-(f/2);
            }
        }
        return temp;
}
