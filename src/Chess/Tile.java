package Chess;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

/**
 * Represents a tile on a game board.
 * @author Garth Nelson
 * @version 2018
 */
public class Tile extends Rectangle {
    /** current x position on board. */
    private int xPos;
    /** current y position on board. */
    private int yPos;
    /** 1 if occupied by black, 0 if occupied by white, -1 if unoccupied. */
    private int occupied;
    
    /**
     * Constructs an object of type Tile.
     * @param width the width to set
     * @param height the height to set
     * @param fill the fill colour to set
     * @param x the xPos to set
     * @param y the yPos to set
     */
    public Tile(double width, double height, Paint fill, int x, int y) {
        super(width, height, fill);
        xPos = x;
        yPos = y;
        occupied = -1;
    }
    
    /**
     * Returns the xPos for this Tile.
     * @return the xPos
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * Sets the xPos for this Tile.
     * @param xPos the xPos to set
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * Returns the yPos for this Tile.
     * @return the yPos
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * Sets the yPos for this Tile.
     * @param yPos the yPos to set
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * Returns the occupied for this Tile.
     * @return the occupied
     */
    public int getOccupied() {
        return occupied;
    }

    /**
     * Sets the occupied for this Tile.
     * @param occupied the occupied to set
     */
    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    /**
     * Highlights a tile.
     */
    public void highlight(Paint colour) {
        final int highlightWidth = 5;
        setStrokeWidth(highlightWidth);
        setStrokeType(StrokeType.INSIDE);
        setStroke(colour);
    }
    
    /**
     * Stops highlighting a tile.
     */
    public void unHighlight() {
        setStrokeWidth(0);
    }
}
