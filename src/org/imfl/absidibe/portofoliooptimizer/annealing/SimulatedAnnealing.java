package org.imfl.absidibe.portofoliooptimizer.annealing;


import org.imfl.absidibe.portofoliooptimizer.annealing.SimulatedStrategy;
import org.imfl.absidibe.portofoliooptimizer.model.Portofolio;
import org.imfl.absidibe.portofoliooptimizer.portofolio.ConstraintChecker;

public class SimulatedAnnealing {

    private SimulatedStrategy strategy;
    private ConstraintChecker constraintChecker;
    private Portofolio initialSolution;



    public void setInitialSolution(Portofolio initialSolution) {
        this.initialSolution = initialSolution;
    }

    public void setConstraintChecker(ConstraintChecker constraintChecker) {
        this.constraintChecker = constraintChecker;
    }

    public void setStrategy(SimulatedStrategy strategy) {
        this.strategy = strategy;
    }

    public Portofolio process(Portofolio portofolio) {
        if(constraintChecker == null){
            throw  new NullPointerException("The constraint checker must not be null");
        }
        if(strategy == null){
            strategy = new LinearyStrategy(10,1000,2);
        }
        if(initialSolution == null){

        }
        return null;
    }

    public void process() {
        Portofolio currentSolution = new Portofolio();
    }

}
