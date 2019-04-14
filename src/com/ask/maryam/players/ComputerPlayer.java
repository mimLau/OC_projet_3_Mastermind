package com.ask.maryam.players;

import com.ask.maryam.Utils.Utils;
import com.ask.maryam.parameters.Parameters;

import static java.lang.Integer.parseInt;

public class ComputerPlayer extends Player {
    private String computerSecretNb;
    private String computerProposedNb;
    private Parameters params = new Parameters();



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

            stbuild =  stbuild.append(Utils.getRandom(getMaxUsableDigit + 1)); //Generate un random number between 0 and the maximal usable digit, and put it in a StringBuilder.

            /* We don't want a secret number beginning by zero so we verify if it is the case.
               If it is, empty the StringBuilder and a tour to the boucle.
             */

            if(i==0){
                if(String.valueOf(stbuild).equals("0")){
                    stbuild.setLength(0);
                    i=i-1;

                    System.out.println("i " + i);
                }
             }
        }
        computerSecretNb= String.valueOf(stbuild);
        return computerSecretNb;
    }
}
