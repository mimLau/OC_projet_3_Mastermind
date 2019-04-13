package com.ask.maryam.game;

import com.ask.maryam.mode.Mode;
import com.ask.maryam.parameters.Parameters;

public class MastermindGame implements Game{
   private int nbOfGoodPlace;
   private int nbOfPresentNb;
   private Mode mode;
   private Parameters params;


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





    /*public MastermindGame(Mode mode) {
        this.mode = mode;
    }*/
}
