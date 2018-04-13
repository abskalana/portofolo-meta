package org.imfl.absidibe.portofoliooptimizer;

import org.imfl.absidibe.portofoliooptimizer.annealing.LinearyStrategy;
import org.imfl.absidibe.portofoliooptimizer.annealing.SimulatedAnnealing;
import org.imfl.absidibe.portofoliooptimizer.model.Portofolio;
import org.imfl.absidibe.portofoliooptimizer.model.Type;
import org.imfl.absidibe.portofoliooptimizer.portofolio.ConstraintChecker;
import org.imfl.absidibe.portofoliooptimizer.portofolio.PortofolioBuilder;
import org.imfl.absidibe.portofoliooptimizer.portofolio.PortofolioUtils;
import java.util.HashMap;
import java.util.Map;

public class Application {


    public static void main(String[] args) throws CloneNotSupportedException {
        Portofolio portofolio = new Portofolio();

        Map<Type,Integer> maps = new HashMap<Type, Integer>();
        maps.put(Type.create("Google", 0.7, 0.55, 0.99), 2);
        maps.put(Type.create("IBM", 0.7, 0.55, 0.99), 3);
        maps.put(Type.create("Apple", 0.7, 0.54, 0.98), 2);
        maps.put(Type.create("INTEL", 0.7, 0.54, 0.98), 1);
        maps.put(Type.create("ORACLE", 0.7, 0.54, 0.98), 1);

        PortofolioBuilder.setupPortofolio(portofolio, maps);

        PortofolioUtils.print(portofolio);

        Portofolio initialPortoloio = PortofolioBuilder.getInitialPortoloio(portofolio);
        PortofolioUtils.printAsset(initialPortoloio);

        Portofolio voisinagePortofolio = PortofolioBuilder.voisinage(portofolio);
        PortofolioUtils.printAsset(PortofolioBuilder.voisinage(voisinagePortofolio));


        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing();
        LinearyStrategy linearyStrategy = new LinearyStrategy(1000,1,0.95);
        simulatedAnnealing.setStrategy(linearyStrategy);
        simulatedAnnealing.setConstraintChecker(new ConstraintChecker());

        simulatedAnnealing.process(initialPortoloio);


    }
}
