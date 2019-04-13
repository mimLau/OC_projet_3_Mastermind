package com.ask.maryam.menu;

import com.ask.maryam.game.MoreAndLessGame;
import com.ask.maryam.mode.ChallengerMode;
import com.ask.maryam.game.MastermindGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    private int selectedMenu;
    private boolean mastermindPlay;
    private boolean moreAndLessPlay;

    private MastermindGame mastGame = new MastermindGame();
    private MoreAndLessGame moreAndLGame = new MoreAndLessGame();


    public void displayPrincipalMenu(){

        do {
            System.out.println("\n************ Menu principal **********\n");
            System.out.println("1: Mastermind");
            System.out.println("2: Jeux du plus ou moins");

            try {
                selectedMenu = sc.nextInt();
            } catch (InputMismatchException e){
                sc.next();
            }

        } while(selectedMenu != 1 && selectedMenu !=2);
        displayPlayMenu();
    }



    public void displayPlayMenu(){

             if(selectedMenu == 1) {
                 mastGame.startGameMessage();
                 mastermindPlay = true;
             } else if(selectedMenu == 2) {
                 moreAndLGame.startGameMessage();
                 moreAndLessPlay = true;
             }
        displayMode();
    }

    public void displayMode() {
        do {
            selectedMenu =0;
            System.out.println("Choisissez un mode");
            System.out.println("1: Challenger");
            System.out.println("2: Defenser");
            System.out.println("3: Duel");

            try {
                selectedMenu = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
            }

            if(mastermindPlay)
                launchMasterMindPlay();
                else if (moreAndLessPlay)
                    launchMoreAndLessPlay();

        }while(selectedMenu != 1 && selectedMenu != 2 && selectedMenu != 3);

    }

    public void launchMasterMindPlay() {
        switch (selectedMenu) {
            case 1:
                //TODO create MastermindPlay class with challengerMode attribut:

                ChallengerMode chalMode = new ChallengerMode();
                //MastermindGame mastermindPlay = new MastermindGame(chalMode);
                chalMode.getComputerScretNbTable();

                System.out.println("Vous avez choisi de jouer à Mastermind en mode challenger.");
                break;

            case 2:
                //TODO create MastermindPlay class with defenderMode attribut:
                System.out.println("Vous avez choisi de jouer à Mastermind en mode defenseur.");
                break;

            case 3:
                //TODO create MastermindPlay class with dualMode attribut:
                System.out.println("Vous avez choisi de jouer à Mastermind en mode duel.");
                break;
        }
    }

        public void launchMoreAndLessPlay(){
            switch (selectedMenu){
                case 1:
                    //TODO create MoreAndLessPlay class class with challengerMode attribut.
                    System.out.println("Vous avez choisi de jouer au jeu du plus ou moins en mode challenger.");
                    break;

                case 2:
                    //TODO create MoreAndLessPlay class with defenderMode attribut:
                    System.out.println("Vous avez choisi de jouer au jeu du plus ou moins en mode defenseur.");
                    break;

                case 3:
                    //TODO create MoreAndLessPlay class with dualMode attribut:
                    System.out.println("Vous avez choisi de jouer au jeu du plus ou moins en mode duel.");
                    break;
            }
        }
}
