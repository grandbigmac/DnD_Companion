package Dice_Rolls;

public class DiceRolls {
    public static int rollD4() {

        double roll = Math.random() * 5;
        int convertedRoll = (int) roll;

        return convertedRoll;
    }

    public static int rollD6() {

        double roll = Math.random() * 7;
        int convertedRoll = (int) roll;

        return convertedRoll;
    }

    public static int rollD8() {

        double roll = Math.random() * 9;
        int convertedRoll = (int) roll;

        return convertedRoll;
    }

    public static int rollD10() {

        double roll = Math.random() * 11;
        int convertedRoll = (int) roll;

        return convertedRoll;
    }

    public static int rollD12() {

        double roll = Math.random() * 13;
        int convertedRoll = (int) roll;

        return convertedRoll;
    }

    public static int rollD20() {

        double roll = Math.random() * 21;
        int convertedRoll = (int) roll;

        return convertedRoll;
    }

    public static int rollD100() {

        double roll = Math.random() * 101;
        int convertedRoll = (int) roll;

        return convertedRoll;
    }
}
