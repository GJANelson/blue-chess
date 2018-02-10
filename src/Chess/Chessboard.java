package Chess;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * Holds the GridPane and manages the pieces in the game chess.
 * @author Garth Nelson
 * @version 2018
 */
public class Chessboard {
    /** The amount of rows on the board. */
    private final int boardRows = 8;
    /** The GridPane that makes up the board. */
    private GridPane grid;
    /** An array of all tiles on the board. */
    private Tile[][] tiles;
    /** An array of the white pieces in the game. */
    private Piece[] whitePieces;
    /** An array of the black pieces in the game. */
    private Piece[] blackPieces;
    /** The piece currently being checked or moved. */
    private Piece activePiece;
    /** The last tile that was clicked. */
    private Tile lastClicked;
    /** Keeps track of the turns. 1 for black, 0 for white. */
    private int turn;
    
    /**
     * Constructs an object of type Chessboard.
     */
    public Chessboard() {
        final int totalPieces = 16;
        grid = new GridPane();
        tiles = new Tile[boardRows][boardRows];
        whitePieces = new Piece[totalPieces];
        blackPieces = new Piece[totalPieces];
        turn = 0;
        setBoard();
        setPieces();
    }
    
    /**
     * Sets up all the tiles on an 8 by 8 chessboard.
     */
    private void setBoard() {
        final int tileWidth = 100;
        for (int col = 0; col < tiles.length; col++) {
            for (int row = 0; row < tiles[col].length; row++) {
                Paint color;
                if ((col + row) % 2 == 0) {
                    color = Color.web("#00FFFB");
                } else {
                    color = Color.web("#767676");
                }
                tiles[col][row] = new Tile(tileWidth, tileWidth, 
                        color, col, row);
                tiles[col][row].setOnMouseClicked(this::selectTile);
                grid.add(tiles[col][row], col, row);
            }
        }
    }
    
    /**
     * Sets up chess pieces in their starting positions by calling
     * each Piece's set method.
     */
    private void setPieces() {
        setPawns();
        setRooks();
        setKnights();
        setBishops();
        setKings();
        setQueens();
        
        centerPieces();
    }
    
    /**
     * Sets up the Pawns in their starting positions.
     */
    private void setPawns() {
        final int blackPawnRow = 1;
        for (int i = 0; i < boardRows; i++) {
            blackPieces[i] = new Pawn(1, i, blackPawnRow);
            grid.add(blackPieces[i].getPieceLabel(), i, blackPawnRow);
            tiles[i][blackPawnRow].setOccupied(1);
        }
        final int whitePawnRow = 6;
        for (int i = 0; i < boardRows; i++) {
            whitePieces[i] = new Pawn(0, i, whitePawnRow);
            grid.add(whitePieces[i].getPieceLabel(), i, whitePawnRow);
            tiles[i][whitePawnRow].setOccupied(0);
        }
    }
    
    
    /**
     * Sets up the Rooks in their starting positions.
     */
    private void setRooks() {
        final int blackRow = 0;
        final int whiteRow = 7;
        final int rooksIndex = 8;
        final int rookStartX = 0;
        final int rookStartX2 = 7;
        
        blackPieces[rooksIndex] = new Rook(1, rookStartX, blackRow);
        grid.add(blackPieces[rooksIndex].getPieceLabel(), rookStartX, blackRow);
        tiles[rookStartX][blackRow].setOccupied(1);
        
        whitePieces[rooksIndex] = new Rook(0, rookStartX, whiteRow);
        grid.add(whitePieces[rooksIndex].getPieceLabel(), rookStartX, whiteRow);
        tiles[rookStartX][whiteRow].setOccupied(0);
        
        blackPieces[rooksIndex + 1] = new Rook(1, rookStartX2, blackRow);
        grid.add(blackPieces[rooksIndex + 1].getPieceLabel(), rookStartX2, blackRow);
        tiles[rookStartX2][blackRow].setOccupied(1);
        
        whitePieces[rooksIndex + 1] = new Rook(0, rookStartX2, whiteRow);
        grid.add(whitePieces[rooksIndex + 1].getPieceLabel(), rookStartX2, whiteRow);
        tiles[rookStartX2][whiteRow].setOccupied(0);
    }
    
