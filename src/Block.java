import java.util.ArrayList;

/**
 * The Block class represents a block in this game.
 * It holds a collection of pieces and a number.
 *
 * @author MohammadaliKeshtparvar
 * @version 0.0
 */

public class Block {

    private ArrayList<Piece> pieces;
    private int number;

    /**
     * Create a new block with given a number.
     * @param number the number of the block.
     */
    public Block(int number) {
        this.number = number;
        pieces = new ArrayList<>();
        setPieces(number);
    }

    /**
     * Get the array list of the pieces.
     * @return the array list of a block.
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * To find the type of a piece with given its length and the width.
     * @param x the length of a piece.
     * @param y the width of a piece.
     * @return the type of a piece.
     */
    public int findType(int x, int y) {
        for (Piece p : pieces) {
            if (p.getX() == x && p.getY() == y) {
                return p.getType();
            }
        }
        return 3;
    }

    /**
     * To find the number of a piece that exist in this block
     * with given the length and the width of a piece.
     * @param x the length of a piece.
     * @param y the width of a piece.
     * @return the number of a piece in this block.
     */
    public int findNumber(int x, int y) {
        for (Piece p : pieces) {
            if (p.getX() == x && p.getY() == y) {
                return p.getNumber();
            }
        }
        return 9;
    }

    /**
     * Set the length and the width a piece in a block
     * according to number of its block.
     * @param block the number of a block.
     */
    public void setPieces(int block) {
        if (block == 1){
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    Piece p = new Piece(j, i, 0, block);
                    pieces.add(p);
                }
            }
        }

        if (block == 2) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Piece p = new Piece(j+3, i, 0, block);
                    pieces.add(p);
                }
            }
        }

        if (block == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Piece p = new Piece(j, i+3, 0, block);
                    pieces.add(p);
                }
            }
        }

        if (block == 4) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Piece p = new Piece(j+3, i+3, 0, block);
                    pieces.add(p);
                }
            }
        }
    }

}
