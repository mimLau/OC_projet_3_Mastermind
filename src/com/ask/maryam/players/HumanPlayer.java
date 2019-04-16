package com.ask.maryam.players;

import com.ask.maryam.Utils.Utils;
import com.ask.maryam.parameters.Parameters;
import com.ask.maryam.players.Player;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class HumanPlayer extends Player {
    private String playerSecretNb;
    private String playerProposedNb;
    private String Name;
    private Parameters params = new Parameters();
    boolean isMaximalDigitOk = true;

    Scanner sc = new Scanner(System.in);

    public HumanPlayer() {
    }

    public String getPlayerProposedNb() {
        return playerProposedNb;
    }

    public String getProposedNb(){
        //StringBuilder stbuild = new StringBuilder();
        // il faut verifeir que le nombre tapé n'a pas de chiffre dupliqué
        int secretNbSize = params.getSecretNbSize();
        int maxUsableDigit = params.getMaxUsableDigit();
        boolean nbWithUniqueDigit = true;

        do{
            playerProposedNb = sc.next();

            isMaximalDigitOk = maximalUsableDigitOk(playerProposedNb, maxUsableDigit);

            if(playerProposedNb.length() != secretNbSize)
                System.out.println("Choisissez un nombre à " + secretNbSize + " chiffres.");
            if(!isMaximalDigitOk)
                System.out.println("Choisissez un nombre avec des chiffres compris entre 0 et " + maxUsableDigit + ".");

            nbWithUniqueDigit = Utils.hasAllUniqueChars(playerProposedNb);

            if(!nbWithUniqueDigit)
                System.out.println("Veuillez saisir un nombre avec des chiffres uniques.");

        }while(playerProposedNb.length()!= secretNbSize || !isMaximalDigitOk || !nbWithUniqueDigit);

        return playerProposedNb;
    }

    private boolean maximalUsableDigitOk(String playerNumber, int maxUsableDigit){
        for(int i=0; i<playerNumber.length(); i++){


            if(Character.getNumericValue(playerNumber.charAt(i)) > maxUsableDigit){
                i= playerNumber.length();
                isMaximalDigitOk= false;
            }
            else {
                isMaximalDigitOk= true;
            }
        }
        return isMaximalDigitOk;
    }

    public String getSecretNb(){
        playerSecretNb = sc.next();
        return playerSecretNb;
    }


}