    /**
     * Sets up the Knights in their starting positions.
     */
    private void setKnights() {
        final int blackRow = 0;
        final int whiteRow = 7;
        final int knightsIndex = 10;
        final int knightStartX = 1;
        final int knightStartX2 = 6;
        
        blackPieces[knightsIndex] = new Knight(1, knightStartX, blackRow);
        grid.add(blackPieces[knightsIndex].getPieceLabel(), knightStartX, blackRow);
        tiles[knightStartX][blackRow].setOccupied(1);
        
        whitePieces[knightsIndex] = new Knight(0, knightStartX, whiteRow);
        grid.add(whitePieces[knightsIndex].getPieceLabel(), knightStartX, whiteRow);
        tiles[knightStartX][whiteRow].setOccupied(0);
        
        blackPieces[knightsIndex + 1] = new Knight(1, knightStartX2, blackRow);
        grid.add(blackPieces[knightsIndex + 1].getPieceLabel(), knightStartX2, blackRow);
        tiles[knightStartX2][blackRow].setOccupied(1);
        
        whitePieces[knightsIndex + 1] = new Knight(0, knightStartX2, whiteRow);
        grid.add(whitePieces[knightsIndex + 1].getPieceLabel(), knightStartX2, whiteRow);
        tiles[knightStartX2][whiteRow].setOccupied(0);
    }
    
    /**
     * Sets up the Bishops in their starting positions.
     */
    private void setBishops() {
        final int blackRow = 0;
        final int whiteRow = 7;
        final int bishopsIndex = 12;
        final int bishopStartX = 2;
        final int bishopStartX2 = 5;
        
        blackPieces[bishopsIndex] = new Bishop(1, bishopStartX, blackRow);
        grid.add(blackPieces[bishopsIndex].getPieceLabel(), bishopStartX, blackRow);
        tiles[bishopStartX][blackRow].setOccupied(1);
        
        whitePieces[bishopsIndex] = new Bishop(0, bishopStartX, whiteRow);
        grid.add(whitePieces[bishopsIndex].getPieceLabel(), bishopStartX, whiteRow);
        tiles[bishopStartX][whiteRow].setOccupied(0);
        
        blackPieces[bishopsIndex + 1] = new Bishop(1, bishopStartX2, blackRow);
        grid.add(blackPieces[bishopsIndex + 1].getPieceLabel(), bishopStartX2, blackRow);
        tiles[bishopStartX2][blackRow].setOccupied(1);
        
        whitePieces[bishopsIndex + 1] = new Bishop(0, bishopStartX2, whiteRow);
        grid.add(whitePieces[bishopsIndex + 1].getPieceLabel(), bishopStartX2, whiteRow);
        tiles[bishopStartX2][whiteRow].setOccupied(0);
    }
    
    /**
     * Sets up the Kings in their starting positions.
     */
    private void setKings() {
        final int blackRow = 0;
        final int whiteRow = 7;
        final int kingsIndex = 14;
        final int kingStartX = 3;
        
        blackPieces[kingsIndex] = new King(1, kingStartX, blackRow);
        grid.add(blackPieces[kingsIndex].getPieceLabel(), kingStartX, blackRow);
        tiles[kingStartX][blackRow].setOccupied(1);
        
        whitePieces[kingsIndex] = new King(0, kingStartX, whiteRow);
        grid.add(whitePieces[kingsIndex].getPieceLabel(), kingStartX, whiteRow);
        tiles[kingStartX][whiteRow].setOccupied(0);
    }
    
    /**
     * Sets up the Queens in their starting positions.
     */
    private void setQueens() {
        final int blackRow = 0;
        final int whiteRow = 7;
        final int queensIndex = 15;
        final int queenStartX = 4;
        
        blackPieces[queensIndex] = new Queen(1, queenStartX, blackRow);
        grid.add(blackPieces[queensIndex].getPieceLabel(), queenStartX, blackRow);
        tiles[queenStartX][blackRow].setOccupied(1);
        
        whitePieces[queensIndex] = new Queen(0, queenStartX, whiteRow);
        grid.add(whitePieces[queensIndex].getPieceLabel(), queenStartX, whiteRow);
        tiles[queenStartX][whiteRow].setOccupied(0);
    }
    
    /**
     * Centers all of the pieces in the GridPane.
     */
    private void centerPieces() {
        for (int i = 0; i < blackPieces.length; i++) {
            GridPane.setValignment(blackPieces[i].getPieceLabel(), VPos.CENTER);
            GridPane.setHalignment(blackPieces[i].getPieceLabel(), HPos.CENTER);
        }
        for (int i = 0; i < whitePieces.length; i++) {
            GridPane.setValignment(whitePieces[i].getPieceLabel(), VPos.CENTER);
            GridPane.setHalignment(whitePieces[i].getPieceLabel(), HPos.CENTER);
        }
    }
    
