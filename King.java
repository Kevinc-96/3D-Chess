public class King extends Piece {

    public King(PieceType type, Side side, int index) {
        super(type, side, index);
        this.type = type;
        this.side = side;
        this.index = index;
        this.firstMove = true;
        this.typeString = super.typeString;
        this.maxDistance = 1;
    }

    public boolean validateTargetTile(Tile[][] tiles, Tile start, Tile end) {
        if ((Math.abs(start.getRow() - end.getRow()) > maxDistance)) {
            return false;
        }

        if ((Math.abs(start.getColumn() - end.getColumn()) > maxDistance)) {
            return false;
        }
        return true;
    }
    
}
