package com.ask.maryam.game;

import com.ask.maryam.menu.Menu;
import com.ask.maryam.mode.ChallengerMode;
import com.ask.maryam.mode.DefenderMode;
import com.ask.maryam.mode.DualMode;
import com.ask.maryam.mode.Mode;
import com.ask.maryam.parameters.Parameters;
import com.ask.maryam.players.Player;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class Game {

    protected Parameters params = Parameters.INSTANCE;
    protected final static String MASTERMINDGAME = "Mastermind";
    protected final static String MOREANDLESSGAME = "MoreAndLessGame";
    protected String secretNb;
    protected String name;

    protected int secretNbSize = params.getSecretNbSize();
    protected int maxUsableDigit = params.getMaxUsableDigit();
    protected int trialNbMax = params.getTrialNbMax();
    protected boolean isDevMode = params.isDevMode();


     abstract public void startPlaying(ChallengerMode challMode);
     abstract public void startPlaying(DefenderMode defenderMode);
     abstract public void startPlaying(DualMode dualMode);
     abstract public List<Map<Integer, Integer>> verificationGoodPresentPlace(List<Integer> secretNbList, List<Integer> proposedNbList, Mode mode);
     abstract public Map<Integer, Integer>  goodPlace(List<Integer> secretNbList, List<Integer> proposedNbList, Mode mode);


    /**
     * A welcome message will be displayed., depending of the game name.
     * @param gameName Name of the game, Mastermind or more and less.
     */
    public void startWelcomeMessage(String gameName) {
        if(gameName.equals(MASTERMINDGAME)){
            System.out.println("\n                                      Bienvenue dans le jeu MasterMind\n");
        }
        else if (gameName.equals(MOREANDLESSGAME)){
            System.out.println("\n                                      Bienvenue dans le jeu du plus ou moins\n");
        }
    }

    /**
     * Display a message with the name of the game, the type of the chosen mode
     * and if the game is launched in developer mode or not.
     * @param mode Chosen mode for the game
     * @param gameName Name of the game
     */
    public void displayModeMessage(Mode mode, String gameName) {
        String devModeMess;

        if(isDevMode) {
            devModeMess = "en mode DEVELOPPEUR";

        } else {
            devModeMess = "";
        }
        System.out.println("\n                                      " + gameName + " : mode " + mode.getName() + " " + devModeMess + "\n");

        if(mode instanceof ChallengerMode) {

            //In the challenger mode, its the player who tries to guess the computer's secret number.
            System.out.println("Devinez le nombre secret de l'ordinateur.");
            System.out.println("Tapez un nombre de " + secretNbSize + " chiffres.");

        } else if (mode instanceof DefenderMode){

            //In the defender mode, its the computer that tries to guess the player's secret number.
            System.out.println("L'ordinateur joue contre vous.");
            System.out.println("Tapez votre nombre secret de " + secretNbSize + " chiffres.");
        }

        //For the Mastermind game, there is a additional constraint which is the maximal digit that could be used.
        // This message is displayed for the player when he had to enter his secret number or his proposed number.
        //For the dual mode, as the computer and the player plays in turn, this constraint is verified directly in the game class.
        if(gameName.equals(MASTERMINDGAME)&& !(mode instanceof DualMode)){
            System.out.println("Vous devez choisir des chiffres allant de 0 à " + maxUsableDigit +".");
        }
    }

    /**
     * If the developer mode is enable, the game displays the secret number.
     * @param devMode boolean which indicates if the developer mode is enable.
     * @param mode type of the mode which is chosen
     */
    public void displaySecretNb(boolean devMode, Mode mode){
        if(devMode) {
            secretNb = mode.getSecretNb();
            System.out.println("\n(Nombre secret: " + secretNb + ")");
        }
    }

    /**
     * Display the number secret. This method is used when the player lose.
     * @param mode chosen game mode
     * @return the secret number
     */
    public String displayResult(Mode mode) {
        secretNb = mode.getSecretNb();
        System.out.println("                                        Le nombre secret est " + secretNb + "\n");
        return secretNb;
    }

    /**
     * Display message when the player or the computer loses the party.
     * @param mode game mode
     * @param nbOfGoodPlace number of good digits in the good place in the proposed number
     */
    public void gameOver(Mode mode, int nbOfGoodPlace) {
        if(nbOfGoodPlace != secretNbSize) {
            if(mode instanceof ChallengerMode) {
                System.out.println("\n                                      Dommage! Vous avez perdu la partie!");
            } else if(mode instanceof DefenderMode) {
                System.out.println("\n                                      L'ordinateur a perdu la partie!");
            }
            displayResult(mode);
            playAgain(mode);
        }
    }

    /**
     * Display message when the player or the computer loses the party. For the dual mode.
     * @param mode game mode
     * @param nbOfGoodPlace1 number of good digits in the good place in the number proposed by the player1. (Player or computer)
     * @param nbOfGoodPlace2 number of good digits in the good place in the number proposed by the player2. (Player or computer)
     */
    public void gameOver(Mode mode, int nbOfGoodPlace1, int nbOfGoodPlace2) {
        if(nbOfGoodPlace1 != secretNbSize && nbOfGoodPlace2 != secretNbSize) {
            System.out.println("\n                                      Dommage! Vous avez perdu la partie!");
            playAgain(mode);
        }
    }

    /**
     * Display message when the player or the computer wins the party for the challenger and the defender mode.
     * @param mode game mode
     * @param nbOfGoodPlace number of good digits in the good place in the proposed number
     */
    public void winTheGame(Mode mode, int nbOfGoodPlace) {
        if(nbOfGoodPlace == secretNbSize) {
            if(mode instanceof ChallengerMode) {
                System.out.println("\n                                      Bravo! Vous avez gagné la partie!\n");
            } else if(mode instanceof DefenderMode) {
                System.out.println("\n                                      L'ordinateur a gagné la partie!");
            }
            playAgain(mode);
        }
    }

    /**
     * Display message when the player or the computer wins the party, for the dual mode.
     * @param mode game mode
     * @param nbOfGoodPlace number of good digits in the good place in the proposed number
     * @param player Player who is guessing the secret number.
     */
    public void winTheGame(Mode mode, int nbOfGoodPlace, Player player) {
        if(nbOfGoodPlace == secretNbSize){
            System.out.println("\n                                      " + player.getName()+ " a gagné la partie!\n");
            playAgain(mode);
        }
    }

    /**
     * Display menu message when the game is finished.
     * @param mode game mode
     */
    public void playAgain(Mode mode) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

            System.out.println("Voulez-vous:");
            System.out.println("1: Rejouer une partie");
            System.out.println("2: Retourner au menu principal");
            System.out.println("3: Quitter le jeu");

        do {
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:

                        if (mode instanceof ChallengerMode) {
                            ChallengerMode challMode = new ChallengerMode();
                            startPlaying(challMode);
                        } else if (mode instanceof DualMode) {
                            DualMode dualMode = new DualMode();
                            startPlaying(dualMode);
                        } else {
                            DefenderMode defenderMode = new DefenderMode();
                            startPlaying(defenderMode);
                        }
                        break;
                    case 2:
                        Menu menu = new Menu();
                        menu.displayPrincipalMenu();
                        break;
                    case 3:
                        System.out.println("Au revoir et à bientôt.");
                        break;
                }
            } catch (InputMismatchException e){
                sc.next();

            }

            if(choice != 1 && choice != 2 && choice != 3){
                System.out.println("Choisissez un chiffre entre 1 et 3.");
            }
        } while(choice != 1 && choice != 2 && choice != 3);
    }
}
