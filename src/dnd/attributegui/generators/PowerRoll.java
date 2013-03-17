/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.attributegui.generators;

import java.util.Arrays;

/**
 *
 * @author mike
 */
public class PowerRoll extends BaseGenerator {
    @Override
    public String getName(){
        return "Power Roll";
    }
    
    @Override
    public int[] getAttributes(){
        int[] local = {0, 0, 0, 0, 0, 0};
        for( int i = 0; i < 6; i++ ){
            double[] rolls = {0, 0, 0, 0};
            for( int k = 0; k < 4; k++ ){
                double roll = 1;
                do{
                    roll = Math.random() % 6 + 1;
                } while( roll == 1);
                rolls[k] = roll;
            }
            Arrays.sort(rolls);
            double sum = 0;
            if( rolls[0] == 6 ){
                sum = 19;
            } else {
                sum = rolls[1] + rolls[2] + rolls[3];
            }
            local[i] = Integer.parseInt(String.valueOf(sum));
        }
        return local;
    }
}
