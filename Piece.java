public abstract class Piece {

    PieceType type;
    String typeString;
    Side side;
    int index;
    int x;
    int y;
    int maxDistance;
    boolean firstMove;

    public Piece(PieceType type, Side side, int index) {
        this.type = type;
        this.side = side;
        this.index = index;
        this.maxDistance = 8;
        this.firstMove = true;
        switch (type) {

        case ROOK:
            typeString = "ROOK";
            break;

        case KNIGHT:
            typeString = "KNIGHT";
            break;

        case BISHOP:
            typeString = "BISHOP";
            break;

        case QUEEN:
            typeString = "QUEEN";
            break;

        case KING:
            typeString = "KING";
            break;

        default:
            typeString = "PAWN";
            break;
        }
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public String getTypeString() {
        return typeString;
    }

    public PieceType getType() {
        return type;
    }

    public Side getSide() {
        return side;
    }

    public int getIndex() {
        return index;
    }

    public Boolean isFirstMove() {
        return firstMove;
    }
    
    public void updateFirstMove() {
        firstMove = false;
    }    

    public void setMaxDistance(int d) {
        this.maxDistance = d;
    }

    public boolean validate3DMove(Tile[][] tiles, Tile start, Tile end, int d, Side side) {
        return true;
    }

    public abstract boolean validateTargetTile(Tile[][] tiles, Tile start, Tile end);
}
