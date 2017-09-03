import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Hand {
    private Dice[] dices;

    final static int numberOfDice = 5;

    public Hand() {
        dices = new Dice[numberOfDice];
        for (int i = 0; i < numberOfDice; i++)
            dices[i] = new Dice();
    }

    public Dice[] rollAllDices() {
        System.out.print("Rolled: ");
        for (Dice dice : dices) {
            dice.roll();
            System.out.print(" " + dice.getValue() + " ");
        }
        System.out.println();
        return dices;
    }

    public Integer[] getValues() {
        Integer[] values = new Integer[5];
        for (int i = 0; i < numberOfDice; i++)
            values[i] = dices[i].getValue();
        Arrays.sort(values, Collections.reverseOrder());
        return values;
    }

    public void resetDices() {
        for (Dice dice : dices)
            dice.setKeep(false);
    }

}
