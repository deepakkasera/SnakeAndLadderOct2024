package org.example.models;

import org.example.utils.DiceUtility;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private Board board;
    private Queue<Player> players;
    private Queue<Player> winners;
    private int numberOfDices;
    private int dimension;

    public Game(int numberOfDices, int dimension, Queue<Player> players) {
        this.dimension = dimension;
        this.players = players;
        this.numberOfDices = numberOfDices;
        this.winners = new LinkedList<>();
        this.board = new Board(dimension);
    }

    public void start() {
        board.print();

        while (players.size() > 1) {
            Player currentPlayer = players.poll();
            System.out.println(currentPlayer.getName() + "'s turn, current position is " + currentPlayer.getCurrentPosition());

            System.out.println("Please enter 'r' to roll the dice.");
            Scanner scanner = new Scanner(System.in);
            char ch = scanner.next().charAt(0);

            System.out.println(currentPlayer.getName() + " is rolling the dice.");

            makeMove(currentPlayer);

            if (currentPlayer.getCurrentPosition() == board.getCellCount()) {
                System.out.println(currentPlayer.getName() + " has WON the game. Congrats.");
                winners.add(currentPlayer);
            } else {
                players.add(currentPlayer);
            }
        }
    }

    public void makeMove(Player currentPlayer) {
        int diceNumber = DiceUtility.roll(numberOfDices);

        System.out.println(currentPlayer.getName() + " got " + diceNumber + " on the dice.");

        int finalPosition = currentPlayer.getCurrentPosition() + diceNumber;

        System.out.println("Final position is " + finalPosition);
        System.out.println("CellCount: " + board.getCellCount());

        if (finalPosition <= board.getCellCount()) {
            //Check if there's a snake or a ladder on finalPosition.
            if (board.hasSnakeOrLadder(finalPosition)) {
                BoardEntity entity = board.getBoardEntityMap().get(finalPosition);
//                    if (entity.getBoardEntityType().equals(BoardEntityType.SNAKE)) {
//                        System.out.println("Oops, You encountered a snake. :(");
//                    } else {
//                        System.out.println("Yayy, You encountered a ladder. :)");
//                    }

                entity.printBoardEntity();
                finalPosition = entity.getEnd();
            }
        } else {
            //Skip the turn.
            System.out.println("Try again.");
            finalPosition = currentPlayer.getCurrentPosition();
        }

        currentPlayer.setCurrentPosition(finalPosition);
    }
}
