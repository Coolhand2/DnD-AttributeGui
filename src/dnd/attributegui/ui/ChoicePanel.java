/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.attributegui.ui;

import dnd.attributegui.Character;
import dnd.attributegui.classes.*;
import dnd.attributegui.editions.*;
import dnd.attributegui.races.*;
import java.awt.Container;
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
    private JComboBox _editions;
    private JComboBox _classes;
    private JComboBox _races;
    public ChoicePanel(Character c){
        _character = c;
        loadPanel();
        setupPanel();
        attachListeners();
    }
    private void loadPanel(){
        String[] editions = {"", "DnD 4e", "DnD 3.5", "DnD 3.0", "Pathfinder"};
        String[] classes = {"", "Ardent", "Avenger", "Barbarian", "Bard", "Battlemind", "Cleric", "Druid", "Fighter", "Invoker", "Monk", "Paladin", "PSion", "Ranger", "Rogue", "RunePriest", "Seeker", "Shaman", "Sorcerer", "Warden", "Warlock", "Warlord", "Wizard"};
        String[] races = {"", "Deva", "Dragonborn", "Dwarf", "Eladrin", "Elf", "Githzerai", "Gnome", "Goliath", "HalfElf", "HalfOrc", "Halfling", "Human", "Minotaur", "Shardmind", "Shifter", "Tiefling", "Wilden"};

        _editions = new JComboBox<String>(editions);
        _classes = new JComboBox<String>(classes);
        _races = new JComboBox<String>(races);
    }
    private void setupPanel(){
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel editionLabel = new JLabel("Edition: ");
        JLabel classLabel = new JLabel("Class: ");
        JLabel raceLabel = new JLabel("Race: ");

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(
                    layout.createParallelGroup()
                        .addComponent(editionLabel)
                        .addComponent(_editions))
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
                        .addComponent(_editions)
                        .addComponent(_classes)
                        .addComponent(_races))

        );
    }

    private void attachListeners(){
        _editions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                _character.setEdition(new BaseEdition());
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
