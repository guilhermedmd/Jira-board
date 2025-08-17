package br.board.model;

public class Card {
    
    private String task, description, ColumnName;

    public Card() {
    }
    

    public Card(String task, String description, String columnName) {
        this.task = task;
        this.description = description;
        this.ColumnName = columnName;
    }


    public Card(String task, String description) {
        this.task = task;
        this.description = description;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    public String getColumnName() {
        return ColumnName;
    }


    public void setColumnName(String columnName) {
        ColumnName = columnName;
    }


    @Override
    public String toString() {
        return "Card [task=" + task + ", description=" + description + "]";
    }


    
}
