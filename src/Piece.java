/**
 * The Piece class represents a piece in this game.
 * It holds type and number to be special piece.
 * The x and y represent the location of the piece in map of game.
 *
 * @author MohammadaliKeshtparvar
 * @version 0.0
 */

public class Piece {

    private int x;
    private int y;
    private int type;
    private int number;
    private int block;

    /**
     * Create a new piece with given length , width , type and number of block.
     * @param x the length of the piece.
     * @param y the width of the piece.
     * @param type the type of the piece.
     * @param block the number of the piece block.
     */
    public Piece(int x, int y, int type, int block) {
        this.x = x;
        this.y = y;
        this.block = block;
        setType(type);
        setNumber();
    }

    /**
     * Get the length of a piece.
     * @return the length of a piece.
     */
    public int getX() {
        return x;
    }

    /**
     * Get the width of a piece.
     * @return the width of a piece.
     */
    public int getY() {
        return y;
    }

    /**
     * Get the number of a piece.
     * @return the number of a piece.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Get the type of the piece.
     * @return the type of the piece.
     */
    public int getType() {
        return type;
    }

    /**
     * Set the number of a block according to its number of block.
     */
    public void setNumber() {
        if (block == 1)
            number = y * 3 + x;
        if (block == 2)
            number = y * 3 + x - 3;
        if (block == 3)
            number = ((y-3) * 3) + x;
        if (block == 4)
            number = (y-3) * 3 + x -3;

    }

    /**
     * Set the type of a piece.
     * @param type the type of a piece.
     */
    public void setType(int type) {
        this.type = type;
    }

}
