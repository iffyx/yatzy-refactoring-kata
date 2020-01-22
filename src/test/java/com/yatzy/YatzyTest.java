package com.yatzy;

import org.junit.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class YatzyTest {

    private Yatzy yatzy;
    @Before
    public void setUp(){
        yatzy = new Yatzy();
    }

    @Test
    public void chanceScoresSumOfAllDiceTest() {
        int expected = 15;
        int actual = yatzy.chance(createDicesList(2,3,4,5,1));
        assertEquals(expected, actual);
        assertEquals(16, yatzy.chance(createDicesList(3,3,4,5,1)));
    }


    @Test
    public void yatzyScores50Test() {
        int expected = 50;
        int actual = yatzy.yatzy(createDicesList(4,4,4,4,4));
        assertEquals(expected, actual);
        assertEquals(50, yatzy.yatzy(createDicesList(6,6,6,6,6)));
        assertEquals(0, yatzy.yatzy(createDicesList(6,6,6,6,3)));
    }

    @Test public void onesTest() {
        assertTrue(yatzy.sumOfAKind(createDicesList(1,2,3,4,5), 1) == 1);
        assertEquals(2, yatzy.sumOfAKind(createDicesList(1,2,1,4,5), 1));
        assertEquals(0, yatzy.sumOfAKind(createDicesList(6,2,2,4,5), 1));
        assertEquals(4, yatzy.sumOfAKind(createDicesList(1,2,1,1,1), 1));
    }

    @Test
    public void twosTest() {
        assertEquals(4, yatzy.sumOfAKind(createDicesList(1,2,3,2,6), 2));
        assertEquals(10, yatzy.sumOfAKind(createDicesList(2,2,2,2,2), 2));
    }

    @Test
    public void threesTest() {
        assertEquals(6, yatzy.sumOfAKind(createDicesList(1,2,3,2,3), 3));
        assertEquals(12, yatzy.sumOfAKind(createDicesList(2,3,3,3,3), 3));
    }

    @Test
    public void foursTest()
    {
        assertEquals(12, yatzy.sumOfAKind(createDicesList(4,4,4,5,5), 4));
        assertEquals(8, yatzy.sumOfAKind(createDicesList(4,4,5,5,5), 4));
        assertEquals(4, yatzy.sumOfAKind(createDicesList(4,5,5,5,5), 4));
    }

    @Test
    public void fivesTest() {
        assertEquals(10, yatzy.sumOfAKind(createDicesList(4,4,4,5,5), 5));
        assertEquals(15, yatzy.sumOfAKind(createDicesList(4,4,5,5,5), 5));
        assertEquals(20, yatzy.sumOfAKind(createDicesList(4,5,5,5,5), 5));
    }

    @Test
    public void sixesTest() {
        assertEquals(0, yatzy.sumOfAKind(createDicesList(4,4,4,5,5), 6));
        assertEquals(6, yatzy.sumOfAKind(createDicesList(4,4,6,5,5), 6));
        assertEquals(18, yatzy.sumOfAKind(createDicesList(6,5,6,6,5), 6));
    }

    @Test
    public void onePairTest() {
        assertEquals(6, yatzy.numberOfAKind(createDicesList(3,4,3,5,6), 2));
        assertEquals(10, yatzy.numberOfAKind(createDicesList(5,3,3,3,5), 2));
        assertEquals(12, yatzy.numberOfAKind(createDicesList(5,3,6,6,5), 2));
    }

    @Test
    public void twoPairTest() {
        assertEquals(16, yatzy.twoPair(createDicesList(3,3,5,4,5)));
        assertEquals(16, yatzy.twoPair(createDicesList(3,3,5,5,5)));
    }

    @Test
    public void threeOfAKind()
    {
        assertEquals(9, yatzy.numberOfAKind(createDicesList(3,3,3,4,5), 3));
        assertEquals(15, yatzy.numberOfAKind(createDicesList(5,3,5,4,5), 3));
        assertEquals(9, yatzy.numberOfAKind(createDicesList(3,3,3,3,5), 3));
    }

    @Test
    public void fourOfAKindTest() {
        assertEquals(12, yatzy.numberOfAKind(createDicesList(3,3,3,3,5), 4));
        assertEquals(20, yatzy.numberOfAKind(createDicesList(5,5,5,4,5), 4));
    }

    @Test
    public void smallStraightTest() {
        assertEquals(15, yatzy.straight(createDicesList(1,2,3,4,5), 4));
        assertEquals(15, yatzy.straight(createDicesList(2,3,4,5,1), 4));
        assertEquals(0, yatzy.straight(createDicesList(1,2,2,4,5), 4));
    }

    @Test
    public void largeStraightTest() {
        assertEquals(20, yatzy.straight(createDicesList(6,2,3,4,5), 5));
        assertEquals(20, yatzy.straight(createDicesList(2,3,4,5,6), 5));
        assertEquals(0, yatzy.straight(createDicesList(1,2,2,4,5), 5));
    }

    @Test
    public void fullHouseTest() {
        assertEquals(18, yatzy.fullHouse(createDicesList(6,2,2,2,6)));
        assertEquals(0, yatzy.fullHouse(createDicesList(2,3,4,5,6)));
    }

    public List<Dice> createDicesList(int dice1, int dice2, int dice3, int dice4, int dice5){
        List<Dice> dices = new ArrayList<>();
        dices.add(new Dice(dice1));
        dices.add(new Dice(dice2));
        dices.add(new Dice(dice3));
        dices.add(new Dice(dice4));
        dices.add(new Dice(dice5));

        return dices;
    }
}
