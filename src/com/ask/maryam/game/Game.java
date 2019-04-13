package com.ask.maryam.game;

import com.ask.maryam.mode.ChallengerMode;
import com.ask.maryam.mode.DefenderMode;
import com.ask.maryam.mode.DualMode;
import com.ask.maryam.mode.Mode;

public interface  Game {
     /*int trialNb;
     boolean gameOver;*/

    public void startWelcomeMessage();
    public void startPlaying(ChallengerMode challMode);
    public void startPlaying(DefenderMode defenderMode);
    public void startPlaying(DualMode dualMode);
    public void compareNb();
    public String displayResult();
    public boolean isGameFinisched();

}
