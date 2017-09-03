public class GameEngine {

    Player playerOne;
    Player playerTwo;
    GameLogic logic;

    public GameEngine() {
        playerOne = new Player();
        playerTwo = new Player();

        logic = new GameLogic(playerOne, playerTwo);
    }

    public void play(){
        logic.play();
    }

}
