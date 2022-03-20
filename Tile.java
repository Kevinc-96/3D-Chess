import javax.swing.JButton;

public class Tile extends JButton {

    private Boolean occupy;
    private int x;
    private int y;
    private int z;
    private Piece piece;

    public Tile(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        occupy = false;
    }
    
    public int getColumn() {
        return y;
    }

    public int getRow() {
        return x;
    }

    public int getLevel() {
        return z;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        occupy = true;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean checkOccupy() {
        return occupy;
    }

    public void removePiece() {
        occupy = false;
        this.piece = null;
    }
}