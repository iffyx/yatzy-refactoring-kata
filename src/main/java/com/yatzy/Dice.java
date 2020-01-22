package com.yatzy;

public class Dice {
    private int rollResult;

    public Dice(int numberToRoll) {
        rollResult = numberToRoll;
    }

    public int getRollResult() {
        return rollResult;
    }

    public void setRollResult(int rollResult) {
        this.rollResult = rollResult;
    }

    public void throwDice() {
        // Random dice throw.
    }
}

