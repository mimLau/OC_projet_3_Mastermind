package com.ask.maryam;

import com.ask.maryam.menu.Menu;
import com.ask.maryam.parameters.Parameters;

public class Main {

    public static void main(String [] args){

        Parameters params = new Parameters();
        try {
            if(args[0] != null){
                params.setDevMode(Boolean.parseBoolean(args[0]));
            }
        }catch (ArrayIndexOutOfBoundsException configParamNull){
            params.setDevMode(false);
        }

        Menu menu = new Menu(params);
        menu.displayPrincipalMenu();

    }
}
