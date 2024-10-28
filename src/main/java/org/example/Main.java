package org.example;

import org.example.models.Game;
import org.example.models.Player;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //Number of Dices, Dimension, Players
        int numberOfDices = 1;
        int dimension = 10;

        Player p1 = new Player("Varun");
        Player p2 = new Player("Ravi");

        Queue<Player> players = new LinkedList<>();
        players.add(p1);
        players.add(p2);

        Game game = new Game(numberOfDices, dimension, players);

        //Start playing the game.
        game.start();
    }
}