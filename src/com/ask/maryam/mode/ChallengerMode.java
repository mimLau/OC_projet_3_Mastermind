package com.ask.maryam.mode;

import com.ask.maryam.players.HumanPlayer;
import com.ask.maryam.players.Player;

public class ChallengerMode extends Mode {
    private int [] playerProposedNbTable;
    private int [] computerScretNbTable;

    public int[] getPlayerProposedNbTable() {
        return playerProposedNbTable;
    }

    public int[] getComputerScretNbTable() {
        return computerScretNbTable;
    }

    Player player = new HumanPlayer();
    public int getPlaySecretNb(){
        int secretNb = player.getSecretNb();

                return secretNb;
    }
}
