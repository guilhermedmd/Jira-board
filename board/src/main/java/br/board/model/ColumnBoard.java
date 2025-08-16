package br.board.model;

public class ColumnBoard {
    private String nome, type;
    private int position, id;

    
    
    public ColumnBoard(String nome, int position) {
        this.nome = nome;
        this.position = position;
    }

    public ColumnBoard() {
    }

    public ColumnBoard(String nome, String type, int position) {
        this.nome = nome;
        this.type = type;
        this.position = position;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "ColumnBoard [nome=" + nome + ", type=" + type + ", position=" + position + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    
}


