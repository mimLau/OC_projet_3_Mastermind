package com.ask.maryam.game;

import com.ask.maryam.mode.ChallengerMode;
import com.ask.maryam.mode.DefenderMode;
import com.ask.maryam.mode.DualMode;
import com.ask.maryam.mode.Mode;
import com.ask.maryam.parameters.Parameters;

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

      challMode.playerProposedNbTable();
      System.out.println(challMode.playerProposedNbTable());
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
