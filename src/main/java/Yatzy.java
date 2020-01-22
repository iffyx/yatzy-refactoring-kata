import java.util.ArrayList;
import java.util.List;

public class Yatzy {

    protected List<Integer> dicesResults;

    public Yatzy(List<Integer> dicesResults) {
        this.dicesResults = new ArrayList<>();
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
        int[] tallies = new int[6];
        for (Integer result : dicesResults) {
            tallies[result - 1]++;
        }
        for (int i = 0; i < 6; i++)
            if (tallies[i] == 5)
                return 50;
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
        int[] tallies = new int[6];
        for (Integer result : dicesResults) {
            tallies[result - 1]++;
        }
        for (int i = 5; i >= 0; i--)
            if (tallies[i] >= kindNumber)
                return (i + 1) * kindNumber;
        return 0;
    }

    public int twoPair(List<Integer> dicesResults) {
        int[] tallies = new int[6];
        for (Integer result : dicesResults) {
            tallies[result - 1]++;
        }
        int n = 0;
        int score = 0;
        for (int i = 5; i >= 0; i--)
            if (tallies[i] >= 2) {
                n++;
                score += (i + 1);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public int smallStraight(List<Integer> dicesResults) {
        int[] tallies = new int[6];
        for (Integer result : dicesResults) {
            tallies[result - 1]++;
        }
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    public int largeStraight(List<Integer> dicesResults) {
        int[] tallies = new int[6];
        for (Integer result : dicesResults) {
            tallies[result - 1]++;
        }
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public int fullHouse(List<Integer> dicesResults) {
        int[] tallies = new int[6];
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        for (Integer result : dicesResults) {
            tallies[result - 1]++;
        }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



