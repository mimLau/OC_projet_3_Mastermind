package com.ask.maryam.mode;

import com.ask.maryam.players.ComputerPlayer;
import com.ask.maryam.players.HumanPlayer;
import com.ask.maryam.players.Player;

public class ChallengerMode extends Mode {
    protected  int [] playerProposedNbTable;
    protected int [] computerScretNbTable;
    protected Player player = new HumanPlayer();
    protected Player computer = new ComputerPlayer();




    public int[] getPlayerProposedNbTable() {
        return playerProposedNbTable;
    }

    public int[] getComputerScretNbTable() {
        return computerScretNbTable;
    }

    public int getPlayerSecretNb(){
        int secretNb = player.getSecretNb();

                return secretNb;
    }

    public int [] playerProposedNbTable(){
        String playerProposedNb = player.getProposedNb();

        for(int i = 0; i< playerProposedNb.length(); i++){
            playerProposedNbTable[i]= playerProposedNb.charAt(i);
        }
        return playerProposedNbTable;
    }
}
