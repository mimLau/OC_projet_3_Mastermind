package com.ask.maryam.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    /**
     *  Method to get a random integer between 0 and the given number.
     * @param max the maximal integer we want.
     * @return random integer between 0 and the given number.
     */
    public static int getRandom(int max){
        return (int) (Math.random()*max);
    }


    /**
     * @param word the String that we want to verify if it has single characters.
     * @return true if the String has single characters.
     */
    public static boolean hasAllUniqueChars (String word) {
        for(int i=0; i< word.length(); i++)   {
            char c =word.charAt(i);
            if(word.indexOf(c)!= word.lastIndexOf(c))
                return false;
        }
        return true;
    }

    /**
     * Put each characters of a String in a List of Integer. In the project, the StringToConvert is composed by digits.
     * @param stringToConvert
     * @return a list with numbers.
     */
    public static List<Integer> stringToList(String stringToConvert){
        List<Integer> nbList = new ArrayList<>();
        for (int i = 0; i < stringToConvert.length(); i++) {
            nbList.add(i, Character.getNumericValue(stringToConvert.charAt(i)));
        }
        return nbList;
    }

    /**
     * Retrieve a number entered on the keyboard.
     *  We verify in the same time if the size of the entered number respects the secret's number size
     *  and if it has single digits.
     * @param secretNbSize the size of the secret number.
     * @return the entered number in String type..
     */
    public static String enterNumber(int secretNbSize){

        Scanner sc = new Scanner(System.in);
        boolean nbWithUniqueDigit;
        String numberInString;

        do{
            numberInString = sc.next();

            if(numberInString.length() != secretNbSize)
                System.out.println("Choisissez un nombre à " + secretNbSize + " chiffres.");

            nbWithUniqueDigit = Utils.hasAllUniqueChars(numberInString);

            if(!nbWithUniqueDigit)
                System.out.println("Veuillez saisir un nombre avec des chiffres uniques.");

        }while(numberInString.length()!= secretNbSize || !nbWithUniqueDigit);

        return numberInString;
    }


    /**
     * Method reserved to the computerPlayer.
     * The secret number or the proposed number size must be equal to the secretNbSize parameter.
     * Each secret or proposed number's digit must be in the range imposed by the parameter maxUsableDigit.
     * Generate a random number for each digit of the secret number or proposed number, and append them one by one.
     * For that a StringBuilder is necessary.

     * @param secretNbSize size of the secret number.
     * @param getMaxUsableDigit It's the maximal digit (which is indicated in the Parameters class) that we can use for the secret number or the  proposed number.
     * @return A string with a random number with a given size (inferior than the secret number size) and with digits inferior or equal to the maximal usable digit.
     */
    public static String getRandomNumber( int secretNbSize,int getMaxUsableDigit ){
        StringBuilder stbuild = new StringBuilder();
        for(int i=0; i< secretNbSize; i++) {

            int randonNumber = Utils.getRandom(getMaxUsableDigit + 1); //Generate un random number between 0 and the maximal usable digit, and put it in a StringBuilder.

            if(stbuild.toString().contains(String.valueOf(randonNumber))) //Verify if the random digit already exists in the stbuild. If yes, we add an additional round in the loop.
                i = i-1;
            else
                stbuild.append(randonNumber);

            /* We don't want a secret number beginning by zero so we verify if it is the case.
               If it is, empty the StringBuilder and put additional round to the loop.
             */

            if(i==0){
                if(stbuild.toString().equals("0")){
                    stbuild.setLength(0);
                    i=i-1;
                }
            }
        }
        return String.valueOf(stbuild);
    }
}
