package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private int dimension;
    private int cellCount;
    private Map<Integer, BoardEntity> boardEntityMap;

    public Board(int dimension) {
        this.dimension = dimension;
        this.cellCount = dimension * dimension;

        boardEntityMap = new HashMap<>();
        //Initialize n snakes and n ladders.

        //Add n Snakes and n Ladders.
        addSnakesAndLadders();
    }

    private void addSnakesAndLadders() {
        for (int i = 0; i < dimension; i++) {
            int min = 2;
            int max = cellCount - 1; // 10

            int start = (int) Math.floor(Math.random() * (max - min + 1) + min); // 54
            max = start - 1; // end index can lie between 2 to 53.

            int end = (int) Math.floor(Math.random() * (max - min + 1) + min);

            //start > end
            if (!hasSnakeOrLadder(start)) {
                boardEntityMap.put(start, new Snake(start, end));
            }

            max = cellCount - 1;
            //Ladder -> end > start
            end = (int) Math.floor(Math.random() * (max - min + 1) + min);

            max = end - 1;
            start = (int) Math.floor(Math.random() * (max - min + 1) + min);

            if (!hasSnakeOrLadder(start)) {
                boardEntityMap.put(start, new Ladder(start, end));
            }
        }
    }

    public void print() {
        int tempCellCount = cellCount;
        int index;
        for (int row = 0; row < dimension; row++) {
            // Print left to right if even row, right to left if odd
            if (row % 2 == 0) {
                for (int col = 0; col < dimension; col++) {
                    index = tempCellCount;

                    System.out.printf("%4d", tempCellCount);

                    if (hasSnakeOrLadder(index)) {
                        BoardEntity entity = boardEntityMap.get(index);
                        entity.printEntity();
                    }

                    tempCellCount-=1;
                }
            } else {
                int temp = tempCellCount - dimension+ 1;
                for (int col = 0; col < dimension; col++) {

                    System.out.printf("%4d", temp);

                    if (hasSnakeOrLadder(temp)) {
                        BoardEntity entity = boardEntityMap.get(temp);
                        entity.printEntity();
                    }

                    temp+=1;
                }
                tempCellCount -= dimension;
            }
            System.out.println(); // New line for each row
        }
    }

    public boolean hasSnakeOrLadder(int index) {
        return boardEntityMap.containsKey(index);
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Map<Integer, BoardEntity> getBoardEntityMap() {
        return boardEntityMap;
    }

    public void setBoardEntityMap(Map<Integer, BoardEntity> boardEntityMap) {
        this.boardEntityMap = boardEntityMap;
    }

    public int getCellCount() {
        return cellCount;
    }

    public void setCellCount(int cellCount) {
        this.cellCount = cellCount;
    }
}


//Math.random() -> [0, 1)


/*
roll a dice :

min = 1
max = 6

random number between 1 to 6.

[0, 1) * (6 - 1 + 1) + 1 => floor(x * 6 + 1) where x lies in [0, 1)

x = 0.1 => 1.6 -> floor(1.6) = 1
x = 0.6 => 4.6 -> floor(4.6) = 4
x = 0.9 => 6.4 -> floor(6.4) = 6
x = 0.7 => 5.2 -> floor(5.2) = 5


100 99 98 97 96 .............
                     88 89 90
80 79 78 S(64) .....................




1 2 3 4 5 6 .................

 */


