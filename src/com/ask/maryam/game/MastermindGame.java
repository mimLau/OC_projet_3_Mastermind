package com.ask.maryam.game;

import com.ask.maryam.mode.ChallengerMode;
import com.ask.maryam.mode.DefenderMode;
import com.ask.maryam.mode.DualMode;
import com.ask.maryam.mode.Mode;
import com.ask.maryam.parameters.Parameters;

import java.util.List;

public class MastermindGame implements Game{
   private int nbOfGoodPlace = 0;
   private int nbOfPresentNb = 0;
   private Mode mode;
   private Parameters params= new Parameters();

   int secretNbSize = params.getSecretNbSize();
   int maxUsableDigit = params.getMaxUsableDigit();
   int trialNbMax = params.getTrialNbMax();

   public MastermindGame() {}

   public void setMode(Mode mode) {
      this.mode = mode;
   }

   /**
    *
    * @param secretNb
    * @param proposedNb
    * @return
    */
   public int goodPlace(List<Integer> secretNb, List<Integer> proposedNb){

       nbOfGoodPlace = 0;
      for(int i=0; i<secretNbSize; i++){
         if(secretNb.get(i) == proposedNb.get(i)){
            nbOfGoodPlace++;
         }
      }
      return nbOfGoodPlace;
   }

   /**
    *
    * @param secretNb
    * @param proposedNb
    * @return
    */
   public int goodNumber(List<Integer> secretNb, List<Integer> proposedNb){
       nbOfPresentNb = 0;
      for(int i=0; i<secretNbSize; i++){
            if(secretNb.contains(proposedNb.get(i))&& proposedNb.get(i) != secretNb.get(i)){
            nbOfPresentNb++;
         }
      }
      return nbOfPresentNb;
   }

   /**
    *
    */
   public void startWelcomeMessage() {
       System.out.println("\n********** Bienvenue dans le jeu Mastermind **********\n");
   }

   /**
    *
    * @param challMode
    */
   @Override
   public void startPlaying(ChallengerMode challMode) {

      System.out.println("Vous avez choisi le mode CHALLENGER, vous devez deviner le nombre secret de l'ordinateur.");
      System.out.println("Tapez un nombre de " + secretNbSize + " chiffres.");
      System.out.println("Vous pouvez choisir les chiffres allant de 0 à " + maxUsableDigit +".");
      List<Integer> computerSecretNbList = challMode.putComputerSecretNbInList();
      do {

         List<Integer> playerProposedNbList = challMode.putPlayerProposedNbInList();

         nbOfGoodPlace = goodPlace(computerSecretNbList, playerProposedNbList);
         nbOfPresentNb = goodNumber(computerSecretNbList, playerProposedNbList);

         answerMessage(nbOfGoodPlace, nbOfPresentNb, challMode);

         trialNbMax--;

         System.out.println(playerProposedNbList);
         System.out.println(computerSecretNbList);

      }while(trialNbMax!=0 || nbOfGoodPlace == secretNbSize);

      // need computer secret nb table
      // need scan method for retrieving player proposed number transformed in a table
      // who tour is it
   }

   /**
    *
    * @param nbOfGoodPlace
    * @param nbOfPresentNb
    * @param challMode
    */
   public void answerMessage(int nbOfGoodPlace, int nbOfPresentNb, ChallengerMode challMode ){

      if(nbOfGoodPlace > 1) {

         if(nbOfPresentNb > 1)
            System.out.println("Proposition : " + challMode.getPlayer().getPlayerProposedNb() + " -> Réponse : "
                    + nbOfPresentNb + " présents, " + nbOfGoodPlace + " bien placés.");
         else if(nbOfPresentNb == 1)
            System.out.println("Proposition : " + challMode.getPlayer().getPlayerProposedNb() + " -> Réponse : "
                    + nbOfPresentNb + " présent, " + nbOfGoodPlace + " bien placés.");
         else if(nbOfPresentNb == 0)
            System.out.println("Proposition : " + challMode.getPlayer().getPlayerProposedNb() + " -> Réponse : "
                    + nbOfGoodPlace + " bien placés.");

      } else if(nbOfGoodPlace == 1) {

         if (nbOfPresentNb > 1)
            System.out.println("Proposition : " + challMode.getPlayer().getPlayerProposedNb() + " -> Réponse : "
                    + nbOfPresentNb + " présents, " + nbOfGoodPlace + " bien placé.");
         else if (nbOfPresentNb == 1)
            System.out.println("Proposition : " + challMode.getPlayer().getPlayerProposedNb() + " -> Réponse : "
                    + nbOfPresentNb + " présent, " + nbOfGoodPlace + " bien placé.");
         else if(nbOfPresentNb == 0)
            System.out.println("Proposition : " + challMode.getPlayer().getPlayerProposedNb() + " -> Réponse : "
                    + nbOfGoodPlace + " bien placé.");

      }else if(nbOfGoodPlace == 0)

            if(nbOfPresentNb > 1)
               System.out.println("Proposition : " + challMode.getPlayer().getPlayerProposedNb() + " -> Réponse : "
                       + nbOfPresentNb + " présents.");
            else if(nbOfPresentNb == 1)
               System.out.println("Proposition : " + challMode.getPlayer().getPlayerProposedNb() + " -> Réponse : "
                       + nbOfPresentNb + " présent.");
            else if(nbOfPresentNb == 0)
               System.out.println("Proposition : " + challMode.getPlayer().getPlayerProposedNb() + " -> Réponse : "
                       + nbOfPresentNb + " présent, " + nbOfGoodPlace + " bien placé.");


   }

   @Override
   public void startPlaying(DefenderMode defenderMode) {

   }

   @Override
   public void startPlaying(DualMode dualMode) {

   }

   @Override
   public void compareNb() {
   }

   @Override
   public String displayResult() {
      return null;
   }

   @Override
   public boolean isGameFinisched() {
      return false;
   }


}
