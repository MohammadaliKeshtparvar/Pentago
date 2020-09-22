import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Scanner;

/**
 * The Rules class represents a class in this game.
 * It holds the rules of this game and a method to receive inputs from users.
 *
 * @author MohammadaliKeshtparvar
 * @version 0.0
 */

public class Rules {

    private Field field;

    /**
     * Create a new rules for starting a game.
     * This constructor do not receive any inputs.
     */
    public Rules() {
        field = new Field();
    }

    /**
     * When this method called a block spin 90degrees.
     * If the direction equals one , the block spins to left.
     * If the direction equals two , the block spins to right.
     * @param block the number of a block.
     * @param direction the number of direction.
     */
    public void rotation(int block, int direction) {
        // pad
        if (direction == 1) {
            int[] n = new int[9];
            Block b = field.getCollectionOfBlock().getBlocks().get(block - 1);
            if (block == 1) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        n[i * 3 + j] = b.findType(2 - i, j);
                    }
                }
                for (int i = 0; i < 9; i++) {
                    field.getCollectionOfBlock().getBlocks().get(block - 1).getPieces().get(i).setType(n[i]);
                }
            }

            if (block == 2) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        n[i * 3 + j] = b.findType(5 - i, j);
                    }
                }
                for (int i = 0; i < 9; i++) {
                    field.getCollectionOfBlock().getBlocks().get(block - 1).getPieces().get(i).setType(n[i]);
                }
            }

            if (block == 3) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        n[i * 3 + j] = b.findType(2 - i,  j+3);
                    }
                }
                for (int i = 0; i < 9; i++) {
                    field.getCollectionOfBlock().getBlocks().get(block - 1).getPieces().get(i).setType(n[i]);
                }
            }

            if (block == 4) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        n[i * 3 + j] = b.findType(5 - i,  j+3);
                    }
                }
                for (int i = 0; i < 9; i++) {
                    field.getCollectionOfBlock().getBlocks().get(block - 1).getPieces().get(i).setType(n[i]);
                }
            }
        }


        if (direction == 2) {
            int[] n = new int[9];
            Block b = field.getCollectionOfBlock().getBlocks().get(block - 1);
            if (block == 1) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        n[i * 3 +j ] = b.findType(i, 2-j);
                    }
                }
                for (int i = 0; i < 9; i++) {
                    field.getCollectionOfBlock().getBlocks().get(block - 1).getPieces().get(i).setType(n[i]);
                }
            }

            if (block == 2) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        n[i * 3 +j ] = b.findType(i + 3, 2-j);
                    }
                }
                for (int i = 0; i < 9; i++) {
                    field.getCollectionOfBlock().getBlocks().get(block - 1).getPieces().get(i).setType(n[i]);
                }
            }

            if (block == 3) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        n[i * 3 +j ] = b.findType(i, 5 - j);
                    }
                }
                for (int i = 0; i < 9; i++) {
                    field.getCollectionOfBlock().getBlocks().get(block - 1).getPieces().get(i).setType(n[i]);
                }
            }

            if (block == 4) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        n[i * 3 +j ] = b.findType(i + 3, 5-j);
                    }
                }
                for (int i = 0; i < 9; i++) {
                    field.getCollectionOfBlock().getBlocks().get(block - 1).getPieces().get(i).setType(n[i]);
                }
            }
        }
    }

    /**
     * Player to choice a piece when his turn.
     * @param block the number of a block that chosen by a player.
     * @param number the number of a piece that chosen by a player.
     * @param turn the turn of players.
     */
    public void choice(int block, int number, int turn) {
        field.getCollectionOfBlock().getBlocks().get(block-1).getPieces().get(number).setType(turn);
    }

    /**
     * To check when the game is finished and which one players wins.
     * @param turn the turn of player.
     * @param block the number of block.
     * @return a boolean value.
     */
    public boolean endCondition(int turn, int block) {
        boolean flag = false;

        if (block == 1) {
            int counter = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, j) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block + 1).findType(i, j) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, j) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 6; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, j) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block + 1).findType(i, j) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, j) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(j, i) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block).findType(j, i) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(j, i) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 6; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(j, i) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block).findType(j, i) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(j, i) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 0; i < 5; i++) {
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, i) == 3) {
                    if (field.getCollectionOfBlock().getBlocks().get(block+2).findType(i, i) == turn)
                        counter++;
                }
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, i) == turn) {
                    counter++;
                }
            }
            if (counter == 5) {
                return true;
            }
            counter = 0;

            for (int i = 1; i < 6; i++) {
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, i) == 3) {
                    if (field.getCollectionOfBlock().getBlocks().get(block+2).findType(i, i) == turn)
                        counter++;
                }
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, i) == turn) {
                    counter++;
                }
            }
            if (counter == 5) {
                return true;
            }
        }

        if (block == 2) {
            int counter = 0;
            for (int i = 3; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, j) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block + 1).findType(i, j) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, j) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 3; i < 5; i++) {
                for (int j = 1; j < 6; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, j) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block + 1).findType(i, j) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, j) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-j, i) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block-2).findType(5-j, i) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-j, i) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 6; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-j, i) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block-2).findType(5-j, i) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-j, i) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 0; i < 5; i++) {
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-i, i) == 3) {
                    if (field.getCollectionOfBlock().getBlocks().get(block).findType(5-i, i) == turn)
                        counter++;
                }
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-i, i) == turn) {
                    counter++;
                }
            }
            if (counter == 5) {
                return true;
            }
            counter = 0;

            for (int i = 1; i < 6; i++) {
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-i, i) == 3) {
                    if (field.getCollectionOfBlock().getBlocks().get(block).findType(5-i, i) == turn)
                        counter++;
                }
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-i, i) == turn) {
                    counter++;
                }
            }
            if (counter == 5) {
                return true;
            }

        }

        if (block == 3) {
            int counter = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, 5-j) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block - 3).findType(i, 5-j) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, 5-j) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 6; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, 5-j) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block - 3).findType(i, 5-j) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, 5-j) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 3; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(j, i) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block).findType(j, i) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(j, i) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 3; i < 6; i++) {
                for (int j = 1; j < 6; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(j, i) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block).findType(j, i) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(j, i) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 0; i < 5; i++) {
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, 5-i) == 3) {
                    if (field.getCollectionOfBlock().getBlocks().get(block-2).findType(i, 5-i) == turn)
                        counter++;
                }
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, 5-i) == turn) {
                    counter++;
                }
            }
            if (counter == 5) {
                return true;
            }
            counter = 0;

            for (int i = 1; i < 6; i++) {
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, 5-i) == 3) {
                    if (field.getCollectionOfBlock().getBlocks().get(block-2).findType(i, 5-i) == turn)
                        counter++;
                }
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, 5-i) == turn) {
                    counter++;
                }
            }
            if (counter == 5) {
                return true;
            }
        }

        if (block == 4) {
            int counter = 0;
            for (int i = 3; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, 5-j) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block - 3).findType(i, 5-j) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, 5-j) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 3; i < 5; i++) {
                for (int j = 1; j < 6; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, 5-j) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block - 3).findType(i, 5-j) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(i, 5-j) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 3; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-j, i) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block-2).findType(5-j, i) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-j, i) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 3; i < 6; i++) {
                for (int j = 1; j < 6; j++) {
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-j, i) == 3) {
                        if (field.getCollectionOfBlock().getBlocks().get(block-2).findType(5-j, i) == turn)
                            counter++;
                    }
                    if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-j, i) == turn) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    return true;
                }
                counter = 0;
            }

            for (int i = 0; i < 5; i++) {
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-i, 5-i) == 3) {
                    if (field.getCollectionOfBlock().getBlocks().get(block-4).findType(5-i, 5-i) == turn)
                        counter++;
                }
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-i, 5-i) == turn) {
                    counter++;
                }
            }
            if (counter == 5) {
                return true;
            }
            counter = 0;

            for (int i = 1; i < 6; i++) {
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-i, 5-i) == 3) {
                    if (field.getCollectionOfBlock().getBlocks().get(block-4).findType(5-i, 5-i) == turn)
                        counter++;
                }
                if (field.getCollectionOfBlock().getBlocks().get(block - 1).findType(5-i, 5-i) == turn) {
                    counter++;
                }
            }
            if (counter == 5) {
                return true;
            }
        }

        return flag;
    }

    /**
     * To check user's input to be digits.
     * @param str the string that we want to check it.
     * @return a boolean value.
     */
    public boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

    /**
     * The method for starting and keening the game.
     */
    public void plyingGame() {

        Scanner input = new Scanner(System.in);
        field.printMap();
        while (true) {
            System.out.println("Player one :");
            String player;
            System.out.println("Please enter a location for your piece(PLAYER ONE)");
            while (true) {
                player = input.nextLine();
                if (isNumeric(player) && Integer.parseInt(player.substring(0, 1)) < 9 && Integer.parseInt(player.substring(0, 1)) > -1 &&
                Integer.parseInt(player.substring(1, 2)) > 0 && Integer.parseInt(player.substring(1, 2)) < 5 &&
                field.getCollectionOfBlock().getType2(Integer.parseInt(player.substring(0, 1)), Integer.parseInt(player.substring(1, 2))) != 1)
                    break;
                System.out.println("Please enter correct digits.");
            }
            choice(Integer.parseInt(player.substring(1, 2)), Integer.parseInt(player.substring(0, 1)), 1);
            field.printMap();
            if (endCondition(1, Integer.parseInt(player.substring(1, 2)))) {
                System.out.println("Player one wins.");
                break;
            }

            System.out.println("Please choice a block for rotation(PLAYER ONE)");
            while (true) {
                player = input.nextLine();
                if (isNumeric(player) && Integer.parseInt(player.substring(0, 1)) > 0 && Integer.parseInt(player.substring(0, 1)) < 5 &&
                Integer.parseInt(player.substring(1, 2)) > 0 && Integer.parseInt(player.substring(1, 2)) < 3)
                    break;
                System.out.println("Please enter correct digits.");
            }
            rotation(Integer.parseInt(player.substring(0, 1)), Integer.parseInt(player.substring(1, 2)));
            field.printMap();
            if (endCondition(1, Integer.parseInt(player.substring(0, 1))) && endCondition(2, Integer.parseInt(player.substring(0, 1)))) {
                System.out.println("TWO PLAYERS ARE EQUIVALENT.");
                break;
            }
            if (endCondition(1, Integer.parseInt(player.substring(0, 1)))){
                System.out.println("Player one wins.");
                break;
            }
            if (endCondition(2, Integer.parseInt(player.substring(0, 1)))){
                System.out.println("Player two wins.");
                break;
            }


            System.out.println("Player two");
            System.out.println("Please enter a location for your piece(PLAYER TWO)");
            while (true) {
                player = input.nextLine();
                if (isNumeric(player) && Integer.parseInt(player.substring(0, 1)) < 9 && Integer.parseInt(player.substring(0, 1)) > -1 &&
                        Integer.parseInt(player.substring(1, 2)) > 0 && Integer.parseInt(player.substring(1, 2)) < 5 &&
                        field.getCollectionOfBlock().getType2(Integer.parseInt(player.substring(0, 1)), Integer.parseInt(player.substring(1, 2))) != 1)
                    break;
                System.out.println("Please enter correct digits.");
            }
            choice(Integer.parseInt(player.substring(1, 2)), Integer.parseInt(player.substring(0, 1)), 2);
            field.printMap();
            if (endCondition(2, Integer.parseInt(player.substring(1, 2)))) {
                System.out.println("Player two wins.");
                break;
            }

            System.out.println("Please choice a block for rotation(PLAYER TWO)");
            while (true) {
                player = input.nextLine();
                if (isNumeric(player) && Integer.parseInt(player.substring(0, 1)) > 0 && Integer.parseInt(player.substring(0, 1)) < 5 &&
                        Integer.parseInt(player.substring(1, 2)) > 0 && Integer.parseInt(player.substring(1, 2)) < 3)
                    break;
                System.out.println("Please enter correct digits.");
            }
            rotation(Integer.parseInt(player.substring(0, 1)), Integer.parseInt(player.substring(1, 2)));
            field.printMap();
            if (endCondition(1, Integer.parseInt(player.substring(0, 1))) && endCondition(2, Integer.parseInt(player.substring(0, 1)))) {
                System.out.println("TWO PLAYERS ARE EQUIVALENT.");
                break;
            }
            if (endCondition(1, Integer.parseInt(player.substring(0, 1)))){
                System.out.println("Player one wins.");
                break;
            }
            if (endCondition(2, Integer.parseInt(player.substring(0, 1)))){
                System.out.println("Player two wins.");
                break;
            }


        }
    }
}


