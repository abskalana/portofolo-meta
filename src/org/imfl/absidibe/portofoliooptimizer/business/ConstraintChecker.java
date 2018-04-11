package org.imfl.absidibe.portofoliooptimizer.business;

import org.imfl.absidibe.portofoliooptimizer.model.Asset;
import org.imfl.absidibe.portofoliooptimizer.model.Portofolio;
import org.imfl.absidibe.portofoliooptimizer.model.Type;

import java.util.List;
import java.util.Set;


public class ConstraintChecker {


    public static boolean isRealisable(Portofolio portofolio) {
        if (!isAllBudgetUsed(portofolio)) {
            return false;
        }
        if (!isEachTypeBudgetRespected(portofolio)) {
            return false;
        }

        if (!isErrorRespected(portofolio)) {
            return false;
        }
        if (!isRiskRespected(portofolio)) {
            return false;
        }
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
        return !(budget > 1 || budget < 0.95);
    }


    private static boolean isRiskRespected(Portofolio portofolio) {
        double sumTotal = 0;
        double matricecovariance[][] = portofolio.getCovariances();
        int size = portofolio.getSize();
        List<Asset> assetsAll = portofolio.getAssets();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double result_i = assetsAll.get(i).getWeight();
                double result_j = assetsAll.get(j).getWeight();
                sumTotal = sumTotal + matricecovariance[i][j] * result_i * result_j;
            }
        }
        if (sumTotal == 0) {
            return false;
        }

        Set<Type> types = portofolio.getTypes();
        int index = 0;
        for (Type type : types) {
            List<Asset> assets = portofolio.getAssets(type);
            double sumOfType = computeSum(index, index + assets.size(), matricecovariance, assets);
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

    private static double computeSum(int start, int end, double matricecovariance[][], List<Asset> assets) {
        double result = 0;
        for (int i = start; i < end; i++) {
            for (int j = start; j < end; j++) {
                result = (result + matricecovariance[i][j]) * (assets.get(i).getWeight() * assets.get(j).getWeight());
            }
        }
        return result;
    }


}
