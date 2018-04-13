package org.imfl.absidibe.portofoliooptimizer;

import org.imfl.absidibe.portofoliooptimizer.annealing.*;
import org.imfl.absidibe.portofoliooptimizer.model.Portofolio;
import org.imfl.absidibe.portofoliooptimizer.model.Type;
import org.imfl.absidibe.portofoliooptimizer.portofolio.PortofolioBuilder;
import org.imfl.absidibe.portofoliooptimizer.portofolio.PortofolioUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {


    public static void main(String[] args) throws CloneNotSupportedException, IOException {
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


        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(new LinearyStrategy(1000,1.0,0.95));
        LinearyStrategy linearyStrategy = new LinearyStrategy(1000,1,0.95);
        simulatedAnnealing.setStrategy(linearyStrategy);

        simulatedAnnealing.process(initialPortoloio);

        List<SimulatedStrategy> simulatedStrategies = new ArrayList<SimulatedStrategy>();
        simulatedStrategies.add(new LinearyStrategy(1000,1.0,0.95));
        simulatedStrategies.add(new FastStrategy(1000,1.0,0.95));
        simulatedStrategies.add(new BoltzStrategy(1000,1.0,0.95));
        simulatedStrategies.add(new ExpStrategy(1000,1.0,0.95));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result.csv"));
        bufferedWriter.write("Nom;Herfindahl index value; Temperature; Iteration");
        bufferedWriter.newLine();
        for(SimulatedStrategy strategy :simulatedStrategies){
            System.out.println(simulatedAnnealing.process(initialPortoloio,strategy));
            bufferedWriter.write(simulatedAnnealing.process(initialPortoloio,strategy));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();


    }
}
