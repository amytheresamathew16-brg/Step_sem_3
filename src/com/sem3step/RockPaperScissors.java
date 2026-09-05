package com.sem3step;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {


    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        int totalRounds = 5;

        // Arrays to store history for the final summary table
        String[] playerHistory = new String[totalRounds];
        String[] computerHistory = new String[totalRounds];
        String[] resultHistory = new String[totalRounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("=== Welcome to the College Coding Arcade: Rock-Paper-Scissors ===");

        for (int i = 0; i < totalRounds; i++) {
            System.out.print("\nRound " + (i + 1) + " - Enter your move (Rock, Paper, Scissors): ");
            String playerMove = scanner.nextLine().trim();


            String computerMove = moves[random.nextInt(3)];


            String result = playRound(playerMove, computerMove);


            playerHistory[i] = playerMove;
            computerHistory[i] = computerMove;
            resultHistory[i] = result;


            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Computer chose: " + computerMove + " -> " + result);
        }


        double winPercentage = ((double) wins / totalRounds) * 100;


        System.out.println("\n-----------------------------------------------------");
        System.out.printf("%-8s | %-12s | %-13s | %-12s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-8d | %-12s | %-13s | %-12s\n",
                    (i + 1), playerHistory[i], computerHistory[i], resultHistory[i]);
        }
        System.out.println("-----------------------------------------------------");


        System.out.printf("Final Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n",
                wins, losses, draws, winPercentage);

        scanner.close();
    }
}