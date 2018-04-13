package org.imfl.absidibe.portofoliooptimizer.annealing;

import org.imfl.absidibe.portofoliooptimizer.model.Portofolio;
import org.imfl.absidibe.portofoliooptimizer.portofolio.ConstraintChecker;
import org.imfl.absidibe.portofoliooptimizer.portofolio.PortofolioBuilder;
import org.imfl.absidibe.portofoliooptimizer.portofolio.PortofolioUtils;

public class SimulatedAnnealing {

    private SimulatedStrategy strategy;
    private ConstraintChecker constraintChecker;


    public SimulatedAnnealing(SimulatedStrategy simulatedStrategy) {
        this.constraintChecker = new ConstraintChecker();
        this.strategy = simulatedStrategy;
    }

    public void setStrategy(SimulatedStrategy strategy) {
        this.strategy = strategy;
    }

    public Portofolio process(Portofolio initialSolution) {
        Portofolio currentSolution = initialSolution;
        Portofolio bestSolution  = (Portofolio)currentSolution.clone();
        while (strategy.shouldContinue() && constraintChecker.isRealisable(bestSolution)){
            Portofolio selected = PortofolioBuilder.voisinage(initialSolution);
            if(PortofolioBuilder.getValue(selected) < PortofolioBuilder.getValue(bestSolution)){
                bestSolution = selected;
            }else{
                double eval_x = PortofolioBuilder.getValue(bestSolution);
                double eval_y = PortofolioBuilder.getValue(selected);

                if((Math.random()/PortofolioBuilder.RAND_MAX) < Math.exp((eval_y - eval_x) / strategy.getNext())){
                    bestSolution = selected;
                }
            }
            PortofolioUtils.printAsset(bestSolution);
        }
        return bestSolution;
    }

    public String process(Portofolio initialSolution, SimulatedStrategy simulatedStrategy) {
        Portofolio currentSolution = initialSolution;
        Portofolio bestSolution  = (Portofolio)currentSolution.clone();
        while (simulatedStrategy.shouldContinue()){
            Portofolio selected = PortofolioBuilder.voisinage(initialSolution);
            if(PortofolioBuilder.getValue(selected) < PortofolioBuilder.getValue(bestSolution)){
                bestSolution = selected;
            }else{
                double eval_x = PortofolioBuilder.getValue(bestSolution);
                double eval_y = PortofolioBuilder.getValue(selected);

                if((Math.random()/PortofolioBuilder.RAND_MAX) < Math.exp((eval_y - eval_x) / strategy.getNext())){
                    bestSolution = selected;
                }
            }
            PortofolioUtils.printAsset(bestSolution);
        }
        return simulatedStrategy.getClass().getSimpleName()+";"+ PortofolioBuilder.getValue(bestSolution)+";"+simulatedStrategy.getNext()+";"+simulatedStrategy.getIteration();
    }
}
