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
    }




}
