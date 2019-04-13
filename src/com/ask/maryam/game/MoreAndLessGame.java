package com.ask.maryam.game;

import com.ask.maryam.mode.Mode;
import com.ask.maryam.parameters.Parameters;

public class MoreAndLessGame implements Game {
    private String [] moreAndLessTable;
    private Mode mode;
    private Parameters params;


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
