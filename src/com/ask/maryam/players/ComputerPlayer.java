package com.ask.maryam.players;

import com.ask.maryam.Utils.Utils;
import com.ask.maryam.parameters.Parameters;

import java.util.*;

public class ComputerPlayer extends Player {
    Parameters params = Parameters.INSTANCE;

    public ComputerPlayer(){
        this.setName();
    }

    public void setName() {
        this.name = "Ordinateur";
    }


    /**
     * Set the computer secret number respecting the size imposed in the config.properties file.
     * We use a random function to set the computer secret number.
     */
    @Override
    public void setSecretNb(){
            int secretNbSize = params.getSecretNbSize();
            int getMaxUsableDigit = params.getMaxUsableDigit();
            secretNb = Utils.getRandomNumber(secretNbSize, getMaxUsableDigit);
    }

    /**
     * Set the computer proposed number respecting the size imposed in the config.properties file.
     * We use a random function to set the computer proposed number.
     */
    @Override
    public void setProposedNb() {
        int secretNbSize = params.getSecretNbSize();
        int getMaxUsableDigit = params.getMaxUsableDigit();
        proposedNb = Utils.getRandomNumber(secretNbSize, getMaxUsableDigit);
    }

    /**
     * Set the computer proposed number. But this time, we don't use the random function, but an algorithm based one the first
     * proposition done by the computer.
     * @param goodPlace It's the number of digit which are in the good place in the first computer proposed number.
     * @param goodNb It's the number of digit which are present but not in the good place in the first computer proposed number.
     */
    public void setProposedNb(Map<Integer, Integer> goodPlace, Map<Integer, Integer> goodNb) {
        int secretNbSize = params.getSecretNbSize();
        int getMaxUsableDigit = params.getMaxUsableDigit();
        List<String> proposedNbList = new ArrayList<>();

        /* Creation of an ArrayList with the same size than the secretNbSize parameter
        of the config.properties.*/

        for(int i=0; i<secretNbSize; i++){
            proposedNbList.add(i, "");
        }


        /* We retrieve all good number from the map and their position. We put them in the proposedNb list at the index
         which is equal to their position.*/

        Set<Integer> setGoodPlacePosition = goodPlace.keySet();
        Iterator<Integer> goodPlaceIt = setGoodPlacePosition.iterator();


        while(goodPlaceIt.hasNext()){
            int key = goodPlaceIt.next();
            proposedNbList.set(key, String.valueOf((goodPlace.get(key))));
        }


        /* We retrieve all present number from the map and their position. We put them in the proposedNb list in a empty cell
         which the index is different from the key value of the map ( which correspond of the position of the present number).*/

        Set<Integer> setGoodNbPosition = goodNb.keySet();
        Iterator<Integer> goodNbIt = setGoodNbPosition.iterator();

        while(goodNbIt.hasNext()){

            int key = goodNbIt.next();
            boolean boucle = true;
            for(int i=0; boucle && i< proposedNbList.size(); i++){

                if(proposedNbList.get(i).isEmpty() && i!= key){
                        proposedNbList.set(i, String.valueOf((goodNb.get(key))));
                        boucle = false;
                }
            }
        }


        /*
            If the proposedNbList isn't complete, we full the empty cells with a unique random digit.
         */

        for(int i=0; i<proposedNbList.size(); i++) {

            if (proposedNbList.get(i).isEmpty()) {

                int randOmDigit;
                boolean uniqueDigit;
                do {
                    randOmDigit = Utils.getRandom(getMaxUsableDigit + 1);
                    uniqueDigit = proposedNbList.contains(String.valueOf(randOmDigit));

                } while (uniqueDigit == true);
                proposedNbList.set(i, String.valueOf(randOmDigit));
            }
        }

        proposedNb = ""; // we empty the proposedN attribute from the first proposition and set on it the new proposition.
        for(String value : proposedNbList){

            proposedNb += value;
        }
    }
}
