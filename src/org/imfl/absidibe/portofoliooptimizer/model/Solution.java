package org.imfl.absidibe.portofoliooptimizer.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by absidibe on 08/04/2018.
 */
public class Solution {

    List<Double> variabletype1 = new ArrayList<Double>();
    List<Double> variabletype2 = new ArrayList<Double>();
    List<Double> variabletype3 = new ArrayList<Double>();

    public double eval(Portofolio portofolio){
        double result = 0;
        int a = variabletype1.size();
        int b = variabletype2.size();
        int c = variabletype3.size();

        for (int i = 0; i < a; i++) {
            result = result + (variabletype1.get(i) * variabletype1.get(i));
        }
        for (int i = 0; i < b; i++) {
            result = result + (variabletype2.get(i) * variabletype2.get(i));
        }
        for (int i = 0; i < c; i++) {

            result = result + (variabletype3.get(i) * variabletype3.get(i));
        }
        return result;

    }


    public double getValue(int index){
        int a = variabletype1.size();
        int b = variabletype2.size();
        int c = variabletype3.size();
        if (index < a)
            return variabletype1.get(index);
        if (index < a + b)
            return variabletype2.get(index - a);
        if (index < a + b + c)
            return variabletype3.get(index - a - b);
        return 0;
    }

    public boolean isRealisable(Portofolio portofolio){
        return true;
    }


}
