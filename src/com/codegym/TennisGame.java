package com.codegym;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int playerScore1, int playerScore2) {
        StringBuilder score = new StringBuilder();
        if (playerScore1 == playerScore2) {
            score = getStringBuilder(playerScore1);
        } else if (playerScore1 >= 40 || playerScore2 >= 40) {
            score = getStringBuilder(playerScore1, playerScore2);
        } else {
            extracted(playerScore1, playerScore2, score);
        }
        return score.toString();
    }

    private static void extracted(int playerScore1, int playerScore2, StringBuilder score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = playerScore1;
            else {
                score.append("-");
                tempScore = playerScore2;}
            switch (tempScore) {
                case 0 -> score.append("Love");
                case 1 -> score.append("Fifteen");
                case 2 -> score.append("Thirty");
                case 3 -> score.append("Forty");
            }
        }
    }

    private static StringBuilder getStringBuilder(int playerScore1, int playerScore2) {
        StringBuilder score;
        int minusResult = playerScore1 - playerScore2;
        if (minusResult == 1)
            score = new StringBuilder("Advantage for player1");
        else if (minusResult == -1)
            score = new StringBuilder("Advantage for player2");
        else if (minusResult >= 2)
            score = new StringBuilder("Victory for player1");
        else score = new StringBuilder("Victory for player2");
        return score;
    }

    private static StringBuilder getStringBuilder(int playerScore1) {
        StringBuilder score;
        score = new StringBuilder(switch (playerScore1) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            case 3 -> "Forty-All";
            default -> "Deuce";
        });
        return score;
    }
}