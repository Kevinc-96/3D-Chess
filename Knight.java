public class Knight extends Piece {

    public Knight(PieceType type, Side side, int index) {
        super(type, side, index);
        this.type = type;
        this.side = side;
        this.index = index;
        this.firstMove = true;
        this.typeString = super.typeString;
        this.maxDistance = 3;
    }

    public boolean validateTargetTile(Tile[][] tiles, Tile start, Tile end) {
        if (Math.abs(start.getRow() - end.getRow()) == 2) {
            if (Math.abs(start.getColumn() - end.getColumn()) == 1) {
                return true;
            }
        }
        if (Math.abs(start.getColumn() - end.getColumn()) == 2) {
            if (Math.abs(start.getRow() - end.getRow()) == 1) {
                return true;
            }
        }
        return false;
    }
    
}
