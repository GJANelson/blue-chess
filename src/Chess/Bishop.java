package Chess;

/**
 * Represents a bishop in chess.
 * @author Garth Nelson
 * @version 2018
 */
public class Bishop extends Piece {

    /**
     * Constructs an object of type Bishop.
     * @param colour 1 for black, 0 for white
     * @param x starting x position
     * @param y starting y position
     */
    public Bishop(int colour, int x, int y) {
        super(colour, x, y);
        if (colour == 1) {
            pieceLabel.setText("\u265d");
        } else if (colour == 0) {
            pieceLabel.setText("\u2657");
        }
    }

    /**
     * Checks if a move is valid for a bishop.
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
            if (validUpperLeft(tile, list0, list1) 
                    || validLowerLeft(tile, list0, list1)
                    || validUpperRight(tile, list0, list1) 
                    || validLowerRight(tile, list0, list1)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if a move is valid moving upwards to the left.
     * @see Chess.Piece#validMove(Tile, Piece, Piece)
     * @param tile The tile to check
     * @param list0 List of white pieces on the board, to check for obstruction
     * @param list1 List of black pieces on the board, to check for obstruction
     * @return true if a valid move, false otherwise
     */
    private boolean validUpperLeft(Tile tile, Piece[] list0, Piece[] list1) {
        final int maxMoves = 8;
        for (int i = 1; i < maxMoves; i++) {
            if (tile.getxPos() == xPos - i && tile.getyPos() == yPos - i) {
                return true;
            }
            for (int j = 0; j < list0.length; j++) {
                if (list0[j].getxPos() == xPos - i 
                        && list0[j].getyPos() == yPos - i) {
                    return false;
                }
            } 
            for (int j = 0; j < list1.length; j++) {
                if (list1[j].getxPos() == xPos - i 
                        && list1[j].getyPos() == yPos - i) {
                    return false;
                }
            } 
        }
        return false;
    }
    
    /**
     * Checks if a move is valid moving downwards to the left.
     * @see Chess.Piece#validMove(Tile, Piece, Piece)
     * @param tile The tile to check
     * @param list0 List of white pieces on the board, to check for obstruction
     * @param list1 List of black pieces on the board, to check for obstruction
     * @return true if a valid move, false otherwise
     */
    private boolean validLowerLeft(Tile tile, Piece[] list0, Piece[] list1) {
        final int maxMoves = 8;
        for (int i = 1; i < maxMoves; i++) {
            if (tile.getxPos() == xPos - i && tile.getyPos() == yPos + i) {
                return true;
            }
            for (int j = 0; j < list0.length; j++) {
                if (list0[j].getxPos() == xPos - i 
                        && list0[j].getyPos() == yPos + i) {
                    return false;
                }
            } 
            for (int j = 0; j < list1.length; j++) {
                if (list1[j].getxPos() == xPos - i 
                        && list1[j].getyPos() == yPos + i) {
                    return false;
                }
            } 
        }
        return false;
    }
    
    /**
     * Checks if a move is valid moving upwards to the right.
     * @see Chess.Piece#validMove(Tile, Piece, Piece)
     * @param tile The tile to check
     * @param list0 List of white pieces on the board, to check for obstruction
     * @param list1 List of black pieces on the board, to check for obstruction
     * @return true if a valid move, false otherwise
     */
    private boolean validUpperRight(Tile tile, Piece[] list0, Piece[] list1) {
        final int maxMoves = 8;
        for (int i = 1; i < maxMoves; i++) {
            if (tile.getxPos() == xPos + i && tile.getyPos() == yPos - i) {
                return true;
            }
            for (int j = 0; j < list0.length; j++) {
                if (list0[j].getxPos() == xPos + i 
                        && list0[j].getyPos() == yPos - i) {
                    return false;
                }
            } 
            for (int j = 0; j < list1.length; j++) {
                if (list1[j].getxPos() == xPos + i 
                        && list1[j].getyPos() == yPos - i) {
                    return false;
                }
            } 
        }
        return false;
    }
    
    /**
     * Checks if a move is valid moving downwards to the right.
     * @see Chess.Piece#validMove(Tile, Piece, Piece)
     * @param tile The tile to check
     * @param list0 List of white pieces on the board, to check for obstruction
     * @param list1 List of black pieces on the board, to check for obstruction
     * @return true if a valid move, false otherwise
     */
    private boolean validLowerRight(Tile tile, Piece[] list0, Piece[] list1) {
        final int maxMoves = 8;
        for (int i = 1; i < maxMoves; i++) {
            if (tile.getxPos() == xPos + i && tile.getyPos() == yPos + i) {
                return true;
            }
            for (int j = 0; j < list0.length; j++) {
                if (list0[j].getxPos() == xPos + i 
                        && list0[j].getyPos() == yPos + i) {
                    return false;
                }
            } 
            for (int j = 0; j < list1.length; j++) {
                if (list1[j].getxPos() == xPos + i 
                        && list1[j].getyPos() == yPos + i) {
                    return false;
                }
            } 
        }
        return false;
    }

}
