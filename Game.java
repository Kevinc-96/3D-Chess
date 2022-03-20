public class Game {

    public Games game;
    public Player winner;
    public Board gameBoard;
    public Player playerw;
    public Player playerb;
    
    public Game(Games game) {
        this.game = game;
    }

    public void createBoard(Games game) {
        if (game == Games.CHESS) {
            gameBoard = new ChessBoard3D(playerw, playerb);
        }
    }

    public Board getBoard() {
        return gameBoard;
    }

    public void createPlayers() {
        playerw = new Player(Side.WHITE, new Graveyard(Side.WHITE), "Player 1");
        playerb = new Player(Side.BLACK, new Graveyard(Side.BLACK), "Player 2");
    }

    public void setWinner(Player player) {
        this.winner = player;
        System.out.println("GAME OVER");
        System.out.println("Winner is " + winner.getName());
    }

    public Player getWinner() {
        return winner;
    }

    public static void main(String[] args) {
        Game myGame = new Game(Games.CHESS);
        myGame.createPlayers();
        myGame.createBoard(Games.CHESS);
        myGame.getBoard().initialize3DGame();
    }
}
