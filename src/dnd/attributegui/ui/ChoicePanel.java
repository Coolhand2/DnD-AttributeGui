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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.MutableComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Mike
 */
public class ChoicePanel extends JPanel {

    private Character _character;
    private JComboBox _generatorBox;
    private JComboBox _classBox;
    private JComboBox _raceBox;
    private JSpinner _levelSpinner;
    private ActionListener _raceListener;

    public ChoicePanel(Character c) {
        _character = c;
        _raceListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Object index = _raceBox.getSelectedItem();
                for(BaseRace br : Character.RACES){
                    if(br.getName().equals(index.toString())){
                        _character.setRace(br);
                    }
                }
            }
        };
        loadPanel();
        setupPanel();
        attachListeners();
    }

    private void loadPanel() {
        Vector<String> generators = new Vector<>();
        for (BaseGenerator g : Character.GENERATORS) {
            generators.add(g.getName());
        }
        Vector<String> classes = new Vector<>();
        for (BaseClass c : Character.CLASSES) {
            classes.add(c.getName());
        }

        _generatorBox = new JComboBox(generators);
        _classBox = new JComboBox(classes);
        _raceBox = new JComboBox();
        setPreferredRaces();
        _levelSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
    }

    private void setupPanel() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel editionLabel = new JLabel("Roll Type: ");
        JLabel classLabel = new JLabel("Class: ");
        JLabel raceLabel = new JLabel("Race: ");
        JLabel levelLabel = new JLabel("Level: ");

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
                .addGroup(
                layout.createParallelGroup()
                .addComponent(levelLabel)
                .addComponent(_levelSpinner)));
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addGroup(
                layout.createParallelGroup()
                .addComponent(editionLabel)
                .addComponent(classLabel)
                .addComponent(raceLabel)
                .addComponent(levelLabel))
                .addGroup(
                layout.createParallelGroup()
                .addComponent(_generatorBox)
                .addComponent(_classBox)
                .addComponent(_raceBox)
                .addComponent(_levelSpinner)));
    }

    private void attachListeners() {
        _generatorBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int index = _generatorBox.getSelectedIndex();
                BaseGenerator g = Character.GENERATORS[index];
                _character.setGenerator(g);
            }
        });
        _classBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = _classBox.getSelectedIndex();
                BaseClass c = Character.CLASSES[index];
                _character.setClass(c);
                _raceBox.removeActionListener(_raceListener);
                setPreferredRaces();
                _raceBox.addActionListener(_raceListener);
            }
        });
        _raceBox.addActionListener(_raceListener);
        _levelSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                _character.setLevel(Integer.parseInt(_levelSpinner.getValue().toString()));
            }
        });
    }

    private void setPreferredRaces(){
        _raceBox.removeAllItems();
        Vector<BaseRace> preferred = _character.getPreferredRaces();
        Vector<BaseRace> average = _character.getAverageRaces();
        Vector<BaseRace> poor = _character.getPoorRaces();
        for(BaseRace item : preferred){
            _raceBox.addItem(item.getName());
        }
        _raceBox.addItem("-------");
        for(BaseRace item : average){
            _raceBox.addItem(item.getName());
        }
        _raceBox.addItem("-------");
        for(BaseRace item : poor){
            _raceBox.addItem(item.getName());
        }
        _character.setRace(preferred.elementAt(0));
    }
}
