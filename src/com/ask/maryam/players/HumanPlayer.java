package com.ask.maryam.players;

import com.ask.maryam.parameters.Parameters;
import com.ask.maryam.players.Player;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private String playerSecretNb;
    private String playerProposedNb;
    private String Name;
    private Parameters params = new Parameters();

    Scanner sc = new Scanner(System.in);

    public String getProposedNb(){
        //int maxUsableDigit = params.getMaxUsableDigit();
        playerProposedNb = sc.next();
        return playerProposedNb;
    }

    public String getSecretNb(){
        playerSecretNb = sc.next();
        return playerSecretNb;
    }


}
