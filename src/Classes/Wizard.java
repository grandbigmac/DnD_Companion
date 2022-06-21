package Classes;

import Character_Package.Character;
import Dice_Rolls.DiceRolls;
import dbAccess.getData;

import java.util.ArrayList;
import java.util.Collections;

public class Wizard extends Character {
    public ArrayList<String> classFeatures = new ArrayList<>();

    void Character(){

    }

    public Wizard() {
        charClass = "Wizard";

        //Temporary constructor to generate random ability scores
        //Change it later so player can either use this method, or manually input their ability scores
        // _________________________________________________________
        // _________________________________________________________
        ArrayList<Integer> abilityScoreArray = new ArrayList<>();

        for (int j = 0; j < 6; j++)
        {
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
            abilityScoreArray.add(score);
        }
        strength = abilityScoreArray.get(0);
        dexterity = abilityScoreArray.get(1);
        constitution = abilityScoreArray.get(2);
        intelligence = abilityScoreArray.get(3);
        wisdom = abilityScoreArray.get(4);
        charisma = abilityScoreArray.get(5);
        // _________________________________________________________
        // _________________________________________________________

    }

    public void createLevel1Wizard(String cName, String cClass, String cRace) {
        //SET LEVEL
        charLevel = 1;
        charName = cName;
        charClass = cClass;
        charRace = cRace;

        //ADD RACIAL ASI
        racialASI = getData.getRacialASI(charRace);
        racialASI = racialASI.substring(1);
        String[] divisions = racialASI.split(", ");
        for (int i = 0; i < divisions.length; i++) {
            if (divisions[i].equals("STR")) {
                strength = strength + 1;
            }
            else if (divisions[i].equals("DEX")) {
                dexterity = dexterity + 1;
            }
            else if (divisions[i].equals("CON")) {
                constitution = constitution + 1;
            }
            else if (divisions[i].equals("INT")) {
                intelligence = intelligence + 1;
            }
            else if (divisions[i].equals("WIS")) {
                wisdom = wisdom + 1;
            }
            else if (divisions[i].equals("CHA")) {
                charisma = charisma + 1;
            }
        }

        //SET STARTING HEALTH
        int mod = findModifier(constitution);
        healthPoints = 6 + mod;
        if (healthPoints < 6) {
            healthPoints = 6;
        }

        //Setting base armour class
        mod = findModifier(dexterity);
        armourClass = baseAC + mod;
        if (armourClass < 10) {
            armourClass = 10;
        }

        //ADDING LEVEL 1 FEATURES
        classFeatures.add("Spellcasting");
        classFeatures.add("Arcane Recovery");




    }

}