    /**
     * retrieves the grid.
     * @return the GridPane of the board.
     */
    public GridPane getBoard() {
        return grid;
    }
    
    /**
     * Return the piece that is currently "on" the given tile.
     * @param tile the tile to compare for pieces
     * @return the piece on the tile. null if none.
     */
    public Piece getPiece(Tile tile) {
        if (tile.getOccupied() == 0) {
            for (int i = 0; i < whitePieces.length; i++) {
                if (whitePieces[i].getxPos() == tile.getxPos() 
                        && whitePieces[i].getyPos() == tile.getyPos()) {
                    return whitePieces[i];
                }
            }
        } else if (tile.getOccupied() == 1) {
            for (int i = 0; i < blackPieces.length; i++) {
                if (blackPieces[i].getxPos() == tile.getxPos() 
                        && blackPieces[i].getyPos() == tile.getyPos()) {
                    return blackPieces[i];
                }
            }
        } 
        return null;
    }
    
    /**
     * find and highlight all valid moves for the given piece.
     * @param piece the piece to check for
     */
    public void getValidMoves(Piece piece) {
        for (int col = 0; col < tiles.length; col++) {
            for (int row = 0; row < tiles[col].length; row++) {
                if (piece.validMove(tiles[col][row], 
                        whitePieces, blackPieces)) {
                    highlight(tiles[col][row]);
                }
            }
        }
    }
    
    /**
     * select a tile and the piece on it. Move to the clicked
     * tile if a piece has already been selected.
     * @param event the click.
     */
    public void selectTile(MouseEvent event) {
        unHighlightAll();
        if (activePiece == null 
                || !activePiece.validMove((Tile) event.getSource(), 
                        whitePieces, blackPieces)
                || activePiece.getColour() != turn) {
            highlight(((Tile) event.getSource()));
            lastClicked = (Tile) event.getSource();
            
            activePiece = getPiece((Tile) event.getSource());
        
            if (activePiece != null && activePiece.getColour() == turn) {
                getValidMoves(activePiece);
            }
        } else if (activePiece.validMove((Tile) event.getSource(), 
                whitePieces, blackPieces) 
                && activePiece.getColour() == turn) {
            move(activePiece, (Tile) event.getSource());
        }
    }
    
    /**
     * highlight the given tile.
     * @param clicked the tile clicked on
     */
    public void highlight(Tile tile) {
        if (tile.getOccupied() == turn) {
            tile.highlight(Color.GREEN);
        } else if (tile.getOccupied() != -1) {
            tile.highlight(Color.RED);
        } else {
            tile.highlight(Color.YELLOW);
        }
        
    }
    
    /**
     * Un-highlight all tiles on the board.
     */
    public void unHighlightAll() {
        for (int col = 0; col < tiles.length; col++) {
            for (int row = 0; row < tiles[col].length; row++) {
                tiles[col][row].unHighlight();
            }
        }
    }
    
    /**
     * Move a piece to a tile and kill the piece previously on the tile.
     * @param piece the piece to move
     * @param moveTo the tile to move to
     */
    public void move(Piece piece, Tile moveTo) {
        grid.getChildren().remove(piece.getPieceLabel());
        tiles[piece.getxPos()][piece.getyPos()].setOccupied(-1);
        
        if (moveTo.getOccupied() != -1) {
            kill(getPiece(moveTo));
        }
        
        grid.add(piece.getPieceLabel(), moveTo.getxPos(), moveTo.getyPos());
        piece.setxPos(moveTo.getxPos());
        piece.setyPos(moveTo.getyPos());
        moveTo.setOccupied(piece.getColour());
        
        activePiece = null;
        lastClicked.unHighlight();
        
        if (piece.getClass() == Pawn.class) {
            ((Pawn) piece).setFirstMove(false);
        }
        
        if (turn == 1) {
            turn = 0;
        } else {
            turn = 1;
        }
    }
    
    /**
     * Remove a piece from the game.
     * @param piece the piece to remove
     */
    private void kill(Piece piece) {
        grid.getChildren().remove(piece.getPieceLabel());
        piece.setxPos(-1);
        piece.setyPos(-1);
    }
}
