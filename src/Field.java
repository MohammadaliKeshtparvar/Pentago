/**
 * The Field class represents a field in this game.
 * It holds a method for printing the map of this game.
 *
 * @author MohammadaliKeshtparvar
 * @version 0.0
 */

public class Field {

    private CollectionOfBlock collectionOfBlock;
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_BG_RED    = "\u001B[41m";
    private static final String ANSI_BG_BLUE   = "\u001B[44m";
    private static final String ANSI_BRIGHT_BG_BLACK  = "\u001B[100m";

    /**
     * Create a new field without given any inputs.
     */
    public Field() {
        collectionOfBlock = new CollectionOfBlock();
    }

    /**
     * Get the collection of this field.
     * @return the collection of this field.
     */
    public CollectionOfBlock getCollectionOfBlock() {
        return collectionOfBlock;
    }

    /**
     * Print the map of this game.
     */
    public void printMap() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                int n = (j / 3) + (i / 3) * 2;
                if (collectionOfBlock.getBlocks().get(n).findType(j, i) == 0) {
                    System.out.print("  "+ANSI_BRIGHT_BG_BLACK+ANSI_BLACK+" "+collectionOfBlock.getBlocks().get(n).findNumber(j, i)+" "+ANSI_RESET);
                }
                if (collectionOfBlock.getBlocks().get(n).findType(j, i) == 1) {
                    System.out.print("  "+ANSI_BG_RED+ANSI_BLACK+" "+collectionOfBlock.getBlocks().get(n).findNumber(j, i)+" "+ANSI_RESET);
                }
                if (collectionOfBlock.getBlocks().get(n).findType(j, i) == 2) {
                    System.out.print("  "+ANSI_BG_BLUE+ANSI_BLACK+" "+collectionOfBlock.getBlocks().get(n).findNumber(j, i)+" "+ANSI_RESET);
                }
                if (j == 2)
                    System.out.print("  ");
            }
            System.out.println();
            if (i == 2)
                System.out.println();
            System.out.println();
        }
    }
}
