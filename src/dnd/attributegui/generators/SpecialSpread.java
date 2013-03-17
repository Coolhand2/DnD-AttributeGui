/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.attributegui.generators;

/**
 *
 * @author mike
 */
public class SpecialSpread extends BaseGenerator {

    @Override
    public String getName() {
        return "Specialized Array";
    }

    @Override
    public int[] getAttributes() {
        int[] local = {18, 15, 14, 10, 10, 8};
        return local;
    }
}
