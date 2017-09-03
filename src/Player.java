public class Player {
    private Hand hand;
    private Boolean yatzy = false;
    private int score = 0;

    public Player() {
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Boolean getYatzy() {
        return yatzy;
    }

    public void setYatzy(Boolean yatzy) {
        this.yatzy = yatzy;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score+=score;
        System.out.println("Added " + score + " points!, Total is now: " + this.score);
    }
}
