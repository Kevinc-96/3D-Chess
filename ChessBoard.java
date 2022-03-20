import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

public class ChessBoard extends Board {

    public ChessBoard(Player player1, Player player2, int level) {
        whitePieces = new Piece[16];
        blackPieces = new Piece[16];
        tiles = new Tile[8][8];
        chessPanel = new JPanel();
        playerW = player1;
        playerB = player2;
        turn = playerW;
        this.level = level;
    }

    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    public void setStart(Tile input) {
        this.start = input;
    }

    public void setTile(Tile input) {
        this.tile = input;
    }

    public void createTiles(int size, ChessBoard3D chess) {
        Color color;
        for (int i = 0; i < size; i++) {

            if (i % 2 != 0) {
                color = white;
            } else {
                color = black;
            }

            for (int j = 0; j < size; j++) {
                tile = new Tile(i, j, level);
                tiles[i][j] = tile;
                tile.setBackground(color);

                if (color == white) {
                    color = black;
                } else {
                    color = white;
                }
                tile.addActionListener(chess);
                chessPanel.add(tile);
            }
        }
        chessPanel.setLayout(new GridLayout(0, size));
    }

    public void createPieces(int size, int pieces) {
        int index = pieces - 1;
        for (int i = 0; i < 2; i++) {
            for (int a = 0; a < size; a++) {
                tile = tiles[i][a];
                tile.setForeground(dark);
                tile.setFont(new Font("Arial", Font.BOLD, 10));

                if (i == 1) {
                    piece = new Pawn(PieceType.PAWN, Side.BLACK, index);
                    tile.setText("PAWN");
                } else {
                    if (a == 0 || a == 7) {
                        piece = new Rook(PieceType.ROOK, Side.BLACK, index);
                        tile.setText("ROOK");
                    }

                    if (a == 1 || a == 6) {
                        piece = new Knight(PieceType.KNIGHT, Side.BLACK, index);
                        tile.setText("KNIGHT");
                    }

                    if (a == 2 || a == 5) {
                        piece = new Bishop(PieceType.BISHOP, Side.BLACK, index);
                        tile.setText("BISHOP");
                    }

                    if (a == 3) {
                        piece = new Queen(PieceType.QUEEN, Side.BLACK, index);
                        tile.setText("QUEEN");
                    }

                    if (a == 4) {
                        piece = new King(PieceType.KING, Side.BLACK, index);
                        tile.setText("KING");
                    }
                }
                tile.setPiece(piece);
                blackPieces[index] = piece;
                index--;
            }

        }

        index = 0;
        for (int i = 6; i < size; i++) {
            for (int a = 0; a < size; a++) {
                tile = tiles[i][a];
                tile.setForeground(light);
                tile.setFont(new Font("Arial", Font.BOLD, 10));
                if (i == 6) {
                    piece = new Pawn(PieceType.PAWN, Side.WHITE, index);
                    tile.setText("PAWN");
                } else {
                    if (a == 0 || a == 7) {
                        piece = new Rook(PieceType.ROOK, Side.WHITE, index);
                        tile.setText("ROOK");
                    }

                    if (a == 1 || a == 6) {
                        piece = new Knight(PieceType.KNIGHT, Side.WHITE, index);
                        tile.setText("KNIGHT");
                    }

                    if (a == 2 || a == 5) {
                        piece = new Bishop(PieceType.BISHOP, Side.WHITE, index);
                        tile.setText("BISHOP");
                    }

                    if (a == 3) {
                        piece = new Queen(PieceType.QUEEN, Side.WHITE, index);
                        tile.setText("QUEEN");
                    }

                    if (a == 4) {
                        piece = new King(PieceType.KING, Side.WHITE, index);
                        tile.setText("KING");
                    }
                }
                tile.setPiece(piece);
                whitePieces[index] = piece;
                index++;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        tile = (Tile) e.getSource();
        if (start == null) {
            if (validateInitialTile(tile)) {
                start = tile;
            }
        } else {
            move();
            start = null;
        }
    }

    public void move() {
        if (start.getPiece().validateTargetTile(this.tiles, start, tile)) {
            if (tile.checkOccupy()) {
                if (!checkSameTile(start, tile) && !checkFriendly(start, tile)) {
                    eaten = tile.getPiece();
                    eat(start, tile);
                    banish(eaten);
                    adjustTurn();
                    evaluateWinner();
                }
            } else {
                movePiece(start, tile);
                tile.getPiece().updateFirstMove();
                adjustTurn();
            }
            displayMovedPiece(tile);
        }
    }

    public void move3D(Tile start, Tile tile, int d){
            if (tile.checkOccupy()) {
                if (!checkSameTile(start, tile) && !checkFriendly(start, tile)) {
                    eaten = tile.getPiece();
                    eat(start, tile);
                    banish(eaten);
                    adjustTurn();
                    // evaluateWinner();
                }
            } else {
                movePiece(start, tile);
                tile.getPiece().updateFirstMove();
                adjustTurn();
            }
            displayMovedPiece(tile);
    };


    public void displayMovedPiece(Tile target) {
        if (target.getPiece().getSide() == Side.BLACK) {
            target.setForeground(dark);
        } else {
            target.setForeground(light);
        }
        target.setFont(new Font("Arial", Font.BOLD, 10));
    }

    public void adjustTurn() {
        if (turn == playerW) {
            turn = playerB;
        } else {
            turn = playerW;
        }
    }

    public boolean isValidMove(Tile start, Tile end) {
        if (!checkSameTile(tile, start)) {
            if (tile.checkOccupy()) {
                if (checkFriendly(start, tile)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validateInitialTile(Tile start) {
        if (start.checkOccupy() && (start.getPiece().getSide() == turn.getPlayerSide())) {
            return true;
        }
        return false;
    }

    public boolean checkFriendly(Tile start, Tile end) {
        if (start.getPiece().getSide() == end.getPiece().getSide()) {
            return true;
        }
        return false;
    }

    public void movePiece(Tile start, Tile end) {
        end.setPiece(start.getPiece());
        end.setText(start.getPiece().getTypeString());
        start.removePiece();
        start.setText("");
    }

    public boolean checkSameTile(Tile first, Tile second) {
        if (first.getColumn() == second.getColumn() && first.getRow() == second.getRow()) {
            return true;
        } else {
            return false;
        }
    }

    public void eat(Tile start, Tile end) {
        end.removePiece();
        end.setPiece(start.getPiece());
        end.getPiece().updateFirstMove();
        end.setText(start.getPiece().getTypeString());
        start.removePiece();
        start.setText("");
    }

    public void banish(Piece piece) {
        if (piece.getSide() == playerW.getPlayerSide()) {
            playerW.getGraveyard().addPiece(piece);
            whitePieces[piece.getIndex()] = null;
        } else {
            playerB.getGraveyard().addPiece(piece);
            blackPieces[piece.getIndex()] = null;
        }
        System.out.println(piece.getSide() + " " + piece.getType() + " banished.");
    }

    public void evaluateWinner() {
        boolean white = true;
        boolean black = true;

        for (int i = 0; i < 16; i++) {
            if (whitePieces[i] != null) {
                white = false;
            }
            if (blackPieces[i] != null) {
                black = false;
            }
        }
        if (white == true) {
            game.setWinner(playerB);
            disableBoard();
        }
        if (black == true) {
            game.setWinner(playerW);
            disableBoard();
        }
    }

    public void disableBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tiles[i][j].removeActionListener(this);
                if (game.getWinner().getPlayerSide() != Side.WHITE) {
                    tiles[i][j].setBackground(white);
                } else if (game.getWinner().getPlayerSide() != Side.BLACK) {
                    tiles[i][j].setBackground(black);
                }
            }
        }
    }
}