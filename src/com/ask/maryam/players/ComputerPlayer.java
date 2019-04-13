package com.ask.maryam.players;

import com.ask.maryam.Utils.Utils;
import com.ask.maryam.parameters.Parameters;

import static java.lang.Integer.parseInt;

public class ComputerPlayer extends Player {
    private String computerSecretNb;
    private String computerProposedNb;
    private Parameters params = new Parameters();

    private StringBuilder stbuild = new StringBuilder();

    public String getProposedNb(){
        return null;
    }

    public String getSecretNb(){

        int secretNbSize = params.getSecretNbSize();
        //computerSecretNb = String.valueOf(Utils.getRandom(secretNbSize));
        computerSecretNb = String.valueOf(Utils.getRandomInteger(getMax(secretNbSize),getMin(secretNbSize)));
        //computerSecretNb = String.valueOf(Utils.getRandomInteger(100000, 10000));
        System.out.println("Nombre secret de l'ordinateur " + computerSecretNb);

        //String str = String.format(9,"%04d");
        return computerSecretNb;
    }

        private int getMax(int secretNbSize) {
            stbuild.append(1);

            System.out.println("secretNbSize " + secretNbSize);
            for (int i = 0; i < secretNbSize; i++){
                stbuild.append(0);
                System.out.println("BuilderMin " + stbuild);

            }

            int getMax = parseInt(stbuild.toString());

            /*String getMax = "1";
                for (int i = 1; i < String.valueOf(secretNbSize).length()-1; i++)
                    getMax = getMax + "0";

             */
            stbuild.setLength(0);
                return getMax;
        }

        private int getMin(int secretNbSize){
            stbuild.append(1);

            System.out.println("BuilderMin " + stbuild);

            for (int i = 0; i < secretNbSize-1; i++){
                stbuild.append(0);
                System.out.println("BuilderMax " + stbuild);
            }
            int getMin = parseInt(stbuild.toString());

            return getMin;
        }

}
