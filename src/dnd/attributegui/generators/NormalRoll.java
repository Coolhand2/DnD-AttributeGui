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
public class NormalRoll extends BaseGenerator{
    @Override
    public String getName(){
        return "Normal Roll";
    }
    
    @Override
    public int[] getAttributes(){
        int[] local = {0, 0, 0, 0, 0, 0};
        for(int i = 0; i < 6; i++){
            double[] rolls = {0.0, 0.0, 0.0, 0.0};
            for(int k = 0; k < 4; k++){
                rolls[k] = Math.random() % 6 + 1;
            }
            Arrays.sort(rolls);
            double sum = rolls[1] + rolls[2] + rolls[3];
            local[i] = Integer.parseInt(String.valueOf(sum));
        }
        return local;
    }
}
