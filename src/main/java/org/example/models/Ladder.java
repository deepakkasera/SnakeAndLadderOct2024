package org.example.models;

public class Ladder extends BoardEntity {
    public Ladder(int start, int end) {
        super(start, end);
        this.setBoardEntityType(BoardEntityType.LADDER);
    }

    @Override
    public void printBoardEntity() {
        System.out.println("Yayy, You encountered a ladder. :)");
    }

    @Override
    public void printEntity() {
        System.out.print("L(" + getEnd() + ")");
    }
}
