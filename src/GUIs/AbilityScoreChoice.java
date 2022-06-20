package GUIs;

import Classes.Rogue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbilityScoreChoice {
    JFrame frame;
    JPanel panel;
    JLabel title, str, dex, con, intel, wis, cha;
    JSpinner strSpin, dexSpin, conSpin, intelSpin, wisSpin, chaSpin;
    JButton randomScore, create;
    SpinnerModel model1 = new SpinnerNumberModel(10, 3, 20, 1);
    SpinnerModel model2 = new SpinnerNumberModel(10, 3, 20, 1);
    SpinnerModel model3 = new SpinnerNumberModel(10, 3, 20, 1);
    SpinnerModel model4 = new SpinnerNumberModel(10, 3, 20, 1);
    SpinnerModel model5 = new SpinnerNumberModel(10, 3, 20, 1);
    SpinnerModel model6 = new SpinnerNumberModel(10, 3, 20, 1);
    GridBagConstraints gbc = new GridBagConstraints();

    public AbilityScoreChoice(String nameTF, String classCB, String raceCB) {

        frame = new JFrame();
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(5, 5, 5, 5);

        title = new JLabel("Choose your Ability Scores");
        title.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        panel.add(title, gbc);

        //button shit for generating a random appropriate number goes here
        ///
        ////////

        str = new JLabel("STR:");
        str.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(str, gbc);
        strSpin = new JSpinner(model1);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(strSpin, gbc);

        dex = new JLabel("DEX:");
        dex.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(dex, gbc);
        dexSpin = new JSpinner(model2);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(dexSpin, gbc);

        con = new JLabel("CON:");
        con.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(con, gbc);
        conSpin = new JSpinner(model3);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(conSpin, gbc);

        intel = new JLabel("INT:");
        intel.setForeground(Color.red);
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(intel, gbc);
        intelSpin = new JSpinner(model4);
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(intelSpin, gbc);

        wis = new JLabel("WIS:");
        wis.setForeground(Color.red);
        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(wis, gbc);
        wisSpin = new JSpinner(model5);
        gbc.gridx = 3;
        gbc.gridy = 3;
        panel.add(wisSpin, gbc);

        cha = new JLabel("CHA:");
        cha.setForeground(Color.red);
        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(cha, gbc);
        chaSpin = new JSpinner(model6);
        gbc.gridx = 3;
        gbc.gridy = 4;
        panel.add(chaSpin, gbc);

        create = new JButton("Create");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rogue r = new Rogue();
                r.createLevel1Rogue(nameTF, classCB, raceCB);
                r.setStrength((Integer) strSpin.getValue());
                r.setDexterity((Integer) dexSpin.getValue());
                r.setConstitution((Integer) conSpin.getValue());
                r.setIntelligence((Integer) intelSpin.getValue());
                r.setWisdom((Integer) wisSpin.getValue());
                r.setCharisma((Integer) chaSpin.getValue());
                int mod = r.findModifier(r.dexterity);
                r.armourClass = r.baseAC + mod;
                if (r.armourClass < 10) {
                    r.armourClass = 10;
                }
                mod = r.findModifier(r.constitution);
                r.healthPoints = 8 + mod;
                if (r.healthPoints < 8) {
                    r.healthPoints = 8;
                }
                CharacterSheet i = new CharacterSheet(r);
                frame.dispose();

            }
        });
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        panel.add(create, gbc);


        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Choose your Ability Scores");
        frame.pack();
        frame.setVisible(true);
    }
}
