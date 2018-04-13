package org.imfl.absidibe.portofoliooptimizer.annealing;


import org.imfl.absidibe.portofoliooptimizer.annealing.SimulatedStrategy;
import org.imfl.absidibe.portofoliooptimizer.model.Portofolio;
import org.imfl.absidibe.portofoliooptimizer.portofolio.ConstraintChecker;
import org.imfl.absidibe.portofoliooptimizer.portofolio.PortofolioBuilder;
import org.imfl.absidibe.portofoliooptimizer.portofolio.PortofolioUtils;

public class SimulatedAnnealing {

    private SimulatedStrategy strategy;
    private ConstraintChecker constraintChecker;


    public void setConstraintChecker(ConstraintChecker constraintChecker) {
        this.constraintChecker = constraintChecker;
    }

    public void setStrategy(SimulatedStrategy strategy) {
        this.strategy = strategy;
    }

    public Portofolio process(Portofolio initialSolution) throws CloneNotSupportedException {
        Portofolio currentSolution = initialSolution;
        Portofolio bestSolution  = (Portofolio)currentSolution.clone();
        while (strategy.shouldContinue()){
            double temperature1 = strategy.getNext();
            Portofolio neightboor = PortofolioBuilder.voisinage(initialSolution);
            if(PortofolioBuilder.getValue(neightboor) < PortofolioBuilder.getValue(bestSolution)){
                bestSolution = neightboor;
            }else{
                double eval_x = PortofolioBuilder.getValue(bestSolution);
                double eval_y = PortofolioBuilder.getValue(neightboor);

                if((Math.random()/PortofolioBuilder.RAND_MAX) < Math.exp((eval_y - eval_x) / temperature1)){
                    bestSolution = neightboor;
                }
            }
            PortofolioUtils.printAsset(bestSolution);
        }
        return null;
    }


    public void process() {
        Portofolio currentSolution = new Portofolio();
    }

}
