package com.ask.maryam.mode;

import com.ask.maryam.players.ComputerPlayer;
import com.ask.maryam.players.HumanPlayer;
import com.ask.maryam.players.Player;

import java.util.ArrayList;
import java.util.List;

public class ChallengerMode extends Mode {
    protected List<Integer> playerProposedNbList;
    protected List<Integer> computerSecretNbList = new ArrayList<>();
    protected HumanPlayer player = new HumanPlayer();
    protected ComputerPlayer computer = new ComputerPlayer();

    public HumanPlayer getPlayer() {
        return player;
    }

    public ComputerPlayer getComputer() {
        return computer;
    }

    public List <Integer> putComputerSecretNbInList(){
        String computerSecretNb = computer.getSecretNb();
        for(int i = 0; i< computerSecretNb.length(); i++){
            computerSecretNbList.add(i, Character.getNumericValue(computerSecretNb.charAt(i)));
        }
        return computerSecretNbList;
    }

    public List <Integer> putPlayerProposedNbInList(){
        String playerProposedNb = player.getProposedNb();
        playerProposedNbList = new ArrayList<>();

        for(int i = 0; i< playerProposedNb.length(); i++){
            playerProposedNbList.add(i, Character.getNumericValue(playerProposedNb.charAt(i)));
        }
        return playerProposedNbList;
    }
}
