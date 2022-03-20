public class Bishop extends Piece {

    public Bishop(PieceType type, Side side, int index) {
        super(type, side, index);
        this.type = type;
        this.side = side;
        this.index = index;
        this.firstMove = true;
        this.typeString = super.typeString;
    }

    public boolean validateTargetTile(Tile[][] tiles, Tile start, Tile end) {
        if (start.getRow() != end.getRow() && start.getColumn() != end.getColumn()) {
            if ((Math.abs(start.getRow() - end.getRow()) < maxDistance) && (Math.abs(start.getColumn() - end.getColumn()) < maxDistance)) {
                if (Math.abs(start.getRow() - end.getRow()) == Math.abs(start.getColumn() - end.getColumn())) {

                    if (start.getRow() > end.getRow()) {
                        if (start.getColumn() < end.getColumn()) {
                            for (int r = start.getRow() - 1, c = start.getColumn() + 1; ((r > end.getRow()) || (c < end.getColumn())); r--, c++) {
                                if (tiles[r][c].checkOccupy()) {
                                    return false;
                                }
                            }
                        } else {
                            for (int r = start.getRow() - 1, c = start.getColumn() - 1; ((r > end.getRow()) || (c > end.getColumn())); r--, c--) {
                                if (tiles[r][c].checkOccupy()) {
                                    return false;
                                }
                            }
                        }
                    } else {
                        if (start.getColumn() < end.getColumn()) {
                            for (int r = start.getRow() + 1, c = start.getColumn() + 1; ((r < end.getRow()) || (c < end.getColumn())); r++, c++) {
                                if (tiles[r][c].checkOccupy()) {
                                    return false;
                                }
                            }
                        } else {
                            for (int r = start.getRow() + 1, c = start.getColumn() - 1; ((r < end.getRow()) || (c > end.getColumn())); r++, c--) {
                                if (tiles[r][c].checkOccupy()) {
                                    return false;
                                }
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

}
