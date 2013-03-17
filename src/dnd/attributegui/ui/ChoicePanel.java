/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.attributegui.ui;

import dnd.attributegui.Character;
import dnd.attributegui.classes.*;
import dnd.attributegui.generators.*;
import dnd.attributegui.races.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Mike
 */
public class ChoicePanel extends JPanel{
    
    private Character _character;
    private JComboBox _generatorBox;
    private JComboBox _classBox;
    private JComboBox _raceBox;
    
    private BaseClass[] _classes = {
        new Ardent(), new Avenger(), new Barbarian(), new Bard(), 
        new Battlemind(), new Cleric(), new Druid(), new Fighter(), 
        new Invoker(), new Monk(), new Paladin(), new Psion(), new Ranger(), 
        new Rogue(), new RunePriest(), new Seeker(), new Shaman(), 
        new Sorcerer(), new Warden(), new Warlock(), new Warlord(), new Wizard()
    };
    private BaseRace[] _races = {
        new Deva(), new Dragonborn(), new Dwarf(), new Eladrin(), new Elf(), 
        new Githzerai(1), new Githzerai(3), new Gnome(), new Goliath(),
        new HalfElf(), new HalfOrc(), new Halfling(), new Human(0), new Human(1),
        new Human(2), new Human(3), new Human(4), new Human(5), new Minotaur(2),
        new Minotaur(4), new Shardmind(4), new Shardmind(5), new Shifter(),
        new Tiefling(), new Wilden(2), new Wilden(1)
    };
    private BaseGenerator[] _generators = {
        new NormalSpread(), new SpecialSpread(), new DualSpecSpread(),
        new NormalRoll(), new PowerRoll()
    };
    
    public ChoicePanel(Character c){
        _character = c;
        loadPanel();
        setupPanel();
        attachListeners();
    }
    private void loadPanel(){
        Vector<String> generators = new Vector<String>();
        for(BaseGenerator g : _generators){
            generators.add(g.getName());
        }
        Vector<String> classes = new Vector<String>();
        for(BaseClass c : _classes){
            classes.add(c.getName());
        }
        Vector<String> races = new Vector<String>();
        for(BaseRace r : _races){
            races.add(r.getName());
        }
        _generatorBox = new JComboBox(generators);
        _classBox = new JComboBox(classes);
        _raceBox = new JComboBox(races);
    }
    private void setupPanel(){
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel editionLabel = new JLabel("Roll Type: ");
        JLabel classLabel = new JLabel("Class: ");
        JLabel raceLabel = new JLabel("Race: ");

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(
                    layout.createParallelGroup()
                        .addComponent(editionLabel)
                        .addComponent(_generatorBox))
                .addGroup(
                    layout.createParallelGroup()
                        .addComponent(classLabel)
                        .addComponent(_classBox))
                .addGroup(
                    layout.createParallelGroup()
                        .addComponent(raceLabel)
                        .addComponent(_raceBox))
        );
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(
                    layout.createParallelGroup()
                        .addComponent(editionLabel)
                        .addComponent(classLabel)
                        .addComponent(raceLabel))
                .addGroup(
                    layout.createParallelGroup()
                        .addComponent(_generatorBox)
                        .addComponent(_classBox)
                        .addComponent(_raceBox))

        );
    }

    private void attachListeners(){
        _generatorBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int index = _generatorBox.getSelectedIndex();
                BaseGenerator g = _generators[index];
                _character.setGenerator(g);
            }
        });
        _classBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int index = _classBox.getSelectedIndex();
                BaseClass c = _classes[index];
                _character.setClass(c);
            }
        });
        _raceBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int index = _raceBox.getSelectedIndex();
                BaseRace r = _races[index];
                _character.setRace(r);
            }
        });
    }
}
