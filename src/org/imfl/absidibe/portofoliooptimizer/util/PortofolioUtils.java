package org.imfl.absidibe.portofoliooptimizer.util;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by absidibe on 08/04/2018.
 */
public final class PortofolioUtils {

    private PortofolioUtils() {
    }

    public static int printCovariance(double[][] covariances) {
        int count = 0;
        int n = covariances.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(covariances[i][j]);
                count++;
            }
        }
        System.out.println("Counter = " + count);

        try{

        } catch (NullPointerException e){

        }
        catch (Exception e){

        }

        int deb = 0;
        return deb;

    }

    public int m5(){
        int age;
        String s = "24";
        try {
            age = getAccessCode();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getAccessCode() throws Exception {
        throw  new FileNotFoundException();
    }

}
