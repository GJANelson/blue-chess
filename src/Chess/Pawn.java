package Chess;

/**
 * Represents a pawn in chess.
 * @author Garth Nelson
 * @version 2018
 */
public class Pawn extends Piece {
    /** Holds true if the pawn has not yet moved. */
    private boolean firstMove;
    
    /**
     * Constructs an object of type Pawn.
     * @param colour 1 for black, 0 for white
     * @param x starting x position
     * @param y starting y position
     */
    public Pawn(int colour, int x, int y) {
        super(colour, x, y);
        firstMove = true;
        if (colour == 1) {
            pieceLabel.setText("\u265f");
        } else if (colour == 0) {
            pieceLabel.setText("\u2659");
        }
    }
    
    /**
     * Checks if a move is valid for a pawn.
     * @see Chess.Piece#validMove(Tile, Piece, Piece)
     * @param tile The tile to check
     * @param list0 List of white pieces on the board, to check for obstruction
     * @param list1 List of black pieces on the board, to check for obstruction
     * @return true if a valid move, false otherwise
     */
    @Override
    public boolean validMove(Tile tile, Piece[] list0, Piece[] list1) {
        if (colour == 1) {
            if (blackMove(tile, list0, list1)) {
                return true;
            }
        } else {
            if (whiteMove(tile, list0, list1)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if a move is valid for a black pawn.
     * @see Chess.Piece#validMove(Tile, Piece, Piece)
     * @param tile The tile to check
     * @param list0 List of white pieces on the board, to check for obstruction
     * @param list1 List of black pieces on the board, to check for obstruction
     * @return true if a valid move, false otherwise
     */
    private boolean blackMove(Tile tile, Piece[] list0, Piece[] list1) {
        if (tile.getOccupied() == colour) {
            return false;
        } else if (tile.getxPos() == xPos && tile.getyPos() == yPos + 1 
                && tile.getOccupied() == -1) {
            return true;
        } else if (tile.getOccupied() == 0 && (tile.getxPos() == xPos + 1 
                || tile.getxPos() == xPos - 1) && tile.getyPos() == yPos + 1) {
            return true;
        } else if (firstMove) {
            for (int j = 0; j < list0.length; j++) {
                if (list0[j].getxPos() == xPos 
                        && list0[j].getyPos() == yPos + 1) {
                    return false;
                }
            } 
            for (int j = 0; j < list1.length; j++) {
                if (list1[j].getxPos() == xPos 
                        && list1[j].getyPos() == yPos + 1) {
                    return false;
                }
            } 
            if (tile.getxPos() == xPos && tile.getyPos() == yPos + 2 
                    && tile.getOccupied() == -1) {
                return true;
            }
        } 
        
        return false;
    }
    
    /**
     * Checks if a move is valid for a white pawn.
     * @see Chess.Piece#validMove(Tile, Piece, Piece)
     * @param tile The tile to check
     * @param list0 List of white pieces on the board, to check for obstruction
     * @param list1 List of black pieces on the board, to check for obstruction
     * @return true if a valid move, false otherwise
     */
    private boolean whiteMove(Tile tile, Piece[] list0, Piece[] list1) {
        if (tile.getOccupied() == colour) {
            return false;
        } else if (tile.getxPos() == xPos && tile.getyPos() == yPos - 1 
                && tile.getOccupied() == -1) {
            return true;
        } else if (tile.getOccupied() == 1 && (tile.getxPos() == xPos + 1 
                || tile.getxPos() == xPos - 1) && tile.getyPos() == yPos - 1) {
            return true;
        } else if (firstMove) {
            for (int j = 0; j < list0.length; j++) {
                if (list0[j].getxPos() == xPos 
                        && list0[j].getyPos() == yPos - 1) {
                    return false;
                }
            } 
            for (int j = 0; j < list1.length; j++) {
                if (list1[j].getxPos() == xPos 
                        && list1[j].getyPos() == yPos - 1) {
                    return false;
                }
            } 
            if (tile.getxPos() == xPos && tile.getyPos() == yPos - 2 
                    && tile.getOccupied() == -1) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Sets the firstMove for this Pawn.
     * @param firstMove the firstMove to set
     */
    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

}
