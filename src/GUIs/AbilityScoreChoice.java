package GUIs;

import Classes.*;
import GUIs.LEVEL1.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class AbilityScoreChoice {
    JFrame frame;
    JPanel panel;
    JLabel title, str, dex, con, intel, wis, cha;
    JSpinner strSpin, dexSpin, conSpin, intelSpin, wisSpin, chaSpin;
    JButton randomScore, create;
    JTextPane num;
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

        randomScore = new JButton("Random");
        randomScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> perRoll = new ArrayList<>();
                int score = 0;

                for (int i = 0; i < 4; i++) {
                    double roll = Math.random() * 6;
                    int convertedRoll = (int) roll + 1;
                    perRoll.add(convertedRoll);
                }
                Collections.sort(perRoll);
                perRoll.remove(0);
                for (int i : perRoll) {
                    score += i;
                }
                num.setText(String.valueOf(score));
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(randomScore, gbc);

        num = new JTextPane();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(num, gbc);


        ////////

        str = new JLabel("STR:");
        str.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(str, gbc);
        strSpin = new JSpinner(model1);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(strSpin, gbc);

        dex = new JLabel("DEX:");
        dex.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(dex, gbc);
        dexSpin = new JSpinner(model2);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(dexSpin, gbc);

        con = new JLabel("CON:");
        con.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(con, gbc);
        conSpin = new JSpinner(model3);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(conSpin, gbc);

        intel = new JLabel("INT:");
        intel.setForeground(Color.red);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(intel, gbc);
        intelSpin = new JSpinner(model4);
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(intelSpin, gbc);

        wis = new JLabel("WIS:");
        wis.setForeground(Color.red);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(wis, gbc);
        wisSpin = new JSpinner(model5);
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(wisSpin, gbc);

        cha = new JLabel("CHA:");
        cha.setForeground(Color.red);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(cha, gbc);
        chaSpin = new JSpinner(model6);
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(chaSpin, gbc);

        create = new JButton("Create");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (classCB == "Barbarian") {
                    Barbarian r = new Barbarian();
                    r.createLevel1Barbarian(nameTF, classCB, raceCB);
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
                    r.healthPoints = 12 + mod;
                    if (r.healthPoints < 12) {
                        r.healthPoints = 12;
                    }
                    Barbarian1CharacterSheet i = new Barbarian1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB == "Bard") {
                    Bard r = new Bard();
                    r.createLevel1Bard(nameTF, classCB, raceCB);
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
                    Bard1CharacterSheet i = new Bard1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB == "Cleric") {
                    Cleric r = new Cleric();
                    r.createLevel1Cleric(nameTF, classCB, raceCB);
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
                    Cleric1CharacterSheet i = new Cleric1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB == "Druid") {
                    Druid r = new Druid();
                    r.createLevel1Druid(nameTF, classCB, raceCB);
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
                    Druid1CharacterSheet i = new Druid1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB == "Fighter") {
                    Fighter r = new Fighter();
                    r.createLevel1Fighter(nameTF, classCB, raceCB);
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
                    r.healthPoints = 10 + mod;
                    if (r.healthPoints < 10) {
                        r.healthPoints = 10;
                    }
                    Fighter1CharacterSheet i = new Fighter1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB == "Monk") {
                    Monk r = new Monk();
                    r.createLevel1Monk(nameTF, classCB, raceCB);
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
                    Monk1CharacterSheet i = new Monk1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB == "Paladin") {
                    Paladin r = new Paladin();
                    r.createLevel1Paladin(nameTF, classCB, raceCB);
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
                    r.healthPoints = 10 + mod;
                    if (r.healthPoints < 10) {
                        r.healthPoints = 10;
                    }
                    Paladin1CharacterSheet i = new Paladin1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB == "Ranger") {
                    Ranger r = new Ranger();
                    r.createLevel1Ranger(nameTF, classCB, raceCB);
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
                    r.healthPoints = 10 + mod;
                    if (r.healthPoints < 10) {
                        r.healthPoints = 10;
                    }
                    Ranger1CharacterSheet i = new Ranger1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB == "Rogue") {
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
                    Rogue1CharacterSheet i = new Rogue1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB == "Sorcerer") {
                    Sorcerer r = new Sorcerer();
                    r.createLevel1Sorcerer(nameTF, classCB, raceCB);
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
                    r.healthPoints = 6 + mod;
                    if (r.healthPoints < 6) {
                        r.healthPoints = 6;
                    }
                    Sorcerer1CharacterSheet i = new Sorcerer1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB == "Warlock") {
                    Warlock r = new Warlock();
                    r.createLevel1Warlock(nameTF, classCB, raceCB);
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
                    Warlock1CharacterSheet i = new Warlock1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB == "Wizard") {
                    Wizard r = new Wizard();
                    r.createLevel1Wizard(nameTF, classCB, raceCB);
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
                    r.healthPoints = 6 + mod;
                    if (r.healthPoints < 6) {
                        r.healthPoints = 6;
                    }
                    Wizard1CharacterSheet i = new Wizard1CharacterSheet(r);
                    frame.dispose();
                }
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
