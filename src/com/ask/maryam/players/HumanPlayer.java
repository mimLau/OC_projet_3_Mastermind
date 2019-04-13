package com.ask.maryam.players;

import com.ask.maryam.parameters.Parameters;
import com.ask.maryam.players.Player;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private int playerSecretNb;
    private String playerProposedNb;
    private String Name;
    private Parameters params = new Parameters();

    Scanner sc = new Scanner(System.in);

    public String getProposedNb(){
        //int maxUsableDigit = params.getMaxUsableDigit();

        playerProposedNb = sc.next();
        System.out.println(playerProposedNb);

        return playerProposedNb;
    }

    public int getSecretNb(){
        playerSecretNb = sc.nextInt();
        return playerSecretNb;
    }


}
