package com.ask.maryam.players;

import com.ask.maryam.Utils.Utils;
import com.ask.maryam.parameters.Parameters;


public class HumanPlayer extends Player {

    Parameters params = Parameters.INSTANCE;

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setting a secret number respecting the size imposed size in the config.properties.
     */
    @Override
    public void setSecretNb(){
       int secretNbSize = params.getSecretNbSize();
       secretNb = Utils.enterNumber(secretNbSize);
    }

    /**
     * Setting a proposed number respecting the size imposed size in the config.properties.
     */
    @Override
    public void setProposedNb(){
        int secretNbSize = params.getSecretNbSize();
        proposedNb = Utils.enterNumber(secretNbSize);
    }
}
