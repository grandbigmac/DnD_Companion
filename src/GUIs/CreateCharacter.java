package GUIs;

import Classes.*;
import Classes.Barbarian;
import GUIs.LEVEL1.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class CreateCharacter {
    JFrame frame;
    JPanel panel;
    JLabel title, charName, charRace, charClass;
    JTextField nameTF;
    JButton createRandom, createChoose;
    JComboBox<String> raceCB, classCB;
    ArrayList<String> classes = new ArrayList<String>(Arrays.asList("Barbarian", "Bard", "Cleric", "Druid", "Barbarian", "Monk",
            "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"));
    ArrayList<String> races = new ArrayList<String>(Arrays.asList("Dragonborn", "Dwarf", "Elf", "Gnome", "Half-Elf", "Halfling",
           "Half-Orc", "Human", "Tiefling"));
    GridBagConstraints gbc = new GridBagConstraints();

    public CreateCharacter() {

        frame = new JFrame();
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(5, 5, 5, 5);

        title = new JLabel("Create a new Character");
        title.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        charName = new JLabel("Name: ");
        charName.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(charName, gbc);
        nameTF = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx =1;
        panel.add(nameTF, gbc);

        charRace = new JLabel("Race: ");
        charRace.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(charRace, gbc);
        raceCB = new JComboBox(races.toArray());
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx =1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(raceCB, gbc);

        charClass = new JLabel("Class: ");
        charClass.setForeground(Color.red);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(charClass, gbc);
        classCB = new JComboBox(classes.toArray());
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx =1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(classCB, gbc);

        createRandom = new JButton("Create Character with Random Ability Scores");
        System.out.println(raceCB.getSelectedItem().toString());
        createRandom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (classCB.getSelectedItem().toString() == "Rogue") {
                    Rogue r = new Rogue();
                    r.createLevel1Rogue(nameTF.getText(), classCB.getSelectedItem().toString(), raceCB.getSelectedItem().toString());
                    Rogue1CharacterSheet i = new Rogue1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB.getSelectedItem().toString() == "Barbarian") {
                    Barbarian r = new Barbarian();
                    r.createLevel1Barbarian(nameTF.getText(), classCB.getSelectedItem().toString(), raceCB.getSelectedItem().toString());
                    Barbarian1CharacterSheet i = new Barbarian1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB.getSelectedItem().toString() == "Barbarian") {
                    Barbarian r = new Barbarian();
                    r.createLevel1Barbarian(nameTF.getText(), classCB.getSelectedItem().toString(), raceCB.getSelectedItem().toString());
                    Barbarian1CharacterSheet i = new Barbarian1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB.getSelectedItem().toString() == "Bard") {
                    Bard r = new Bard();
                    r.createLevel1Bard(nameTF.getText(), classCB.getSelectedItem().toString(), raceCB.getSelectedItem().toString());
                    Bard1CharacterSheet i = new Bard1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB.getSelectedItem().toString() == "Cleric") {
                    Cleric r = new Cleric();
                    r.createLevel1Cleric(nameTF.getText(), classCB.getSelectedItem().toString(), raceCB.getSelectedItem().toString());
                    Cleric1CharacterSheet i = new Cleric1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB.getSelectedItem().toString() == "Druid") {
                    Druid r = new Druid();
                    r.createLevel1Druid(nameTF.getText(), classCB.getSelectedItem().toString(), raceCB.getSelectedItem().toString());
                    Druid1CharacterSheet i = new Druid1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB.getSelectedItem().toString() == "Monk") {
                    Monk r = new Monk();
                    r.createLevel1Monk(nameTF.getText(), classCB.getSelectedItem().toString(), raceCB.getSelectedItem().toString());
                    Monk1CharacterSheet i = new Monk1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB.getSelectedItem().toString() == "Paladin") {
                    Paladin r = new Paladin();
                    r.createLevel1Paladin(nameTF.getText(), classCB.getSelectedItem().toString(), raceCB.getSelectedItem().toString());
                    Paladin1CharacterSheet i = new Paladin1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB.getSelectedItem().toString() == "Ranger") {
                    Ranger r = new Ranger();
                    r.createLevel1Ranger(nameTF.getText(), classCB.getSelectedItem().toString(), raceCB.getSelectedItem().toString());
                    Ranger1CharacterSheet i = new Ranger1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB.getSelectedItem().toString() == "Sorcerer") {
                    Sorcerer r = new Sorcerer();
                    r.createLevel1Sorcerer(nameTF.getText(), classCB.getSelectedItem().toString(), raceCB.getSelectedItem().toString());
                    Sorcerer1CharacterSheet i = new Sorcerer1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB.getSelectedItem().toString() == "Warlock") {
                    Warlock r = new Warlock();
                    r.createLevel1Warlock(nameTF.getText(), classCB.getSelectedItem().toString(), raceCB.getSelectedItem().toString());
                    Warlock1CharacterSheet i = new Warlock1CharacterSheet(r);
                    frame.dispose();
                }

                else if (classCB.getSelectedItem().toString() == "Wizard") {
                    Wizard r = new Wizard();
                    r.createLevel1Wizard(nameTF.getText(), classCB.getSelectedItem().toString(), raceCB.getSelectedItem().toString());
                    Wizard1CharacterSheet i = new Wizard1CharacterSheet(r);
                    frame.dispose();
                }



            }
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(createRandom, gbc);

        createChoose = new JButton("Create Character with Chosen Ability Scores");
        createChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbilityScoreChoice r = new AbilityScoreChoice(nameTF.getText(), classCB.getSelectedItem().toString(), raceCB.getSelectedItem().toString());
                frame.dispose();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(createChoose, gbc);





        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Create Character");
        frame.pack();
        frame.setVisible(true);
    }
}

//WHEN YOU GET BACK:
//ur making a temporary gui for instancing a new character with a race and a class at level 1