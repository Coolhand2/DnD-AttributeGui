/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.attributegui;

import dnd.attributegui.editions.BaseEdition;
import dnd.attributegui.races.BaseRace;
import dnd.attributegui.classes.BaseClass;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mike
 */
public class Character {

    List<ActionListener> _listeners = new ArrayList<ActionListener>();

    private BaseEdition _edition;
    private BaseRace _race;
    private BaseClass _class;
    private int[] _attributes;

    public Character(){

    }

    public void setEdition(BaseEdition e){ _edition = e; }
    public void setRace(BaseRace r){ _race = r; }
    public void setClass(BaseClass c){ _class = c; }
    public void setAttributes(int[] a){ _attributes = a; }
    public void generateAttributes(){
        rollAttributes();
        int[] bonuses = _race.getBonuses();
        int[] ranks = _class.getRanks();
        int[] sums = {0, 0, 0, 0, 0, 0};
        for(int i = 0; i < 6; i++){
            sums[i] += _attributes[ranks[i]] + bonuses[i];
        }
        _attributes = sums;
        notifyListeners();
    }
    public int[] getAttributes(){ return _attributes; }
    public void addActionListener(ActionListener al){
        _listeners.add(al);
    }
    private void rollAttributes(){
        _attributes[0] = 18;
        _attributes[1] = 15;
        _attributes[2] = 14;
        _attributes[3] = 10;
        _attributes[4] = 10;
        _attributes[5] = 8;
    }
    private void notifyListeners(){
        for(ActionListener al : _listeners) {
            al.actionPerformed((ActionEvent)null);
        }
    }
}
