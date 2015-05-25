package com.dreamlock.core;

import com.dreamlock.core.menu.EmptyChoice;
import com.dreamlock.core.menu.IMenuChoice;
import com.dreamlock.core.menu.StartLoadedGameChoice;
import com.dreamlock.core.menu.StartNewGameChoice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dreamlock {
    public static void main (String[] args) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        Boolean MainGameRunning = true;

        while (MainGameRunning) {
            createMainMenu();
            IMenuChoice menuChoice;
            try {
                input = buffer.readLine();
                switch (input) {
                    case "1":  //NEW GAME
                        menuChoice = new StartNewGameChoice();
                        break;
                    case "2": //LOAD GAME
                        menuChoice = new StartLoadedGameChoice();
                        break;
                    case "3": //EXIT
                        menuChoice = new EmptyChoice();
                        MainGameRunning = false;
                        System.out.println("Goodbye! Farewell Traveler!!");
                        break;
                    default:
                        menuChoice = new EmptyChoice();
                        System.out.println("Not a valid choice!");
                        break;
                }
//                menuChoice.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createMainMenu () {
        GameUtils gameUtils = new GameUtils();
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.println("3. Exit\n");
        System.out.print(": ");
    }
}