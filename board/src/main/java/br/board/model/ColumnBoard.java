package br.board.model;

public class ColumnBoard {
    private String columnName, type;
    private int position, id;

    
    
    public ColumnBoard(String nome, int position) {
        this.columnName = nome;
        this.position = position;
    }

    public ColumnBoard() {
    }

    public ColumnBoard(String nome, String type, int position) {
        this.columnName = nome;
        this.type = type;
        this.position = position;
    }

    

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String nome) {
        this.columnName = nome;
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
        return "ColumnBoard [nome=" + columnName + ", type=" + type + ", position=" + position + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    
}


