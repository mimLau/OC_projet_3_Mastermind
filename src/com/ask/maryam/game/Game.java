package com.ask.maryam.game;

import com.ask.maryam.mode.ChallengerMode;
import com.ask.maryam.mode.DefenderMode;
import com.ask.maryam.mode.DualMode;
import com.ask.maryam.mode.Mode;
import com.ask.maryam.parameters.Parameters;

import java.util.List;

public interface  Game {

    public void startWelcomeMessage();
    public void startPlaying(ChallengerMode challMode, Parameters params);
    public void startPlaying(DefenderMode defenderMode, Parameters params);
    public void startPlaying(DualMode dualMode, Parameters params);
    public void winTheGame();
    public void gameOver(String answer);
    public void playAgain();
    public String displayResult();

}
