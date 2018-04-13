package org.imfl.absidibe.portofoliooptimizer.portofolio;

import org.imfl.absidibe.portofoliooptimizer.model.Asset;
import org.imfl.absidibe.portofoliooptimizer.model.Matrix;
import org.imfl.absidibe.portofoliooptimizer.model.Portofolio;
import org.imfl.absidibe.portofoliooptimizer.model.Type;

import java.util.List;
import java.util.Set;


public class ConstraintChecker {


    public  boolean isRealisable(Portofolio portofolio) {
        if (!isAllBudgetUsed(portofolio)) {
            return false;
        }
        /*
        if (!isEachTypeBudgetRespected(portofolio)) {
            return true;
        }

        if (!isErrorRespected(portofolio)) {
            return true;
        }
        if (!isRiskRespected(portofolio)) {
            return true;
        }
        */
        return true;
    }

    private static boolean isAllBudgetUsed(Portofolio portofolio) {
        Set<Type> types = portofolio.getTypes();
        double budget = 0;
        for (Type type : types) {
            List<Asset> assets = portofolio.getAssets(type);
            double result = 0;
            for (Asset asset : assets) {
                result = result + asset.getWeight();
            }
            budget = budget + result;

        }
        if(budget > 1.1){
            return false;
        }
        if(budget <0.9){
            return false;
        }
        return true;
    }


    private static boolean isRiskRespected(Portofolio portofolio) {
        double sumTotal = 0;
        Matrix covariances = portofolio.getCovariances();
        int size = portofolio.getSize();
        List<Asset> assetsAll = portofolio.getAssets();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double result_i = assetsAll.get(i).getWeight();
                double result_j = assetsAll.get(j).getWeight();
                sumTotal = sumTotal + covariances.get(i,j) * result_i * result_j;
            }
        }
        if (sumTotal == 0) {
            return false;
        }

        Set<Type> types = portofolio.getTypes();
        int index = 0;
        for (Type type : types) {
            List<Asset> assets = portofolio.getAssets(type);
            double sumOfType = computeSum(index, index + assets.size(), covariances, assets);
            index = assets.size();
            if ((Math.sqrt(sumOfType) / sumTotal) > type.getRisk()) {
                return false;
            }

        }
        return true;
    }

    private static boolean isEachTypeBudgetRespected(Portofolio portofolio) {
        Set<Type> types = portofolio.getTypes();
        for (Type type : types) {
            List<Asset> assets = portofolio.getAssets(type);
            double result = 0;
            for (Asset asset : assets) {
                result = result + asset.getWeight();
            }
            if (result > type.getBudget()) {
                return false;
            }

        }
        return true;
    }

    private static boolean isErrorRespected(Portofolio portofolio) {
        Set<Type> types = portofolio.getTypes();
        for (Type type : types) {
            List<Asset> assets = portofolio.getAssets(type);
            for (Asset asset : assets) {
                if (asset.getWeight() < 0.0 || asset.getWeight() > type.getError()) {
                    return false;
                }
            }

        }
        return true;
    }

    private static double computeSum(int start, int end, Matrix covariance, List<Asset> assets) {
        double result = 0;
        for (int i = start; i < end; i++) {
            for (int j = start; j < end; j++) {
                result = (result + covariance.get(i,j)) * (assets.get(i).getWeight() * assets.get(j).getWeight());
            }
        }
        return result;
    }


}
