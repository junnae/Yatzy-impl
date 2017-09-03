public class GameLogic {
    Turn turn;
    final static int NUMBER_OF_TURNS = 15;
    Player playerOne;
    Player playerTwo;
    public GameLogic(Player playerOne, Player playerTwo) {
         turn = new Turn();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void play(){
        for(int i = 1; i <= NUMBER_OF_TURNS; i++){
            System.out.println("Playing turn number: " + i);
            System.out.println("Player one's turn");
            playerOne.addScore(turn.playTurn(playerOne, i));
            System.out.println("Player two's turn");
            playerTwo.addScore(turn.playTurn(playerTwo, i));
        }
        System.out.println("Player one's Score is: " + playerOne.getScore());
        System.out.println("Player two's Score is: " + playerTwo.getScore());

        if (playerOne.getScore() > playerTwo.getScore())
            System.out.println("Player One is the Winner!");
         else if (playerOne.getScore() == playerTwo.getScore())
             System.out.println("It's a tie!");
         else if (playerTwo.getScore() > playerOne.getScore())
             System.out.println("Player Two is the Winner!");
         else
             System.out.println("Unexpected Result?!");

         if(playerOne.getYatzy())
             System.out.println("Player One got a Yatzy!");
        if(playerTwo.getYatzy())
            System.out.println("Player Two got a Yatzy!");


    }
}
