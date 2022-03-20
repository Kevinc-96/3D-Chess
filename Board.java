import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JFrame;

public abstract class Board implements ActionListener {
    Game game;
    Tile tiles[][];
    Piece whitePieces[];
    Piece blackPieces[];
    Player playerW;
    Player playerB;
    Color black = new Color(255, 255, 255);
    Color white = new Color(0, 0, 0);
    Color dark = new Color(95, 75, 139);
    Color light = new Color(230, 154, 141);
    JPanel chessPanel;

    Board[] board3D;
    JFrame frame3D;
    JPanel panel3D;

    int level;
    public Tile tile;
    public Tile start = null;
    public Piece piece;
    public Piece eaten;
    public Player turn = playerW;

    public Board(){}

    public int getLevel() {
        return level;
    }

    public void initialize3DGame(){}

    public JPanel getJPanel() {
        return chessPanel;
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public void setStart(Tile input) {
        this.start = input;
    }

    public void setTile(Tile input) {
        this.tile = input;
    }

    public Tile[][] getTiles() {
        return this.tiles;
    }

    public void createTiles(int size, ChessBoard3D chess){}

    public abstract void createPieces(int size, int pieces);

    public abstract void actionPerformed(ActionEvent e);

    public void actionPerformed3D(ActionEvent e){};

    public abstract void displayMovedPiece(Tile target);

    public abstract void adjustTurn();

    public void setTurn(Player player){
        this.turn = player;
    }

    public Player getTurn() {
        return this.turn;
    }

    public void move(){};

    public void move3D(Tile start, Tile tile, int d){};

    public abstract boolean isValidMove(Tile start, Tile end);

    public boolean validateInitialTile(Tile start){
        return true;
    };

    public abstract boolean checkFriendly(Tile start, Tile end);

    public abstract void movePiece(Tile start, Tile end);

    public abstract boolean checkSameTile(Tile first, Tile second);

    public abstract void eat(Tile start, Tile end);

    public void banish(Piece piece){}

    public abstract void evaluateWinner();

    public abstract void disableBoard();

}
