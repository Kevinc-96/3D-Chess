public class Rook extends Piece {

    public Rook(PieceType type, Side side, int index) {
        super(type, side, index);
        this.type = type;
        this.side = side;
        this.index = index;
        this.firstMove = true;
        this.typeString = super.typeString;
    }

    public boolean validateTargetTile(Tile[][] tiles, Tile start, Tile end) {
        int begin;
        int finish;

        // if moving vertically
        if (start.getRow() != end.getRow()) {
            if (start.getColumn() == end.getColumn()) {
                if ((Math.abs(start.getRow() - end.getRow()) < maxDistance)) {

                    // if moving down
                    if (start.getRow() < end.getRow()) {
                        begin = start.getRow();
                        finish = end.getRow();
                        // if moving up
                    } else {
                        begin = end.getRow();
                        finish = start.getRow();
                    }

                    for (int i = begin + 1; i < finish; i++) {
                        if (tiles[i][start.getColumn()].checkOccupy()) {
                            return false;
                        }
                    }
                    return true;
                }
            }

            // if moving horizontally
        } else if (start.getColumn() != end.getColumn()) {
            if (start.getRow() == end.getRow()) {
                if ((Math.abs(start.getColumn() - end.getColumn()) < maxDistance)) {

                    // if moving right
                    if (start.getColumn() < end.getColumn()) {
                        begin = start.getColumn();
                        finish = end.getColumn();
                        // if moving left
                    } else {
                        begin = end.getColumn();
                        finish = start.getColumn();
                    }
                    for (int i = begin + 1; i < finish; i++) {
                        if (tiles[start.getRow()][i].checkOccupy()) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

}
