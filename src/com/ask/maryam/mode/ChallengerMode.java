package com.ask.maryam.mode;

import com.ask.maryam.players.ComputerPlayer;
import com.ask.maryam.players.HumanPlayer;
import com.ask.maryam.players.Player;

import java.util.ArrayList;
import java.util.List;

public class ChallengerMode extends Mode {
    protected List<Integer> playerProposedNbList = new ArrayList<>();
    protected List<Integer> computerSecretNbList = new ArrayList<>();
    protected Player player = new HumanPlayer();
    protected Player computer = new ComputerPlayer();




    public List<Integer> getPlayerProposedNbTable() {
        return playerProposedNbList;
    }

    public List<Integer> getComputerScretNbTable() {
        return computerSecretNbList;
    }

    /*public int getPlayerSecretNb(){
        int secretNb = player.getSecretNb();

                return secretNb;
    }*/

    public List <Integer> putPlayerProposedNInList(){
        String playerProposedNb = player.getProposedNb();

        System.out.println("Dans ChallengerMode " + playerProposedNb);
        System.out.println("Length " + playerProposedNb.length());

        for(int i = 0; i< playerProposedNb.length(); i++){
            playerProposedNbList.add(i, Character.getNumericValue(playerProposedNb.charAt(i)));
        }
        return playerProposedNbList;
    }
}
