package com.ask.maryam;

import com.ask.maryam.menu.Menu;
import com.ask.maryam.parameters.Parameters;

public class Main {

    public static void main(String [] args){

        Menu menu = new Menu();
        menu.displayPrincipalMenu();

        /*Parameters params = new Parameters();

        System.out.println("Nombre de cases de la combinaison secrète: " + params.getSecretNbSize());
        System.out.println("Nombre d'essais possible: " + params.getTrialNbMax());
        System.out.println("Nombre de chiffre utilisable  " + params.getMaxUsableDigit());


        params.setDevMode(Boolean.valueOf(args[0]).booleanValue());

        System.out.println("Mode développeur " + params.isDevMode());*/
    }
}
