package com.ask.maryam.game;

import com.ask.maryam.mode.ChallengerMode;
import com.ask.maryam.mode.DefenderMode;
import com.ask.maryam.mode.DualMode;
import com.ask.maryam.mode.Mode;

import java.util.*;


public class MastermindGame extends Game {

    public MastermindGame() {
        this.setName();
    }

    public void setName() {
        this.name = "Mastermind";
    }

    public String getName(){
        return name;
    }

    /**
     * Start the Mastermind game in the challenger mode.
     * @param challMode challenger mode
     */
   @Override
   public void startPlaying(ChallengerMode challMode) {

       //At the beginning, the number of remaining trials is equal to the max trial imposed in the properties file.
       int remainingTrials = trialNbMax;
       List<Map<Integer, Integer>>  goodPresentNb;

       challMode.playersSelection();
       displayModeMessage(challMode, this.getName()); // Display a message indicated in which game and mode we are.

       /*
         Here it's the computer which sets a secret number.
         We can see it in the Challenger mode class.
        */
       List<Integer> secretNbList = challMode.putSecretNumberInList(this.getClass().getSimpleName());

       /*
          The human player sets each time a proposed number until he finds the good one
          or he has finished all his trials.
        */
       do{
           List<Integer> proposedNbList = challMode.putProposedNumberInList(this.getClass().getSimpleName());
           goodPresentNb = verificationGoodPresentPlace(secretNbList, proposedNbList, challMode);
           answerMessage(goodPresentNb.get(0).size(), goodPresentNb.get(1).size(), challMode);
           remainingTrials--;
           System.out.println("Essais restants: " + remainingTrials + "\n");
       }while (remainingTrials != 0 && goodPresentNb.get(0).size() != secretNbSize);

       winTheGame(challMode, goodPresentNb.get(0).size());
       gameOver(challMode, goodPresentNb.get(0).size());

   }

    /**
     * Start the Mastermind game in the defender mode.
     * @param defenderMode defender mode
     */
   @Override
   public void startPlaying(DefenderMode defenderMode) {

       //At the beginning, the number of remaining trials is equal to the max trial imposed in the properties file.
       int remainingTrials = trialNbMax;
       List<Map<Integer, Integer>> goodPresentNb;

       defenderMode.playersSelection();
       displayModeMessage(defenderMode, this.getName());

       /*
         Here it's the human player who sets a secret number.
         We can see it in the Defender mode class.
        */
       List<Integer> secretNbList = defenderMode.putSecretNumberInList(this.getClass().getSimpleName());

       /*
         The computer has to guess the secret number. For the first proposal, the computer set a proposed
         number using a random method.
        */
       List<Integer> proposedNbList = defenderMode.putProposedNumberInList(this.getClass().getSimpleName());

       /*
          Then the computer sets each time a proposed number until he finds the good one
          or he has finished all his trials. But this time, the computer set a proposed number by using an algorithm based on
          the previous proposition.
        */
       do{
           goodPresentNb = verificationGoodPresentPlace(secretNbList, proposedNbList, defenderMode);
           answerMessage(goodPresentNb.get(0).size(), goodPresentNb.get(1).size(), defenderMode);
           remainingTrials--;
           System.out.println("Essais restants: " + remainingTrials + "\n");

           /*
             For the next proposed number, the computer uses an algorithm based on
             the previous proposition.
           */
           proposedNbList = defenderMode.putProposedNumberInListUsingAlgo(goodPresentNb.get(0), goodPresentNb.get(1));

       }while (remainingTrials != 0 && goodPresentNb.get(0).size() != secretNbSize);

       winTheGame(defenderMode, goodPresentNb.get(0).size());
       gameOver(defenderMode, goodPresentNb.get(0).size());
    }


