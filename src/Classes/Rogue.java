package Classes;

import Character_Package.Character;
import Dice_Rolls.DiceRolls;

import java.util.ArrayList;
import java.util.Collections;

public class Rogue extends Character {
    public ArrayList<String> classFeatures = new ArrayList<>();

    void Character(){

    }

    public Rogue() {
        charClass = "Rogue";

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

        //Setting base armour class
        int mod = findModifier(dexterity);
        armourClass = baseAC + mod;
        if (armourClass < 10) {
            armourClass = 10;
        }
    }

    public void createLevel1Rogue(String cName, String cClass, String cRace) {
        //SET LEVEL
        charLevel = 1;
        charName = cName;
        charClass = cClass;
        charRace = cRace;

        //SET STARTING HEALTH
        int mod = findModifier(constitution);
        healthPoints = 8 + mod;
        if (healthPoints < 8) {
            healthPoints = 8;
        }

        //ADDING LEVEL 1 FEATURES
        classFeatures.add("Expertise 1");
        classFeatures.add("Sneak Attack 1");
        classFeatures.add("Thieves Cant");

    }

}
