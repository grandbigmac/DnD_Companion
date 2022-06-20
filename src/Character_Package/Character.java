package Character_Package;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Character {

    public static String charName, charRace, charClass, charBackground, charAlignment;
    public static int strength, dexterity, constitution, intelligence, wisdom, charisma, healthPoints, charLevel, baseAC = 10, armourClass;
    public ArrayList<String> raceFeatures = new ArrayList<>();

    void Character(){
        //Temporary constructor to generate random ability scores
        //Change it later so player can either use this method, or manually input their ability scores

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
        System.out.println(abilityScoreArray);

        strength = abilityScoreArray.get(0);
        dexterity = abilityScoreArray.get(1);
        constitution = abilityScoreArray.get(2);
        intelligence = abilityScoreArray.get(3);
        wisdom = abilityScoreArray.get(4);
        charisma = abilityScoreArray.get(5);
    }

    //METHODS FOR SETTING ABILITY SCORES
    // _________________________________________________________
    // _________________________________________________________
    public void setStrength(int i){
        strength = i;
    }

    public void setDexterity(int i){
        dexterity = i;
    }

    public void setConstitution(int i){
        constitution = i;
    }

    public void setIntelligence(int i){
        intelligence = i;
    }

    public void setWisdom(int i){
        wisdom = i;
    }

    public void setCharisma(int i){
        charisma = i;
    }

    public int findModifier(int i) {
        int modifier = 0;

        switch (i) {
            case 1:
                modifier = -5;
                break;
            case 2, 3:
                modifier = -4;
                break;
            case 4, 5:
                modifier = -3;
                break;
            case 6, 7:
                modifier = -2;
                break;
            case 8, 9:
                modifier = -1;
                break;
            case 10, 11:
                modifier = 0;
                break;
            case 12, 13:
                modifier = 1;
                break;
            case 14, 15:
                modifier = 2;
                break;
            case 16, 17:
                modifier = 3;
                break;
            case 18, 19:
                modifier = 4;
                break;
            case 20, 21:
                modifier = 5;
                break;
            case 22, 23:
                modifier = 6;
                break;
        }

        return modifier;
    }
    // _________________________________________________________
    // _________________________________________________________

    // METHODS FOR SETTING CHARACTER DETAILS
    // _________________________________________________________
    // _________________________________________________________
    public void setCharName(String i) {
        charName = i;
    }

    public void setCharRace(String i) {
        charRace = i;
    }

    public void setCharClass(String i) {
        charClass = i;
    }

    public void setCharBackground(String i) {
        charBackground = i;
    }

    public void setCharAlignment(String i) {
        charAlignment = i;
    }
    // _________________________________________________________
    // _________________________________________________________
}
