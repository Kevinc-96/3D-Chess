public class Graveyard {

    Side side;
    int pieceIndex;
    Piece[] list;

    public Graveyard(Side side) {
        this.side = side;
        pieceIndex = 0;
        list = new Piece[16];
    }

    public void addPiece(Piece piece) {
        list[pieceIndex] = piece;
        pieceIndex++;
    }

    public Side getSide() {
        return side;
    }
}
