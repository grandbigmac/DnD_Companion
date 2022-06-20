package GUIs;

import Classes.Rogue;
import dbAccess.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterSheet {

    JFrame frame;
    JPanel panel;
    JLabel nameTag, classTag, levelTag, acTag, healthTag, strTag, dexTag, conTag, intelTag, wisTag, chaTag, featuresTag, raceTag;
    JLabel nameLab, classLab, levelLab, acLab, healthLab, scores, str, dex, con, intel, wis, cha, charRace;
    JButton reroll, checkFeatures;
    JComboBox<String> features;
    GridBagConstraints gbc = new GridBagConstraints();

    public CharacterSheet(Rogue r) {

        frame = new JFrame();
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(5, 5, 5, 5);

        nameTag = new JLabel("Name: ");
        nameTag.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameTag, gbc);
        nameLab = new JLabel(r.charName);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(nameLab, gbc);

        raceTag = new JLabel("Race: ");
        raceTag.setForeground(Color.red);
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        panel.add(raceTag, gbc);
        charRace = new JLabel(r.charRace);
        gbc.gridx = 5;
        gbc.gridy = 0;
        panel.add(charRace, gbc);

        classTag = new JLabel("Class: ");
        classTag.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(classTag, gbc);
        classLab = new JLabel(r.charClass);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(classLab, gbc);

        levelTag = new JLabel("Level: ");
        levelTag.setForeground(Color.red);
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(levelTag, gbc);
        levelLab = new JLabel(String.valueOf(r.charLevel));
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(levelLab, gbc);

        acTag = new JLabel("AC: ");
        acTag.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(acTag, gbc);
        acLab = new JLabel(String.valueOf(r.armourClass));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(acLab, gbc);

        healthTag = new JLabel("Health: ");
        healthTag.setForeground(Color.red);
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(healthTag, gbc);
        healthLab = new JLabel(String.valueOf(r.healthPoints));
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(healthLab, gbc);

        scores = new JLabel("Ability Scores");
        scores.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        panel.add(scores, gbc);

        strTag = new JLabel("STR: ");
        strTag.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(strTag, gbc);
        str = new JLabel(String.valueOf(r.strength));
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(str, gbc);

        dexTag = new JLabel("DEX: ");
        dexTag.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(dexTag, gbc);
        dex = new JLabel(String.valueOf(r.dexterity));
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(dex, gbc);

        conTag = new JLabel("CON: ");
        conTag.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(conTag, gbc);
        con = new JLabel(String.valueOf(r.constitution));
        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(con, gbc);

        intelTag = new JLabel("INT: ");
        intelTag.setForeground(Color.red);
        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(intelTag, gbc);
        intel = new JLabel(String.valueOf(r.intelligence));
        gbc.gridx = 3;
        gbc.gridy = 4;
        panel.add(intel, gbc);

        wisTag = new JLabel("WIS: ");
        wisTag.setForeground(Color.red);
        gbc.gridx = 2;
        gbc.gridy = 5;
        panel.add(wisTag, gbc);
        wis = new JLabel(String.valueOf(r.wisdom));
        gbc.gridx = 3;
        gbc.gridy = 5;
        panel.add(wis, gbc);

        chaTag = new JLabel("CHA: ");
        chaTag.setForeground(Color.red);
        gbc.gridx = 2;
        gbc.gridy = 6;
        panel.add(chaTag, gbc);
        cha = new JLabel(String.valueOf(r.charisma));
        gbc.gridx = 3;
        gbc.gridy = 6;
        panel.add(cha, gbc);

        //TEMP BUTTON TO REROLL ABILITY SCORES
        reroll = new JButton("Reroll");
        reroll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rogue f = new Rogue();
                f.createLevel1Rogue(r.charName, r.charClass, r.charRace);
                CharacterSheet i = new CharacterSheet(f);
                frame.dispose();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 4;
        panel.add(reroll, gbc);

        featuresTag = new JLabel("Class Features: ");
        featuresTag.setForeground(Color.red);
        gbc.gridx = 4;
        gbc.gridy = 1;
        panel.add(featuresTag, gbc);
        features = new JComboBox(r.classFeatures.toArray());
        gbc.gridx = 4;
        gbc.gridy = 2;
        panel.add(features, gbc);

        checkFeatures = new JButton("Check");
        gbc.gridx = 4;
        gbc.gridy = 3;
        checkFeatures.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = getData.getClassFeaturesDescription((String) features.getSelectedItem());
                JOptionPane.showMessageDialog(frame, description, (String) features.getSelectedItem(), JOptionPane.INFORMATION_MESSAGE);

            }
        });
        panel.add(checkFeatures, gbc);


        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Character Sheet");
        frame.pack();
        frame.setVisible(true);
    }
}
