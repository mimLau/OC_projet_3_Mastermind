package com.ask.maryam.mode;

import com.ask.maryam.Utils.Utils;
import com.ask.maryam.players.*;
import java.util.List;

public class ChallengerMode extends Mode {

    public ChallengerMode(){
        this.setName();
    }

    public void setName(){
        this.name = "CHALLENGER";
    }

    public String getSecretNb() {
        this.secretNb = player2.getSecretNb(); //For the challengerMode, it's the computer which set a secret number.
        return secretNb;                      // Player2 is the computer, see the method playerSelection.
    }

    public String getProposedNb(){
        this.proposedNb = player1.getProposedNb(); //For the challengerMode, it's the human player who set a proposed number
        return proposedNb;                        // Player1 is the human player, see the method playerSelection.
    }

    /**
     * We define here, which player is the computer and which one is the human.
     */
    @Override
    public void playersSelection() {
        player1 = new HumanPlayer();
        player2 = new ComputerPlayer();
    }

    /**
     * Put the computer secret number in list for being compared.
     * @param gameName
     * @return A list of Integer with the computer secret number. Each digit of the secret number in a cell of the list.
     */
    @Override
    public List<Integer> putSecretNumberInList(String gameName) {
        player2.setSecretNb();
        secretNbList = Utils.stringToList(player2.getSecretNb()); // The secret number is in String type, and we put it in a list of integer.
        return secretNbList;
    }

    /**
     * Put the human player proposed number in list for being compared.
     * @param gameName
     * @return A list of Integer with the human player proposed number. Each digit of the proposed  number in a cell of the list.
     */
    @Override
    public List<Integer> putProposedNumberInList(String gameName) {
        proposedNbList = putPropNbInListCondition(gameName,player1); // Add an additional verification when the human player types his number.
        return proposedNbList;
    }
}
