package com.ask.maryam.mode;

import com.ask.maryam.Utils.Utils;
import com.ask.maryam.players.ComputerPlayer;
import com.ask.maryam.players.HumanPlayer;
import com.ask.maryam.players.Player;
import java.util.List;
import java.util.Map;

public class DualMode extends Mode{

    public DualMode(){
        this.setName();
    }

    public void setName(){
        this.name = "DUAL";
    }

    public String getSecretNb() {
        this.secretNb = player2.getSecretNb();
        return secretNb;
    }

    public String getProposedNb(){
        this.proposedNb = player1.getProposedNb();
        return proposedNb;
    }

    /**
     * We define here, which player is the computer and which one is the human.
     */
    @Override
    public void playersSelection(){
        player1 = new ComputerPlayer();
        player2 = new HumanPlayer();
    }

    /**
     * As in this mode, computer and human player play in turn,
     * every turn we reverse computer and human player roles.
     */
    public void inversePlayersSelection(){
        Player player;
        player = player1;
        player1 = player2;
        player2 = player;
    }

    /**
     * Put the human player  or the computer secret number in list for being compared.
     * @param gameName
     * @return A list of Integer with the secret number. Each digit of the secret number in a cell of the list.
     */
    @Override
    public List<Integer> putSecretNumberInList(String gameName) {
        secretNbList = putSecretNbInListCondition(gameName, player2);
        return secretNbList;
    }

    /**
     * Put the human player or the computer proposed number in list for being compared.
     * @param gameName
     * @return A list of Integer with the proposed number. Each digit of the proposed  number in a cell of the list.
     */
    @Override
    public List<Integer> putProposedNumberInList(String gameName) {
        proposedNbList = putPropNbInListCondition(gameName,player1);
        return proposedNbList;
    }

    /**
     * Put the computer proposed number in list for being compared. This time, the proposed number is set from an algorithm
     * based on  the first proposition of the computer.
     * @param goodPlace A map with the numbers in the good place and their index.
     * @param goodNb A map with the good numbers but not at the good place and their index.
     * @return A list of Integer with the computer proposed number. Each digit of the proposed  number in a cell of the list.
     */
    /*public List<Integer> putProposedNumberInListUsingAlgo(Map<Integer, Integer> goodPlace, Map<Integer, Integer> goodNb) {
        player1.setProposedNb(goodPlace, goodNb);
        proposedNbList = Utils.stringToList(player1.getProposedNb());
        return proposedNbList;
    }*/


}
