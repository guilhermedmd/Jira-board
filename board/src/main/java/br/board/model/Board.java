package br.board.model;

public class Board {
    private String boardName;

    public Board() {
    }

    public Board(String name) {
        this.boardName = name;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String name) {
        this.boardName = name;
    }

    @Override
    public String toString() {
        return "Board [name=" + boardName + "]";
    }

    
    
}
