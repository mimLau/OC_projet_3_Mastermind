package com.ask.maryam.menu;

import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    int selectedMenu;

    public void displayPrincipalMenu(){

        System.out.println("\n************ Menu principal **********\n");
        System.out.println("1: Mastermind");
        System.out.println("2: Jeux du plus ou moins");

       selectedMenu = sc.nextInt();
       displayPlayMenu();

    }

    public void displayPlayMenu(){
        if(selectedMenu == 1) {
            System.out.println("\n********** Bienvenue dans le jeu Mastermind **********\n");
            displayMode();



        } else if(selectedMenu == 2) {
            System.out.println("\n********** Bienvenue dans le jeu Mastermind **********\n");
            displayMode();
        }

    }

    public void displayMode() {
        System.out.println("Chosissez un mode");
        System.out.println("1: Challenger");
        System.out.println("2: Defenser");
        System.out.println("3: Duel");
    }




}
