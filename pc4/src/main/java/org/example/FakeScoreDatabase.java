package org.example;

public class FakeScoreDatabase {
    private int score;

    public void saveScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}

