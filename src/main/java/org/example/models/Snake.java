package org.example.models;

public class Snake extends BoardEntity {
    public Snake(int start,  int end) {
        super(start, end);
        this.setBoardEntityType(BoardEntityType.SNAKE);
    }

    @Override
    public void printBoardEntity() {
        System.out.println("Oops, You encountered a snake. :(");
    }

    @Override
    public void printEntity() {
        System.out.print("S(" + getEnd() + ")");
    }
}
