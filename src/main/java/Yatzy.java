import java.util.ArrayList;
import java.util.List;

public class Yatzy {

    public static final int YATZY_SCORE = 50;

    protected List<Integer> dicesResults;

    public Yatzy(List<Integer> dicesResults) {
        this.dicesResults = dicesResults;
    }

    public int chance(List<Integer> dicesResults) {
        int sum = 0;
        for (Integer result : dicesResults) {
            sum += result;
        }
        return sum;
    }

    public int yatzy(List<Integer> dicesResults) {
        int[] tallies = getTallies(dicesResults);
        for (int i = 5; i >= 0; i--)
            if (tallies[i] == 5)
                return YATZY_SCORE;
        return 0;
    }

    public int twoPair(List<Integer> dicesResults) {
        int[] tallies = getTallies(dicesResults);
        int numberOfPairs = 0;
        int score = 0;
        for (int i = 5; i >= 0; i--)
            if (tallies[i] >= 2) {
                numberOfPairs++;
                score += (i + 1);
            }
        if (numberOfPairs == 2)
            return score * 2;
        else
            return 0;
    }

    public int sumsOfAKind(List<Integer> dicesResults, int kindNumber) {
        int sum = 0;
        for (Integer result : dicesResults) {
            if (result == kindNumber) sum += kindNumber;
        }
        return sum;
    }

    public int numberOfAKind(List<Integer> dicesResults, int kindNumber) {
        int[] tallies = getTallies(dicesResults);
        for (int i = 5; i >= 0; i--)
            if (tallies[i] >= kindNumber)
                return (i + 1) * kindNumber;
        return 0;
    }

    public int straight(List<Integer> dicesResults, int highestDiceResult) {
        int[] tallies = getTallies(dicesResults);
        if (isStraight(tallies, highestDiceResult))
            return (highestDiceResult - 2) * 5;
        return 0;
    }
    
    public int fullHouse(List<Integer> dicesResults) {
        int[] tallies = getTallies(dicesResults);
        boolean pairOccurs, threeOccurs;
        pairOccurs = threeOccurs = false;
        int pairDiceValue, threeDiceValue;
        pairDiceValue = threeDiceValue = 0;

        for (int i = 5; i >= 0; i--) {
            if (tallies[i] == 2) {
                pairOccurs = true;
                pairDiceValue = i + 1;
            } else if (tallies[i] == 3) {
                threeOccurs = true;
                threeDiceValue = i + 1;
            }
        }

        if (pairOccurs && threeOccurs)
            return pairDiceValue * 2 + threeDiceValue * 3;

        return 0;
    }

    private int[] getTallies(List<Integer> dicesResults) {
        int[] tallies = new int[6];
        for (Integer result : dicesResults) {
            tallies[result - 1]++;
        }
        return tallies;
    }

    private boolean isStraight(int[] tallies, int highestDiceResult){
        return tallies[highestDiceResult] == 1 &&
                tallies[highestDiceResult - 1] == 1 &&
                tallies[highestDiceResult - 2] == 1 &&
                tallies[highestDiceResult - 3] == 1 &&
                tallies[highestDiceResult - 4] == 1;
    }
}



