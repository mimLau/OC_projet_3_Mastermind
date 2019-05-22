package com.ask.maryam.mode;

import com.ask.maryam.Utils.Utils;
import com.ask.maryam.players.ComputerPlayer;
import com.ask.maryam.players.HumanPlayer;

import java.util.List;
import java.util.Map;

public class DefenderMode extends Mode {

    public DefenderMode() {
        this.setName();
    }

    public void setName() {
        this.name = "DEFENDER";
    }

    public String getSecretNb() {
        this.secretNb = player2.getSecretNb(); //For the defenderMode, it's the human player who set a secret number.
        return secretNb;                      // Player2 is the human player, see the method playerSelection.
    }

    public String getProposedNb() {
        this.proposedNb = player1.getProposedNb(); //For the defenderMode, it's the computer which set a proposed number.
        return proposedNb;                         // Player1 is the computer, see the method playerSelection.
    }

    /**
     * We define here, which player is the computer and which one is the human.
     */
    @Override
    public void playersSelection() {
        player1 = new ComputerPlayer();
        player2 = new HumanPlayer();
    }

    /**
     * Put the human player secret number in list for being compared.
     *
     * @param gameName
     * @return A list of Integer with the human player secret number. Each digit of the secret number in a cell of the list.
     */
    @Override
    public List<Integer> putSecretNumberInList(String gameName) {
        secretNbList = putSecretNbInListCondition(gameName, player2);  //Add an additional verification when the human player types his number.
        return secretNbList;
    }

    /**
     * Put the computer proposed number in list for being compared.
     *
     * @param gameName
     * @return A list of Integer with the computer proposed number. Each digit of the proposed  number in a cell of the list.
     */
    @Override
    public List<Integer> putProposedNumberInList(String gameName) {
        player1.setProposedNb();
        proposedNbList = Utils.stringToList(player1.getProposedNb()); //The proposed number is in String type, and we put it in a list of integer.
        return proposedNbList;
    }

}
