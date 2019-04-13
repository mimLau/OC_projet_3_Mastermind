package com.ask.maryam.game;

import com.ask.maryam.mode.ChallengerMode;
import com.ask.maryam.mode.DefenderMode;
import com.ask.maryam.mode.DualMode;
import com.ask.maryam.mode.Mode;
import com.ask.maryam.parameters.Parameters;

import java.util.List;

public class MastermindGame implements Game{
   private int nbOfGoodPlace;
   private int nbOfPresentNb;
   private Mode mode;
   private Parameters params;

   public MastermindGame() {}

   public void setMode(Mode mode) {
      this.mode = mode;
   }

   public int goodPlace(){
      return 0;
   }

   public int goodnumber(){
      return 0;
   }

   public void startWelcomeMessage() {
       System.out.println("\n********** Bienvenue dans le jeu Mastermind **********\n");
   }

   @Override
   public void startPlaying(ChallengerMode challMode) {

      System.out.println("Vous avez choisi le mode CHALLENGER, vous devez deviner le nombre secret de l'ordinateur. Tapez votre nombre.");

      List<Integer> playerProposedTable = challMode.putPlayerProposedNInList();
      List<Integer> computerSecretNbList = challMode.putComputerSecretNbInList();
      System.out.println(playerProposedTable);
      System.out.println(computerSecretNbList);
      // need computer secret nb table
      // need scann method for retrieving player proposed number transformed in a table
      // who tour is it
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
