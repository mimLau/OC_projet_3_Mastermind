package com.ask.maryam.game;

import com.ask.maryam.mode.Mode;

public class MastermindGame implements Game{
   private int nbOfGoodPlace;
   private int nbOfPresentNb;
   private Mode mode;


   public void startGameMessage() {
       System.out.println("\n********** Bienvenue dans le jeu Mastermind **********\n");
   }



   //PlayParameters playParams;


    /*public MastermindGame(Mode mode) {
        this.mode = mode;
    }*/
}
