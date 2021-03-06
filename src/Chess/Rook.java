package Chess;

/**
 * Represents a rook in chess.
 * @author Garth Nelson
 * @version 2018
 */
public class Rook extends Piece {

    /**
     * Constructs an object of type Rook.
     * @param colour 1 for black, 0 for white
     * @param x starting x position
     * @param y starting y position
     */
    public Rook(int colour, int x, int y) {
        super(colour, x, y);
        if (colour == 1) {
            pieceLabel.setText("\u265c");
        } else if (colour == 0) {
            pieceLabel.setText("\u2656");
        }
    }

    /**
     * Checks if a move is valid for a rook.
     * @see Chess.Piece#validMove(Tile, Piece, Piece)
     * @param tile The tile to check
     * @param list0 List of white pieces on the board, to check for obstruction
     * @param list1 List of black pieces on the board, to check for obstruction
     * @return true if a valid move, false otherwise
     */
    @Override
    boolean validMove(Tile tile, Piece[] list0, Piece[] list1) {
        if (tile.getOccupied() == colour) {
            return false;
        } else {
            if (validUp(tile, list0, list1) 
                    || validDown(tile, list0, list1)
                    || validRight(tile, list0, list1) 
                    || validLeft(tile, list0, list1)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if a move is valid moving up.
     * @see Chess.Piece#validMove(Tile, Piece, Piece)
     * @param tile The tile to check
     * @param list0 List of white pieces on the board, to check for obstruction
     * @param list1 List of black pieces on the board, to check for obstruction
     * @return true if a valid move, false otherwise
     */
    private boolean validUp(Tile tile, Piece[] list0, Piece[] list1) {
        final int maxMoves = 8;
        for (int i = 1; i < maxMoves; i++) {
            if (tile.getxPos() == xPos && tile.getyPos() == yPos - i) {
                return true;
            }
            for (int j = 0; j < list0.length; j++) {
                if (list0[j].getxPos() == xPos 
                        && list0[j].getyPos() == yPos - i) {
                    return false;
                }
            } 
            for (int j = 0; j < list1.length; j++) {
                if (list1[j].getxPos() == xPos 
                        && list1[j].getyPos() == yPos - i) {
                    return false;
                }
            } 
        }
        return false;
    }
    
    /**
     * Checks if a move is valid moving down.
     * @see Chess.Piece#validMove(Tile, Piece, Piece)
     * @param tile The tile to check
     * @param list0 List of white pieces on the board, to check for obstruction
     * @param list1 List of black pieces on the board, to check for obstruction
     * @return true if a valid move, false otherwise
     */
    private boolean validDown(Tile tile, Piece[] list0, Piece[] list1) {
        final int maxMoves = 8;
        for (int i = 1; i < maxMoves; i++) {
            if (tile.getxPos() == xPos && tile.getyPos() == yPos + i) {
                return true;
            }
            for (int j = 0; j < list0.length; j++) {
                if (list0[j].getxPos() == xPos 
                        && list0[j].getyPos() == yPos + i) {
                    return false;
                }
            } 
            for (int j = 0; j < list1.length; j++) {
                if (list1[j].getxPos() == xPos 
                        && list1[j].getyPos() == yPos + i) {
                    return false;
                }
            } 
        }
        return false;
    }
    
    /**
     * Checks if a move is valid moving left.
     * @see Chess.Piece#validMove(Tile, Piece, Piece)
     * @param tile The tile to check
     * @param list0 List of white pieces on the board, to check for obstruction
     * @param list1 List of black pieces on the board, to check for obstruction
     * @return true if a valid move, false otherwise
     */
    private boolean validLeft(Tile tile, Piece[] list0, Piece[] list1) {
        final int maxMoves = 8;
        for (int i = 1; i < maxMoves; i++) {
            if (tile.getxPos() == xPos - i && tile.getyPos() == yPos) {
                return true;
            }
            for (int j = 0; j < list0.length; j++) {
                if (list0[j].getxPos() == xPos - i 
                        && list0[j].getyPos() == yPos) {
                    return false;
                }
            } 
            for (int j = 0; j < list1.length; j++) {
                if (list1[j].getxPos() == xPos - i 
                        && list1[j].getyPos() == yPos) {
                    return false;
                }
            } 
        }
        return false;
    }
    
    /**
     * Checks if a move is valid moving left.
     * @see Chess.Piece#validMove(Tile, Piece, Piece)
     * @param tile The tile to check
     * @param list0 List of white pieces on the board, to check for obstruction
     * @param list1 List of black pieces on the board, to check for obstruction
     * @return true if a valid move, false otherwise
     */
    private boolean validRight(Tile tile, Piece[] list0, Piece[] list1) {
        final int maxMoves = 8;
        for (int i = 1; i < maxMoves; i++) {
            if (tile.getxPos() == xPos + i && tile.getyPos() == yPos) {
                return true;
            }
            for (int j = 0; j < list0.length; j++) {
                if (list0[j].getxPos() == xPos + i 
                        && list0[j].getyPos() == yPos) {
                    return false;
                }
            } 
            for (int j = 0; j < list1.length; j++) {
                if (list1[j].getxPos() == xPos + i 
                        && list1[j].getyPos() == yPos) {
                    return false;
                }
            } 
        }
        return false;
    }
}
