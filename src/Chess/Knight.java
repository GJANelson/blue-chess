package Chess;

/**
 * Represents a knight in chess.
 * @author Garth Nelson
 * @version 2018
 */
public class Knight extends Piece {

    /**
     * Constructs an object of type Knight.
     * @param colour 1 for black, 0 for white
     * @param x starting x position
     * @param y starting y position
     */
    public Knight(int colour, int x, int y) {
        super(colour, x, y);
        if (colour == 1) {
            pieceLabel.setText("\u265e");
        } else if (colour == 0) {
            pieceLabel.setText("\u2658");
        }
    }

    /**
     * Checks if a move is valid for a knight.
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
        } else if ((tile.getxPos() == xPos + 2 || tile.getxPos() == xPos - 2)
                && (tile.getyPos() == yPos + 1 || tile.getyPos() == yPos - 1)) {
            return true;
        } else if ((tile.getxPos() == xPos + 1 || tile.getxPos() == xPos - 1)
                && (tile.getyPos() == yPos + 2 || tile.getyPos() == yPos - 2)) {
            return true;
        }
        return false;
    }

}
