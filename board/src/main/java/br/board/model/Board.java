package br.board.model;

public class Board {
    private String name;

    public Board() {
    }

    public Board(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Board [name=" + name + "]";
    }

    
    
}
