package com.ask.maryam.game;

import com.ask.maryam.mode.ChallengerMode;
import com.ask.maryam.mode.DefenderMode;
import com.ask.maryam.mode.DualMode;
import com.ask.maryam.mode.Mode;

import java.util.*;

public class MoreAndLessGame extends Game {

    public MoreAndLessGame() {
        this.setName();
    }

    public void setName() {
        this.name = "Plus ou moins";
    }

    public String getName(){
        return name;
    }

    /**
     * Start the less and more game in the challenger mode.
     * @param challMode challenger mode
     */
    @Override
    public void startPlaying(ChallengerMode challMode) {

        //At the beginning, the number of remaining trials is equal to the max trial imposed in the properties file.
        int remainingTrials = params.getTrialNbMax();

        List<Map<Integer, Integer>>  goodPresentNb;
        challMode.playersSelection();
        displayModeMessage(challMode, this.getName());
        List<Integer> secretNbList = challMode.putSecretNumberInList(this.getClass().getSimpleName());

        do{
            List<Integer> proposedNbList = challMode.putProposedNumberInList(this.getClass().getSimpleName());
            goodPresentNb = verificationGoodPresentPlace(secretNbList, proposedNbList, challMode);

            remainingTrials--;
            System.out.println("\nEssais restants: " + remainingTrials + "\n");
        }while (remainingTrials != 0 && goodPresentNb.get(0).size() != secretNbSize);

        winTheGame(challMode, goodPresentNb.get(0).size());
        gameOver(challMode, goodPresentNb.get(0).size());
    }

    /**
     * Start the less and more game in the defender mode.
     * @param defenderMode defender mode
     */
    @Override
    public void startPlaying(DefenderMode defenderMode) {
        List<Map<Integer, Integer>> goodPresentNb;
        int remainingTrials = trialNbMax;
        //At the beginning, the number of remaining trials is equal to the max trial imposed in the properties file.
        defenderMode.playersSelection();
        displayModeMessage(defenderMode, this.getName());
        List<Integer> secretNbList = defenderMode.putSecretNumberInList(this.getClass().getSimpleName());


        List<Integer> proposedNbList = defenderMode.putProposedNumberInList(this.getClass().getSimpleName());
        do{
            goodPresentNb = verificationGoodPresentPlace(secretNbList, proposedNbList, defenderMode);
            remainingTrials--;
            System.out.println("\nEssais restants: " + remainingTrials + "\n");
            proposedNbList = defenderMode.putProposedNumberInListUsingAlgo(goodPresentNb.get(0), goodPresentNb.get(1));
        }while (remainingTrials != 0 && goodPresentNb.get(0).size() != secretNbSize);

        winTheGame(defenderMode, goodPresentNb.get(0).size());
        gameOver(defenderMode, goodPresentNb.get(0).size());

    }

    /**
     * Start the less and more game in the dual mode.
     * @param dualMode dual mode
     */
    @Override
    public void startPlaying(DualMode dualMode) {
        List<Map<Integer, Integer>> goodPresentNb1;
        List<Map<Integer, Integer>> goodPresentNb2;
        int remainingTrials1 = trialNbMax;
        int remainingTrials2 = trialNbMax;

        dualMode.playersSelection();

        System.out.println("\nBonjour, entrez votre nom.");
        Scanner sc = new Scanner(System.in);
        dualMode.getPlayer2().setName(sc.next());

        displayModeMessage(dualMode, this.getName());

        System.out.println("\nJoueur "+ dualMode.getPlayer2().getName() + ": Tapez votre nombre secret de " + secretNbSize + " chiffres: ");
        List<Integer> secretNbList1 = dualMode.putSecretNumberInList(this.getClass().getSimpleName());//joueur
        dualMode.inversePlayersSelection();
        List<Integer> secretNbList2 = dualMode.putSecretNumberInList(this.getClass().getSimpleName());//ordinateur
        dualMode.inversePlayersSelection();
        List<Integer> proposedNbList1 = dualMode.putProposedNumberInList(this.getClass().getSimpleName());
        List<Integer> proposedNbList2;
        System.out.println("\n                                       " + dualMode.getPlayer1().getName() + " joue contre vous.\n");
        goodPresentNb1 = verificationGoodPresentPlace(secretNbList1,proposedNbList1, dualMode);

        do {
            remainingTrials1--;

            System.out.println("\nEssais restants: " + remainingTrials1 + "\n");
            dualMode.inversePlayersSelection();

            System.out.println("                                     " + dualMode.getPlayer1().getName() + ": Vous jouez contre l'ordinateur. Proposez un nombre de " + secretNbSize + " chiffres: \n");
            proposedNbList2 = dualMode.putProposedNumberInList(this.getClass().getSimpleName());

            goodPresentNb2 = verificationGoodPresentPlace(secretNbList2, proposedNbList2, dualMode);
            remainingTrials2--;
            System.out.println("\nEssais restants: " + remainingTrials2 + "\n");
            dualMode.inversePlayersSelection();

            if((remainingTrials1 > 0 &&  remainingTrials2 > 0) && (goodPresentNb1.get(0).size() != secretNbSize && goodPresentNb2.get(0).size() != secretNbSize)) {
                System.out.println("\n                                       " + dualMode.getPlayer1().getName() + " joue contre vous.\n");
                proposedNbList1 = dualMode.putProposedNumberInListUsingAlgo(goodPresentNb1.get(0), goodPresentNb1.get(1));
                goodPresentNb1 = verificationGoodPresentPlace(secretNbList1,proposedNbList1, dualMode);
            }

        } while ((remainingTrials1 > 0 &&  remainingTrials2 > 0) && (goodPresentNb1.get(0).size() != secretNbSize && goodPresentNb2.get(0).size() != secretNbSize));

        if(goodPresentNb1.get(0).size() == secretNbSize){
            winTheGame(dualMode, goodPresentNb1.get(0).size(), dualMode.getPlayer1());
        } else if(goodPresentNb2.get(0).size() == secretNbSize){
            winTheGame(dualMode, goodPresentNb2.get(0).size(), dualMode.getPlayer2());
        } else if (goodPresentNb1.get(0).size() != secretNbSize && goodPresentNb2.get(0).size() != secretNbSize){
            gameOver(dualMode, goodPresentNb1.get(0).size(), goodPresentNb2.get(0).size());
        }
    }

