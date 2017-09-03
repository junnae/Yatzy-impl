import java.util.Arrays;
import java.util.Collections;

public class Turn {

    Player player;
    Hand hand;
    Dice[] dices;
    RerollLogic reroll;

    public int playTurn(Player player, int turnNumber) {
        this.player = player;
        hand = player.getHand();
        hand.resetDices();
        reroll = new RerollLogic();
        if (player.getYatzy()){
            turnNumber--;
        }
        if(rollAndCheckYatzy())
            return 50;

        switch (turnNumber) {
            case 1:
                return playFirstTurn();
            case 2:
                return playSecondTurn();
            case 3:
                return playThirdTurn();
            case 4:
                return playFourthTurn();
            case 5:
                return playFifthTurn();
            case 6:
                return playSixthTurn();
            case 7:
                return playSeventhTurn();
            case 8:
                return playEightTurn();
            case 9:
                return playNinthTurn();
            case 10:
                return playTenthTurn();
            case 11:
                return playEleventhTurn();
            case 12:
                return playTwelwthTurn();
            case 13:
                return playThirteenthTurn();
            case 14:
                return playFourteenthTurn();
            case 15:
                return playFifteenthturn();
            default:
                return 0;
        }

    }

    public boolean checkYatzy(){
        if (player.getYatzy())
            return false;
        for (int i = 1; i < 5; i++){
            if (dices[i].getValue() != dices[i-1].getValue())
                return false;
        }
        System.out.println("|**********************************************|");
        System.out.println("                !!!!YATZY!!!!                   ");
        System.out.println("|**********************************************|");
        player.setYatzy(true);
        return true;
    }

    public int playNumberTurn(int number){
        System.out.println("Goal: Get " + number + "'s");
        reroll.prepareRerollNumberTurn(dices, number);
        if (rollAndCheckYatzy())
            return 50;
        int hits = 0;
        for (Dice dice : dices){
            if(dice.getValue() == number){
                hits++;
            }
        }
        return number * hits;
    }


    public int playFirstTurn() {
        return playNumberTurn(1);
    }


    public int playSecondTurn() {
        return playNumberTurn(2);
    }


    public int playThirdTurn() {
        return playNumberTurn(3);
    }


    public int playFourthTurn() {
        return playNumberTurn(4);
    }


    public int playFifthTurn() {
        return playNumberTurn(5);
    }


    public int playSixthTurn() {
        return playNumberTurn(6);
    }


    public int playSeventhTurn() {
        System.out.println("Goal: Highest pair");
        reroll.prepareRerollOnePair(dices);
        if (rollAndCheckYatzy())
            return 50;
        Integer[] diceValues = hand.getValues();
        for (int i = 0; i < diceValues.length -1; i++){
            if (diceValues[i] == diceValues[i+1])
                return diceValues[i] * 2;
        }
        return 0;
    }


    public int playEightTurn() {
        System.out.println("Goal: Two pairs");
        reroll.prepareRerollTwoPairs(dices);
        if (rollAndCheckYatzy())
            return 50;
        Integer[] diceValues = hand.getValues();
        boolean onePairFound = false;
        int score = 0;
        for (int i = 0; i < diceValues.length -1; i++){
            if (diceValues[i] == diceValues[i+1]) {
                score += diceValues[i] * 2;
                if (onePairFound){
                    return score;
                }
                else {
                    onePairFound = true;
                    //Same dice can't be part of two pairs
                    i++;
                }
            }
        }
        return 0;
    }


    public int playNinthTurn() {
        System.out.println("Goal: Three of a kind");
        reroll.prepareRerollThreeOfAKind(dices);
        if (rollAndCheckYatzy())
            return 50;
        Integer[] diceValues = hand.getValues();
        for (int i = 0; i < diceValues.length - 2; i++){
            if (diceValues[i] == diceValues[i+1] && diceValues[i] == diceValues[i+2])
                return diceValues[i] * 3;
        }
        return 0;
    }


    public int playTenthTurn() {
        System.out.println("Goal: Four of a Kind");
        reroll.prepareRerollFourOfAKind(dices);
        if (rollAndCheckYatzy())
            return 50;
        Integer[] diceValues = hand.getValues();
        for (int i = 0; i < diceValues.length - 3; i++){
            if (diceValues[i] == diceValues[i+1] && diceValues[i] == diceValues[i+2] && diceValues[i] == diceValues[i+3])
                return diceValues[i] * 4;
        }
        return 0;
    }


    public int playEleventhTurn() {
        System.out.println("Goal: Small Straight");
        reroll.prepareRerollSmallStraight(dices);
        if (rollAndCheckYatzy())
            return 50;
        Integer[] diceValues = hand.getValues();
        for (int i = 0; i < diceValues.length; i++){
            if (diceValues[i] != (5 - i)){
                return 0;
            }
        }
        return 5+4+3+2+1;
    }


    public int playTwelwthTurn() {
        System.out.println("Goal: Large Straight");
        reroll.prepareRerollLargeStraight(dices);
        if (rollAndCheckYatzy())
            return 50;
        Integer[] diceValues = hand.getValues();
        for (int i = 0; i < diceValues.length; i++){
            if (diceValues[i] != (6 - i)){
                return 0;
            }
        }
        return 6+5+4+3+2;
    }


    public int playThirteenthTurn() {
        System.out.println("Goal: Full House");
        reroll.prepareRerollFullHouse(dices);
        if (rollAndCheckYatzy())
            return 50;
        Integer[] values = hand.getValues();
        if ( values[0] == values[2] && values [3] == values[4])
            return (values[0] * 3) + (values[4] * 2) ;
        else if  ( values[0] == values[1] && values [2] == values[4])
            return (values[0] * 2) + (values[4] * 3) ;
        return 0;
    }

    public int playFourteenthTurn() {
        System.out.println("Goal: Chance");
        reroll.keepAboveThree(dices);
        if (rollAndCheckYatzy())
            return 50;
        int sum = 0;
        for(Dice dice : dices)
            sum += dice.getValue();
        return sum;
    }

    public int playFifteenthturn() {
        System.out.println("Goal: Yatzy");
        reroll.keepMost(dices);
        if (rollAndCheckYatzy())
            return 50;
        return 0;
    }

    private boolean rollAndCheckYatzy(){
        dices = hand.rollAllDices();
        return checkYatzy();
    }

}
