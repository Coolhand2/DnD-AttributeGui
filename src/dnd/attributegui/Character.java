/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.attributegui;

import dnd.attributegui.classes.Ardent;
import dnd.attributegui.races.BaseRace;
import dnd.attributegui.classes.BaseClass;
import dnd.attributegui.generators.BaseGenerator;
import dnd.attributegui.generators.NormalSpread;
import dnd.attributegui.races.Deva;
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
    private BaseGenerator _generator;
    private BaseRace _race;
    private BaseClass _class;
    private int[] _attributes;

    public Character() {
        _generator = new NormalSpread();
        _race = new Deva();
        _class = new Ardent();
    }

    public void setGenerator(BaseGenerator g) {
        _generator = g;
    }

    public void setRace(BaseRace r) {
        _race = r;
    }

    public void setClass(BaseClass c) {
        _class = c;
    }

    public void generateAttributes() {
        int[] attributes = _generator.getAttributes();
        int[] bonuses = _race.getBonuses();
        int[] ranks = _class.getRanks();
        int[] sums = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 6; i++) {
            sums[i] += attributes[ranks[i]] + bonuses[i];
        }
        _attributes = sums;
        notifyListeners();
    }

    public int[] getAttributes() {
        return _attributes;
    }

    public void addActionListener(ActionListener al) {
        _listeners.add(al);
    }

    private void rollAttributes() {
        int[] local = {18, 15, 14, 10, 10, 8};
        _attributes = local;
    }

    private void notifyListeners() {
        for (ActionListener al : _listeners) {
            al.actionPerformed((ActionEvent) null);
        }
    }
}
