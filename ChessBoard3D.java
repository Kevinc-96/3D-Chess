import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class ChessBoard3D extends Board {
    Tile begin;

    public ChessBoard3D(Player player1, Player player2) {
        board3D = new ChessBoard[3];
        frame3D = new JFrame();
        panel3D = new JPanel();
        board3D[0] = new ChessBoard(player1, player2, 0);
        board3D[1] = new ChessBoard(player1, player2, 1);
        board3D[2] = new ChessBoard(player1, player2, 2);
        whitePieces = new Piece[16];
        blackPieces = new Piece[16];
        playerW = player1;
        playerB = player2;
        turn = playerW;
        begin = null;
    }

    public void initialize3DGame() {
        board3D[0].createTiles(8, this);
        board3D[0].createPieces(8, 16);
        board3D[1].createTiles(8, this);
        board3D[2].createTiles(8, this);

        panel3D.setLayout(new GridLayout(0, 3));
        panel3D.add(board3D[0].getJPanel());
        panel3D.add(board3D[1].getJPanel());
        panel3D.add(board3D[2].getJPanel());

        frame3D.add(panel3D);
        frame3D.setTitle("CHESS");
        frame3D.setLayout(new GridLayout(0, 1));
        frame3D.setSize(2000, 500);
        frame3D.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame3D.setVisible(true);
    }

    @Override
    public void createPieces(int size, int pieces) {
        // TODO Auto-generated method stub
    }

    public void actionPerformed(ActionEvent e) {
        tile = (Tile) e.getSource();
        int d;
        Tile[][] startLevelTiles;
        System.out.println("Tile: Row " + tile.getRow() + ", Col " + tile.getColumn() + ", Level " + tile.getLevel());

        if (start == null) {
            if (board3D[tile.getLevel()].validateInitialTile(tile)) {
                start = tile;
            }
        } else {
            if (start.getLevel() == tile.getLevel()) {
                board3D[tile.getLevel()].setStart(start);
                board3D[tile.getLevel()].setTile(tile);
                board3D[tile.getLevel()].move();
            } else {
                d = Math.abs(tile.getLevel() - start.getLevel());
                startLevelTiles = board3D[start.getLevel()].getTiles();
                if (start.getPiece().validate3DMove(startLevelTiles, start, tile, d, start.getPiece().getSide())) {
                    board3D[tile.getLevel()].setStart(start);
                    board3D[tile.getLevel()].setTile(tile);
                    board3D[tile.getLevel()].move3D(start, tile, d);
                }
            }
            start = null;
        }
        for (int i = 0; i < 3; i++) {
            if (board3D[tile.getLevel()].getLevel() != i) {
                board3D[i].setTurn(board3D[tile.getLevel()].getTurn());
            }
        }
    }

    @Override
    public void displayMovedPiece(Tile target) {
        // TODO Auto-generated method stub
    }

    @Override
    public void adjustTurn() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isValidMove(Tile start, Tile end) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean validateInitialTile(Tile start) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean checkFriendly(Tile start, Tile end) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void movePiece(Tile start, Tile end) {
    }

    @Override
    public boolean checkSameTile(Tile first, Tile second) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void eat(Tile start, Tile end) {
        // TODO Auto-generated method stub

    }

    @Override
    public void evaluateWinner() {
        // TODO Auto-generated method stub

    }

    @Override
    public void disableBoard() {
        // TODO Auto-generated method stub
    }

}
