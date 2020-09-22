import java.util.ArrayList;

/**
 * The CollectionOfBlock represents a collection of blocks
 * in this game.
 * It holds four blocks in its array list.
 *
 * @author MohammadaliKeshtparvar
 * @version 0.0
 */

public class CollectionOfBlock {

    private ArrayList<Block> blocks;

    /**
     * Create a new collectionOfPiece without any input.
     */
    public CollectionOfBlock() {
        blocks = new ArrayList<>();
        for (int i = 1; i <= 4; i++)
            blocks.add(new Block(i));
    }

    /**
     * Get the the blocks that save in this collection.
     * @return the array list of blocks.
     */
    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    /**
     * Get the type of a piece with given number and number of its block.
     * @param number the number of a piece.
     * @param block the number of a piece block.
     * @return the type of a piece.
     */
    public int getType2(int number, int block) {
        return blocks.get(block-1).getPieces().get(number).getType();
    }
}
