import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int value;
    private boolean keep;

    public boolean isKeep() {
        return keep;
    }

    public void setKeep(boolean keep) {
        this.keep = keep;
        if(keep)
            System.out.println("Kept dice with value: " + value);
    }

    public void roll() {
        if (!keep)
            value = ThreadLocalRandom.current().nextInt(1, 7);
    }

    public int getValue() {
        return value;
    }
}
