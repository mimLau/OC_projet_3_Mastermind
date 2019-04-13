package com.ask.maryam.game;

import com.ask.maryam.mode.Mode;

public class MoreAndLessGame implements Game {
    private String [] moreAndLessTable;
    private Mode mode;
    //private Parameters pram;


    @Override
    public void startWelcomeMessage() {
        System.out.println("\n********** Bienvenue dans le jeu du plus ou moins **********\n");
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

    public String []  displayMoreAndLessTable(){

        return null;
    }
}
