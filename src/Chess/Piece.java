package Chess;

import javafx.scene.text.Text;

/**
 * Represents an abstract "Piece" in a game.
 * @author Garth Nelson
 * @version 2018
 */
public abstract class Piece {
    /** The unicode for the Piece. */
    protected Text pieceLabel;
    /** The colour of the piece. 1 for black, 0 for white. */
    protected final int colour;
    /** The x position of the piece on the board. */
    protected int xPos;
    /** The y position of the piece on the board. */
    protected int yPos;
    
    /**
     * Constructs an object of type Piece.
     * @param colour 1 if black, 0 if white
     * @param x starting position on the board
     * @param y starting position on the board
     */
    public Piece(int colour, int x, int y) {
        this.colour = colour;
        pieceLabel = new Text();
        xPos = x;
        yPos = y;
        pieceLabel.setMouseTransparent(true);
        pieceLabel.setStyle("-fx-font-size: 70");
    }
    
    /**
     * Checks if a move is valid or not, based on the piece's movement.
     * @param tile The tile to check
     * @param list0 List of white pieces on the board, to check for obstruction
     * @param list1 List of black pieces on the board, to check for obstruction
     * @return true if a valid move, false otherwise
     */
    abstract boolean validMove(Tile tile, Piece[] list0, Piece[] list1);

    /**
     * Returns the xPos for this Piece.
     * @return the xPos
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * Sets the xPos for this Piece.
     * @param xPos the xPos to set
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * Returns the yPos for this Piece.
     * @return the yPos
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * Sets the yPos for this Piece.
     * @param yPos the yPos to set
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * Returns the colour for this Piece.
     * @return the colour
     */
    public int getColour() {
        return colour;
    }
    
    /**
     * Returns the pieceLabel for this Piece.
     * @return the pieceLabel
     */
    public Text getPieceLabel() {
        return pieceLabel;
    }
}