    /**
     * Start the Mastermind game in the dual mode.
     * @param dualMode dual mode
     */
   @Override
   public void startPlaying(DualMode dualMode) {

       /*
         Computer and human player play in turn.
         so each one has his own trials.
       */
       int remainingTrials1 = trialNbMax;
       int remainingTrials2 = trialNbMax;
       List<Map<Integer, Integer>> goodPresentNb1;
       List<Map<Integer, Integer>> goodPresentNb2;


       dualMode.playersSelection();

       System.out.println("\nBonjour, entrez votre nom.");  // The player2 which is the human player (Mode Dual), has to enter his name.
       Scanner sc = new Scanner(System.in);
       dualMode.getPlayer2().setName(sc.next());

       displayModeMessage(dualMode,this.getName());

       // Concerns player2, the human player.
       System.out.println("\nJoueur "+ dualMode.getPlayer2().getName() + ": Tapez votre nombre secret de " + secretNbSize + " chiffres: ");

       // Concerns player2, the human player. See Dual mode class.
       List<Integer> secretNbList1 = dualMode.putSecretNumberInList(this.getClass().getSimpleName());

       // We inverse the selection, player2 becomes player1 and player1 becomes palyer2.
       dualMode.inversePlayersSelection();

       // Concerns the computer.
       List<Integer> secretNbList2 = dualMode.putSecretNumberInList(this.getClass().getSimpleName());

       // We inverse again the selection, player2 becomes player1 and player1 becomes player2.
       dualMode.inversePlayersSelection();

       //Concerns the computer which sets his first proposed number using the random method.
       List<Integer> proposedNbList1 = dualMode.putProposedNumberInList(this.getClass().getSimpleName());


       List<Integer> proposedNbList2;

       // At this step, the player1 is the computer, it begins the game.
       System.out.println("\n                                       " + dualMode.getPlayer1().getName() + " joue contre vous.\n");

       // First comparison between the player secret number and the computer propsoed number.
       goodPresentNb1 = verificationGoodPresentPlace(secretNbList1,proposedNbList1, dualMode);
       answerMessage(goodPresentNb1.get(0).size(), goodPresentNb1.get(1).size(), dualMode);

       /*
            We put a loop in which each player sets a proposed number in turns until one of them win the game
            or the two finished all their trials.
        */

       do {
           remainingTrials1--;

           System.out.println("Essais restants: " + remainingTrials1 + "\n");
           dualMode.inversePlayersSelection();

           System.out.println("                                     " + dualMode.getPlayer1().getName() + ": Vous jouez contre l'ordinateur. Proposez un nombre de " + secretNbSize + " chiffres: \n");
           proposedNbList2 = dualMode.putProposedNumberInList(this.getClass().getSimpleName());

           goodPresentNb2 = verificationGoodPresentPlace(secretNbList2, proposedNbList2, dualMode);
           answerMessage(goodPresentNb2.get(0).size(), goodPresentNb2.get(1).size(), dualMode);
           remainingTrials2--;
           System.out.println("Essais restants: " + remainingTrials2 + "\n");
           dualMode.inversePlayersSelection();

           /*
             We put a condition here, if the previous player found the secret number, we stop the play.
             If we don't put his condition, the next player plays an additional round even if
             the previous player has found the secret number.
           */
           if((remainingTrials1 > 0 &&  remainingTrials2 > 0) && (goodPresentNb1.get(0).size() != secretNbSize && goodPresentNb2.get(0).size() != secretNbSize)) {
               System.out.println("\n                                       " + dualMode.getPlayer1().getName() + " joue contre vous.\n");
               proposedNbList1 = dualMode.putProposedNumberInListUsingAlgo(goodPresentNb1.get(0), goodPresentNb1.get(1));
               goodPresentNb1 = verificationGoodPresentPlace(secretNbList1,proposedNbList1, dualMode);
               answerMessage(goodPresentNb1.get(0).size(), goodPresentNb1.get(1).size(), dualMode);
           }

       } while ((remainingTrials1 > 0 &&  remainingTrials2 > 0) && (goodPresentNb1.get(0).size() != secretNbSize && goodPresentNb2.get(0).size() != secretNbSize));


       /*
            Verify who wins the game.
       */
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
     * digits of the proposed number which are in the good place, as well their position.
     * @param secretNbList the list containing each digit of the secret number
     * @param proposedNbList the list containing each digit of the proposed number
     * @return A map of integer containing as the values, the digits which are in the good place and their position as key.
     */
    @Override
    public Map<Integer,  Integer> goodPlace(List<Integer> secretNbList, List<Integer> proposedNbList, Mode mode){
        Map<Integer, Integer> nbOfGoodPlaceList = new HashMap<>();

        for(int i=0; i<secretNbSize; i++){
            if(secretNbList.get(i) == proposedNbList.get(i)){
                nbOfGoodPlaceList.put(i, secretNbList.get(i));
            }
        }
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
     * This is the message that appears after the player or computer makes a proposal. It indicates the number of digits
     * which are in the good place, and the number of digits which are present.
     * @param nbOfGoodPlace the number of digits which are in the good place.
     * @param nbOfPresentNb the number of digits which are present.
     * @param mode game mode, as we need to display the secret and the proposed number, we need to know what is the game mode to retrieve them.
     */
    public void answerMessage(int nbOfGoodPlace, int nbOfPresentNb, Mode mode ){

        String goodPresentPlaces [][] = {{"présents","présent"},{"placé","placés"}};

        String present="";
        String place="";
        displaySecretNb(isDevMode, mode);
        System.out.print("Proposition   : " + mode.getProposedNb() + " -> Réponse : ");


        if(nbOfGoodPlace > 1) {
            if(nbOfPresentNb > 1){
                present = goodPresentPlaces[0][0];
                place = goodPresentPlaces[1][1];
                System.out.print(nbOfPresentNb + " " + present + ", " + nbOfGoodPlace + " bien " + place + "\n");


            } else if(nbOfPresentNb == 1) {
                present = goodPresentPlaces[0][1];
                place = goodPresentPlaces[1][1];
                System.out.print(nbOfPresentNb + " " + present + ", " + nbOfGoodPlace + " bien " + place + ".\n");

            } else if(nbOfPresentNb == 0) {
                place = goodPresentPlaces[1][1];
                System.out.print(nbOfPresentNb + ", " + nbOfGoodPlace + " bien " + place + ".\n");
            }

        } else if(nbOfGoodPlace == 1) {
            if (nbOfPresentNb > 1) {
                present = goodPresentPlaces[0][0];
                place = goodPresentPlaces[1][0];
                System.out.print(nbOfPresentNb + " " + present + ", " + nbOfGoodPlace + " bien " + place + ".\n");

            }else if (nbOfPresentNb == 1){
                present = goodPresentPlaces[0][1];
                place = goodPresentPlaces[1][0];
                System.out.print(nbOfPresentNb + " " + present + ", " + nbOfGoodPlace + " bien " + place + ".\n");

            } else if(nbOfPresentNb == 0){
                place = goodPresentPlaces[1][0];
                System.out.print(nbOfGoodPlace + " bien " + place + ".\n");
            }

        }else if(nbOfGoodPlace == 0)
            if(nbOfPresentNb > 1){
                present = goodPresentPlaces[0][0];
                System.out.print(nbOfPresentNb + " " + present + ".\n");

            } else if(nbOfPresentNb == 1){
                present = goodPresentPlaces[0][1];
                System.out.print(nbOfPresentNb + " " + present + ".\n");

            } else if(nbOfPresentNb == 0){
                present = goodPresentPlaces[0][1];
                place = goodPresentPlaces[1][0];
                System.out.print(nbOfPresentNb + " " + present + ", " + nbOfGoodPlace + " bien " + place + ".\n");
            }
    }
}
