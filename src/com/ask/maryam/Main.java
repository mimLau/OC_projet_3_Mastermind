package com.ask.maryam;

import com.ask.maryam.menu.Menu;
import com.ask.maryam.parameters.Parameters;

public class Main {

    public static void main(String [] args){

        /*
            Set all the parameters which are in the config.properties file.
         */
        Parameters params = Parameters.INSTANCE;


        params.setMaxUsableDigit();
        params.setSecretNbSize();
        params.setTrialNbMax();

        /*
            Verify if the argument isDev in the "run config" exits, if true we use it, if not, we set the dev mode
            from parameters which are in the config.properties file.
         */
        if(args.length != 0){
            params.setDevMode(Boolean.parseBoolean(args[0]));
        } else {
            params.setDevMode();
        }

        //Launch the menu only if all the parameters are configured in the config.properties file.
        if(params.getMaxUsableDigit()!=0 && params.getTrialNbMax()!=0 && params.getSecretNbSize()!=0) {
            Menu menu = new Menu();
            menu.displayPrincipalMenu();
        }
    }
}
