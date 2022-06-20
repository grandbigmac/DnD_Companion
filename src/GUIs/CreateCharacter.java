package GUIs;

import Classes.Rogue;

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
    ArrayList<String> classes = new ArrayList<String>(Arrays.asList("Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk",
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
                    CharacterSheet i = new CharacterSheet(r);
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