    /**
     * Verification of the number of digit which are in the good place and the number of digits which are present. Call of the methods
     * goodPlace and goodNumber.
     * @param secretNbList the list containing each digit of the secret number
     * @param proposedNbList the list containing each digit of the proposed number
     * @param mode game mode
     * @return A list containing two maps, a map with the good digits and a map with the present digits.
     */
    @Override
    public List<Map<Integer, Integer>> verificationGoodPresentPlace(List<Integer> secretNbList, List<Integer> proposedNbList, Mode mode){
        List<Map<Integer, Integer>> goodPresentNb = new ArrayList<>();
        goodPresentNb.add(0, goodPlace(secretNbList, proposedNbList, mode));
        goodPresentNb.add(1,goodNumber(secretNbList, proposedNbList));
        return goodPresentNb;
    }

    /**
     * Comparison digit by digit, of the secret number and the proposed number, and recovery of all
     * digits of the proposed number which are good and those which aren't good.
     * @param secretNbList the list containing each digit of the secret number
     * @param proposedNbList the list containing each digit of the proposed number
     * @return A map of integer containing as the values, the digits which are in the good place and their position as key.
     */
    @Override
    public Map<Integer, Integer> goodPlace(List<Integer> secretNbList, List<Integer> proposedNbList, Mode mode){

        List<String> moreAndLessTable = new ArrayList<>();
        Map<Integer, Integer> nbOfGoodPlaceList = new HashMap<>();

        for(int i=0; i<secretNbSize; i++){
            if(secretNbList.get(i) == proposedNbList.get(i)){
                moreAndLessTable.add(i, "=");
                nbOfGoodPlaceList.put(i, proposedNbList.get(i));
            } else if (secretNbList.get(i) >= proposedNbList.get(i)){
                moreAndLessTable.add(i, "+");
            } else if (secretNbList.get(i) <= proposedNbList.get(i)) {
                moreAndLessTable.add(i, "-");
            }
        }

        answerMessage(mode, moreAndLessTable);
        return nbOfGoodPlaceList;
    }


    /**
     * Comparison digit by digit , of the secret number and the proposed number, and recovery of all
     * digits of the proposed number which are present (but not in the good palce) as well their position.
     * @param secretNbList the list containing each digit of the secret number
     * @param proposedNbList the list containing each digit of the proposed number
     * @return A map of integer containing as the values, the digits which are present but not ine the good place and their position as key.
     */
    public Map<Integer,  Integer> goodNumber(List<Integer> secretNbList, List<Integer> proposedNbList){
        Map<Integer, Integer> nbOfPresentNbList = new HashMap<>();
        for(int i=0; i<secretNbSize; i++){
            if(secretNbList.contains(proposedNbList.get(i))&& proposedNbList.get(i) != secretNbList.get(i)){
                nbOfPresentNbList.put(i, proposedNbList.get(i));
            }
        }
        return nbOfPresentNbList;
    }

    /**
     * This is the message that appears after the player or computer makes a proposal. It displays a + if the digit of the proposed number is smaller,
     * a - if the digit is bigger and a = if it's the good digit.
     * @param mode game mode, as we need to display the secret and the proposed number, we need to know what is the game mode to retrieve them.
     * @param moreAndLessTable ArrayList which contains the + - =.
     */
    public void answerMessage(Mode mode, List<String> moreAndLessTable ){
        displaySecretNb(isDevMode, mode);
        System.out.print("Proposition   : " + mode.getProposedNb() + " -> Réponse : ");
        for(String place : moreAndLessTable){
            System.out.print(place);
        }
        moreAndLessTable.clear();
    }
}
