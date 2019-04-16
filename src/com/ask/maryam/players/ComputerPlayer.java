package com.ask.maryam.players;

import com.ask.maryam.Utils.Utils;
import com.ask.maryam.parameters.Parameters;

import static java.lang.Integer.parseInt;

public class ComputerPlayer extends Player {
    private String computerSecretNb;
    private String computerProposedNb;
    private Parameters params = new Parameters();

    public String getComputerSecretNb() {
        return computerSecretNb;
    }

    public String getProposedNb(){
        return null;
    }

    /**
     * To get the computer random secret number.
     * @return computer secret number in String type.
     */
    public String getSecretNb(){

        /*  The secret number size must be equal to the secretNbSize parameter.
            Each secret number's digit must be in the range imposed by the parameter maxUsableDigit.
            Generate a random number for each digit of the secret number, and append them one by one.
            For that a StringBuilder is necessary.
         */

        StringBuilder stbuild = new StringBuilder();
        int secretNbSize = params.getSecretNbSize();
        int getMaxUsableDigit = params.getMaxUsableDigit();

        for(int i=0; i< secretNbSize; i++) {

            int randonNumber = Utils.getRandom(getMaxUsableDigit + 1); //Generate un random number between 0 and the maximal usable digit, and put it in a StringBuilder.

            if(stbuild.toString().contains(String.valueOf(randonNumber))) //Verify if the random digit already exists in the stbuild. if yes, we add un rounf in the loop.
                i = i-1;
            else
                stbuild.append(randonNumber);

            /* We don't want a secret number beginning by zero so we verify if it is the case.
               If it is, empty the StringBuilder and put additional round to the boucle.
             */

            if(i==0){
                if(stbuild.toString().equals("0")){
                    stbuild.setLength(0);
                    i=i-1;
                }
             }
        }
        computerSecretNb= String.valueOf(stbuild);
        return computerSecretNb;
    }
}
