/**
 * Created by Birthright on 04.12.2015.
 */
public class Grid {

    private final int SIZE;

    private Stone[][] stones;

    public Grid(int size) {
        SIZE = size;
        stones = new Stone[SIZE][SIZE];
    }


    public void addStone(int row, int col, StoneColor state) {
        Stone newStone = new Stone(row, col, state);
        stones[row][col] = newStone;

        Stone[] neighbors = new Stone[4];

        if (row > 0) {
            neighbors[0] = stones[row - 1][col];
        }
        if (row < SIZE - 1) {
            neighbors[1] = stones[row + 1][col];
        }
        if (col > 1) {
            neighbors[2] = stones[row][col - 1];
        }
        if (col < SIZE - 1) {
            neighbors[3] = stones[row][col + 1];
        }

        Chain finalChain = new Chain();
        for (Stone neighbor : neighbors) {

            if (neighbor == null) {
                continue;
            }
            newStone.setLiberties(newStone.getLiberties() - 1);
            neighbor.setLiberties(neighbor.getLiberties() - 1);



            if (neighbor.getState() != newStone.getState()) {
                removeGroupIfDead(neighbor);
                continue;
            }

            if (neighbor.getState() != null) {
                finalChain.join(neighbor.getChain());
            }
        }
        finalChain.addStone(newStone);
    }


    public void removeGroupIfDead(Stone stone) {

        if (!stone.getChain().getLiberties()) {
            for (Stone s : stone.getChain().getStones()) {
                s.setChain(null);
                stones[s.getRow()][s.getCol()] = null;
            }
        }
    }

    public boolean isOccupied(int row, int col) {
        return stones[row][col] != null;
    }


    public StoneColor getState(int row, int col) {
        Stone stone = stones[row][col];
        if (stone == null) {
            return null;
        } else {
            // System.out.println("getState != null");
            return stone.getState();
        }
    }
}
