public class Pawn extends Piece{

    public Pawn(PieceType type, Side side, int index) {
        super(type, side, index);
        this.type = type;
        this.side = side;
        this.index = index;
        this.firstMove = true;
        this.typeString = super.typeString;
        this.maxDistance = 2;
    }

    public boolean validateTargetTile(Tile[][] tiles, Tile start, Tile end) {

        if ((Math.abs(start.getRow() - end.getRow()) > maxDistance)) {
            return false;
        }

        if (start.getColumn() != end.getColumn()) {
            return false;
        }

        if (this.side == Side.BLACK) {
            if (start.getRow() > end.getRow()) {
                return false;
            } else {
                for (int i = start.getRow() + 1; i < end.getRow(); i++) {
                    if (tiles[i][start.getColumn()].checkOccupy()) {
                        return false;
                    } 
                }
            }

        } else {
            if (start.getRow() < end.getRow()) {
                return false;
            } else {
                for (int i = start.getRow() - 1; i > end.getRow(); i--) {
                    if (tiles[i][start.getColumn()].checkOccupy()) {
                        return false;
                    } 
                }
            }
        }
        return true;
    }

    public void updateFirstMove() {
        firstMove = false;
        this.maxDistance = 1;
    }

    public boolean validate3DMove(Tile[][] tiles, Tile start, Tile end, int d, Side side) {

        int distance = d;

        if (Math.abs(start.getLevel() - end.getLevel()) == 1) {
            distance = 1;
        }

        if (distance > maxDistance) {
            return false;
        }

        if ((Math.abs(start.getRow() - end.getRow()) > distance)) {
            return false;
        }

        if (start.getColumn() != end.getColumn()) {
            return false;
        }

        if (side == Side.BLACK) {
            if (start.getRow() > end.getRow()) {
                return false;
            }
        } else {
            if (start.getRow() < end.getRow()) {
                return false;
            }
        }
        return true;
    }

}
