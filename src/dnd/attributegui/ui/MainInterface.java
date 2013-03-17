/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.attributegui.ui;

import dnd.attributegui.Character;
import java.awt.Container;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Mike
 */
public class MainInterface extends JFrame {

    private Character _character;

    public MainInterface(Character c) {
        _character = c;
        setupFrame();
        loadFrame();
        setVisible(true);
    }

    private void setupFrame() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Attribute Generator");
    }

    private void loadFrame() {

        Container mainPanel = getContentPane();
        JPanel choicePanel = new ChoicePanel(_character);
        JPanel generatePanel = new GeneratePanel(_character);
        JPanel resultPanel = new ResultPanel(_character);


        GroupLayout mainLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainLayout);
        mainLayout.setAutoCreateGaps(true);
        mainLayout.setAutoCreateContainerGaps(true);

        mainLayout.setVerticalGroup(
            mainLayout.createSequentialGroup()
                .addComponent(choicePanel)
                .addComponent(generatePanel)
                .addComponent(resultPanel)
        );
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup()
                .addComponent(choicePanel)
                .addComponent(generatePanel)
                .addComponent(resultPanel)
        );

        pack();

    }
}
