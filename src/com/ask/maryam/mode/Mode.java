package com.ask.maryam.mode;

import com.ask.maryam.Utils.Utils;
import com.ask.maryam.parameters.Parameters;
import com.ask.maryam.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Mode {
    protected Player player1;
    protected Player player2;
    protected String name;
    protected String secretNb;
    protected String proposedNb;
    protected List<Integer> proposedNbList = new ArrayList<>();
    protected List<Integer> secretNbList = new ArrayList<>();

    Parameters params = Parameters.INSTANCE;


    private final static String MASTERMINDGAME = "MastermindGame";

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public String getSecretNb() {
        return secretNb;
    }

    public String getProposedNb() {
        return proposedNb;
    }

    public String getName() {
        return name;
    }

    public abstract void playersSelection();
    public abstract List <Integer> putSecretNumberInList(String gameName);
    public abstract List <Integer> putProposedNumberInList(String gameName);


    /**
     * Put the proposed number of the player or the computer in a list for being compared
     * digit by digit with the secret number.
     * @param gameName The name of the game. If the game name is Mastermind, as  this game has an additional constraint,
     * we verify here if the proposed number respects the maximal usable digit imposed in the config.properties file.
     * If it doesn't respect the constraint, a message is displayed.
     * @param player The player who is playing (human player or computer)
     * @return
     */
    public List<Integer> putPropNbInListCondition(String gameName, Player player){
        int maxUsableDigit = params.getMaxUsableDigit();
        List<Integer> proposedNbList;
        boolean isMaximalDigitOk;
        
        if(gameName.equals(MASTERMINDGAME)) {
            do {
                player.setProposedNb();
                isMaximalDigitOk = maximalUsableDigitOk(player.getProposedNb(), maxUsableDigit);
                if (!isMaximalDigitOk)
                    System.out.println("Choisissez un nombre avec des chiffres compris entre 0 et " + maxUsableDigit + ".");


            } while (isMaximalDigitOk == false);
        }else  player.setProposedNb();

        proposedNbList = Utils.stringToList(player.getProposedNb());

        return proposedNbList;
    }

    /**
     * Put the secret number of the player or the computer in a list for being compared
     * digit by digit with the proposed number.
     * @param gameName The name of the game. If the game name is Mastermind, as  this game has an additional constraint,
     * we verify here if the secret number respects the maximal usable digit imposed in the config.properties file.
     * If it doesn't respect the constraint, a message is displayed.
     * @param player The player who is playing (human player or computer)
     * @return
     */
    public List<Integer> putSecretNbInListCondition(String gameName, Player player){
        int maxUsableDigit = params.getMaxUsableDigit();
        List<Integer> secretNbList;
        boolean isMaximalDigitOk;

        if(gameName.equals(MASTERMINDGAME)) {
            do {
                player.setSecretNb();
                isMaximalDigitOk = maximalUsableDigitOk(player.getSecretNb(), maxUsableDigit);
                if (!isMaximalDigitOk)
                    System.out.println("Choisissez un nombre avec des chiffres compris entre 0 et " + maxUsableDigit + ".");


            } while (isMaximalDigitOk == false);
        }else  player.setSecretNb();

        secretNbList = Utils.stringToList(player.getSecretNb());

        return secretNbList;
    }

    /**
     * Verify if the secret number o the proposed number respects the condition of maximal usable digits
     * imposed in the config.properties file.
     * @param playerNumber The number proposed by the player or the computer.
     * @param maxUsableDigit
     * @return true if the proposed number or the secret number respects the condition of maximal usable digits.
     */
    private boolean maximalUsableDigitOk(String playerNumber, int maxUsableDigit){
        boolean isMaximalDigitOk = false;
        for(int i=0; i<playerNumber.length(); i++){
            if(Character.getNumericValue(playerNumber.charAt(i)) > maxUsableDigit){
                i= playerNumber.length();
                isMaximalDigitOk= false;
            }
            else {
                isMaximalDigitOk= true;
            }
        }
        return isMaximalDigitOk;
    }



    /**
     * Put the computer proposed number in list for being compared. This time, the proposed number is set from an algorithm
     * based on  the first proposition of the computer.
     * @param goodPlace A map with the numbers in the good place and their index.
     * @param goodNb A map with the good numbers but not at the good place and their index.
     * @return A list of Integer with the computer proposed number. Each digit of the proposed  number in a cell of the list.
     */
    public List<Integer> putProposedNumberInListUsingAlgo(Map<Integer, Integer> goodPlace, Map<Integer, Integer> goodNb) {
        player1.setProposedNb(goodPlace, goodNb);
        proposedNbList = Utils.stringToList(player1.getProposedNb());
        return proposedNbList;
    }

}
