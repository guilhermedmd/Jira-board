package br.board.service;

import java.util.List;

import br.board.model.ColumnBoard;

public interface ColumnService {
    
    public void createColumn(ColumnBoard newColumn, String boardName);

    public List<ColumnBoard> getColumns(String boardName);

    public void deleteColumn(String columnName);

    public void initializeColumns(String boardName);

    public void setPositionsOfColumns(List<ColumnBoard> columns, String nameOfNewColumn, int positionOfNewColumn);

}
