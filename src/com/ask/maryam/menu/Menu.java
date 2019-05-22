package com.ask.maryam.menu;

import com.ask.maryam.game.MoreAndLessGame;
import com.ask.maryam.mode.ChallengerMode;
import com.ask.maryam.game.MastermindGame;
import com.ask.maryam.mode.DefenderMode;
import com.ask.maryam.mode.DualMode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private MastermindGame masterMindGame = new MastermindGame();
    private MoreAndLessGame moreAndLessGame = new MoreAndLessGame();

    final static Logger LOGGER = LogManager.getLogger(Menu.class);

    /**
     * Display the principal menu that proposes to choose a game between the displayed games.
     */
    public void displayPrincipalMenu(){
        Scanner sc = new Scanner(System.in);
        int selectedMenu = 0;
        System.out.println("\n                                          Menu principal \n");
        System.out.println("1: Mastermind");
        System.out.println("2: Jeux du plus ou moins");

        do {
            try {
                selectedMenu = sc.nextInt();
            } catch (InputMismatchException e){
                sc.next();
                LOGGER.error("InputMismatchException: Attend un entier.");
            }

            if(selectedMenu != 1 && selectedMenu !=2){
                System.out.println("Choisissez un chiffre entre 1 et 2.");
            }

        } while(selectedMenu != 1 && selectedMenu !=2);
        displayPlayMenu(selectedMenu);
    }

    /**
     *
     */
    public void displayPlayMenu(int selectedMenu){
        boolean isMastermindPlay = false;
         if(selectedMenu == 1) {
             masterMindGame.startWelcomeMessage(masterMindGame.getClass().getSimpleName());
             isMastermindPlay = true;
         } else if(selectedMenu == 2) {
             moreAndLessGame.startWelcomeMessage(moreAndLessGame.getClass().getSimpleName());
             isMastermindPlay = false;
         }
            displayMode(isMastermindPlay);
    }

    /**
     * Display the menu with the different modes.
     * @param isMastermindPlay false if the chosen game is moreAndLessGame.
     */
    public void displayMode(boolean isMastermindPlay) {

        int selectedMenu =0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Choisissez un mode");
        System.out.println("1: Challenger");
        System.out.println("2: Defenseur");
        System.out.println("3: Duel");

        do{
            try {
                selectedMenu = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                LOGGER.error("InputMismatchException: Attend un entier.");
            }

            if(isMastermindPlay)
                launchMasterMindPlay(selectedMenu);
                else
                    launchMoreAndLessPlay(selectedMenu);

            if(selectedMenu != 1 && selectedMenu !=2 && selectedMenu != 3){
                System.out.println("Choisissez un chiffre entre 1 et 3.");
            }

        }while(selectedMenu != 1 && selectedMenu != 2 && selectedMenu != 3);

    }

    /**
     * Launches the mastermind game in function of the selected item in the mode menu.
     * @param selectedMenu The mode selected in the mode menu.
     */
    public void launchMasterMindPlay(int selectedMenu) {
        switch (selectedMenu) {
            case 1:
                ChallengerMode chalMode = new ChallengerMode();
                masterMindGame.startPlaying(chalMode);
                break;

            case 2:
                DefenderMode defenderMode = new DefenderMode();
                masterMindGame.startPlaying(defenderMode);
                break;

            case 3:
                DualMode dualMode = new DualMode();
                masterMindGame.startPlaying(dualMode);
                break;
        }
    }

    /**
     * Launches the more and less game in function of the selected item in the mode menu.
     * @param selectedMenu The mode selected in the mode menu.
     */
    public void launchMoreAndLessPlay(int selectedMenu){
        switch (selectedMenu){
            case 1:
                ChallengerMode chalMode = new ChallengerMode();
                moreAndLessGame.startPlaying(chalMode);
                break;

            case 2:
                DefenderMode defenderMode = new DefenderMode();
                moreAndLessGame.startPlaying(defenderMode);
                break;

            case 3:
                DualMode dualMode = new DualMode();
                moreAndLessGame.startPlaying(dualMode);
                break;
        }
    }
}
