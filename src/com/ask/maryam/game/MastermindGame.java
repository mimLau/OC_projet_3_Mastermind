package com.ask.maryam.game;

import com.ask.maryam.mode.Mode;

public class MastermindGame extends Game{
   private int nbOfGoodPlace;
   private int nbOfPresentNb;
   private Mode mode;
   //PlayParameters playParams;


    public MastermindGame(Mode mode) {
        this.mode = mode;
    }
}
