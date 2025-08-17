package br.board.service.serviceImp;

import java.util.List;

import br.board.dao.ColumnDAO;
import br.board.model.ColumnBoard;
import br.board.service.ColumnService;

public class ColumnServiceImp implements ColumnService{
    private ColumnDAO db = new ColumnDAO();

    @Override
    public void createColumn(ColumnBoard newColumn, String boardName) {
        db.insertColumn(newColumn, boardName);
    }

    @Override
    public List<ColumnBoard> getColumns(String boardName) {
        return db.getColumns(boardName);
    }

    @Override
    public void deleteColumn(String columnName) {
        db.deleteColumn(columnName);
    }

    @Override
    public void initializeColumns(String boardName) {
        db.columnInitialize(boardName);
    }

    @Override
    public void setPositionsOfColumns(List<ColumnBoard> columns, String nameOfNewColumn, int positionOfNewColumn) {
        db.setColumnPosition(columns, nameOfNewColumn, positionOfNewColumn);
    }
    
}
