package com.ask.maryam.mode;

import com.ask.maryam.players.ComputerPlayer;
import com.ask.maryam.players.HumanPlayer;
import com.ask.maryam.players.Player;

import java.util.ArrayList;
import java.util.List;

public class ChallengerMode extends Mode {
    protected List<Integer> playerProposedNbList = new ArrayList<>();
    protected List<Integer> computerSecretNbList = new ArrayList<>();
    protected HumanPlayer player = new HumanPlayer();
    protected Player computer = new ComputerPlayer();

    public HumanPlayer getPlayer() {
        return player;
    }

    public List <Integer> putComputerSecretNbInList(){
        String computerSecretNb = computer.getSecretNb();
        for(int i = 0; i< computerSecretNb.length(); i++){
            computerSecretNbList.add(i, Character.getNumericValue(computerSecretNb.charAt(i)));
        }
        return computerSecretNbList;
    }

    public List <Integer> putPlayerProposedNInList(){
        String playerProposedNb = player.getProposedNb();

        for(int i = 0; i< playerProposedNb.length(); i++){
            playerProposedNbList.add(i, Character.getNumericValue(playerProposedNb.charAt(i)));
        }
        return playerProposedNbList;
    }
}
