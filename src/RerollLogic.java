import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RerollLogic {

    public void prepareRerollNumberTurn(Dice[] dices, int number) {
        for (Dice dice : dices) {
            if (dice.getValue() == number) {
                dice.setKeep(true);
            }
        }
    }

    public void prepareRerollOnePair(Dice[] dices) {
        Set<Integer> foundValues = new HashSet<>();
        int valueToKeep = 0;
        int keptDices = 0;
        for (Dice dice : dices) {
            if (foundValues.contains(dice.getValue()) && dice.getValue() > valueToKeep)
                valueToKeep = dice.getValue();
            foundValues.add(dice.getValue());
        }
        for (Dice dice : dices) {
            if (dice.getValue() == valueToKeep && keptDices < 2) {
                dice.setKeep(true);
                keptDices++;
            }
        }

    }

    public void prepareRerollTwoPairs(Dice[] dices) {
        Set<Integer> foundValues = new HashSet<>();
        int valueToKeepOne = 0;
        int valueToKeepTwo = 0;
        int keptDicesOne = 0;
        int keptDicesTwo = 0;
        for (Dice dice : dices) {
            if (foundValues.contains(dice.getValue())) {
                if (dice.getValue() > valueToKeepOne) {
                    valueToKeepOne = dice.getValue();
                } else if (dice.getValue() > valueToKeepTwo) {
                    if (dice.getValue() == valueToKeepOne) {
                        if (Collections.frequency(foundValues, dice.getValue()) == 3) {
                            valueToKeepTwo = dice.getValue();
                        }
                    } else {
                        valueToKeepTwo = dice.getValue();
                    }
                }
            }
            foundValues.add(dice.getValue());
        }

        for (Dice dice : dices) {
            if (dice.getValue() == valueToKeepOne && keptDicesOne < 2) {
                dice.setKeep(true);
                keptDicesOne++;
            }
        }

        for (Dice dice : dices) {
            if (dice.getValue() == valueToKeepTwo && keptDicesTwo < 2) {
                dice.setKeep(true);
                keptDicesTwo++;
            }
        }
    }

    public void prepareRerollThreeOfAKind(Dice[] dices) {
        keepMost(dices);
    }

    public void prepareRerollFourOfAKind(Dice[] dices) {
        keepMost(dices);
    }

    public void keepMost(Dice[] dices){
        Set<Integer> foundValues = new HashSet<>();
        int valueToKeep = 0;
        int numberOfValues = 0;
        for (Dice dice : dices)
            foundValues.add(dice.getValue());
        for(int i = 6; i > 0; i--){
            if (Collections.frequency(foundValues, i) > numberOfValues){
                valueToKeep = i;
                numberOfValues = Collections.frequency(foundValues, i);
            }
        }

        for(Dice dice : dices){
            if(dice.getValue() == valueToKeep)
                dice.setKeep(true);
        }
    }

    public void prepareRerollSmallStraight(Dice[] dices){
        Set<Integer> foundDesiredValues = new HashSet<>();
        for (Dice dice : dices){
            if ( dice.getValue() < 6){
                if (!foundDesiredValues.contains(dice.getValue())) {
                    foundDesiredValues.add(dice.getValue());
                    dice.setKeep(true);
                }
            }
        }

    }

    public void prepareRerollLargeStraight(Dice[] dices){
        Set<Integer> foundDesiredValues = new HashSet<>();
        for (Dice dice : dices){
            if ( dice.getValue() > 1){
                if (!foundDesiredValues.contains(dice.getValue())) {
                    foundDesiredValues.add(dice.getValue());
                    dice.setKeep(true);
                }
            }
        }
    }

    public void prepareRerollFullHouse(Dice[] dices){
        Set<Integer> foundValues = new HashSet<>();
        int valueToKeepOne = 0;
        int valueToKeepTwo = 0;
        for (Dice dice : dices) {
            if (foundValues.contains(dice.getValue())) {
                if (dice.getValue() > valueToKeepOne) {
                    valueToKeepOne = dice.getValue();
                } else if (dice.getValue() > valueToKeepTwo && dice.getValue() != valueToKeepOne) {
                    valueToKeepTwo = dice.getValue();
                }
            }
            foundValues.add(dice.getValue());
        }

        for (Dice dice : dices) {
            if (dice.getValue() == valueToKeepOne )
                dice.setKeep(true);
        }

        for (Dice dice : dices) {
            if (dice.getValue() == valueToKeepTwo )
                dice.setKeep(true);
        }
    }

    public void keepAboveThree(Dice[] dices){
        for (Dice dice : dices){
            if (dice.getValue() > 3)
                dice.setKeep(true);
        }
    }



}
