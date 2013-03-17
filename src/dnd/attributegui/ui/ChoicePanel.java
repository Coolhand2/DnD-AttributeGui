/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.attributegui.ui;

import dnd.attributegui.Character;
import dnd.attributegui.classes.*;
import dnd.attributegui.races.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JComboBox _generators;
    private JComboBox _classes;
    private JComboBox _races;
    public ChoicePanel(Character c){
        _character = c;
        loadPanel();
        setupPanel();
        attachListeners();
    }
    private void loadPanel(){
        String[] generators = {"", "Normal Spread", "Specialist Spread", "Dual-Specialist", "Normal Roll", "Power Roll"};
        String[] classes = {"", "Ardent", "Avenger", "Barbarian", "Bard", "Battlemind", "Cleric", "Druid", "Fighter", "Invoker", "Monk", "Paladin", "PSion", "Ranger", "Rogue", "RunePriest", "Seeker", "Shaman", "Sorcerer", "Warden", "Warlock", "Warlord", "Wizard"};
        String[] races = {"", "Deva", "Dragonborn", "Dwarf", "Eladrin", "Elf", "Githzerai", "Gnome", "Goliath", "HalfElf", "HalfOrc", "Halfling", "Human", "Minotaur", "Shardmind", "Shifter", "Tiefling", "Wilden"};

        _generators = new JComboBox(generators);
        _classes = new JComboBox(classes);
        _races = new JComboBox(races);
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
                        .addComponent(_generators))
                .addGroup(
                    layout.createParallelGroup()
                        .addComponent(classLabel)
                        .addComponent(_classes))
                .addGroup(
                    layout.createParallelGroup()
                        .addComponent(raceLabel)
                        .addComponent(_races))
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
                        .addComponent(_generators)
                        .addComponent(_classes)
                        .addComponent(_races))

        );
    }

    private void attachListeners(){
        _generators.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                _character.setGenerator(_generators.getSelectedItem());
            }
        });
        _classes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                _character.setClass(new Fighter());
            }
        });
        _races.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                _character.setRace(new Human(0));
            }
        });
    }
}
