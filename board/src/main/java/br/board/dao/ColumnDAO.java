package br.board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.board.config.DbConfig;
import br.board.model.ColumnBoard;

public class ColumnDAO {
    private final static BoardDAO boardDao = new BoardDAO();

    // colunas inicial, bloqueado e concluída
    public void columnInitialize(String boardName){
        int boardId = boardDao.getIdFromBoard(boardName);
        String sql = "insert into column_board(name, position, type, id_board_fk) values('inicial', 1, 'inicial', ?), ('Conluída', 2, 'concluida', ?), ('Bloqueados', 3, 'bloq', ?)";

        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setInt(1, boardId);
            statement.setInt(2, boardId);
            statement.setInt(3, boardId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertColumn(ColumnBoard newColumn, String boardName){
        int boardId = boardDao.getIdFromBoard(boardName);
        List<ColumnBoard> columns = getColumns(boardName);
        String sql = "insert into column_board (name, position, type, id_board_fk) values (?, ?, ?, ?)";
        if(columns.size() > newColumn.getPosition()){
            try {
                Connection connection = DbConfig.getConnection();
                var statement = connection.prepareStatement(sql);
                statement.setString(1, newColumn.getColumnName());
                statement.setInt(2, newColumn.getPosition());
                statement.setString(3, newColumn.getType());
                statement.setInt(4, boardId);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            throw new RuntimeException("Error: The position of new column cannot is greater than de number of the columns already existents");
        }
        
    }

    public List<ColumnBoard> getColumns(String boardName){
        int boardId = boardDao.getIdFromBoard(boardName);
        String sql = "select id_column, name, position, type from column_board where id_board_fk = ?";

        List<ColumnBoard> columns = new ArrayList<>();
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setInt(1, boardId);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            while(resultSet.next()){
                ColumnBoard column = new ColumnBoard();
                column.setId(resultSet.getInt("id_column"));
                column.setColumnName(resultSet.getString("name"));
                column.setPosition(resultSet.getInt("position"));
                column.setType(resultSet.getString("type"));
                columns.add(column);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columns;
    }

    public int getIdFromColumn(String columnName){
        int columnId = 0;
        String sql = "select id_column from column_board where name = ?";
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setString(1, columnName);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            if(resultSet.next()) columnId = resultSet.getInt("id_column");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("id da coluna que está retornando"+columnId);
        return columnId;
    }

    public void setColumnPosition(List<ColumnBoard> columnsNPositions, String columnNameToChange, int PositionToAdd){
            columnsNPositions.stream().filter(c -> c.getPosition() >= PositionToAdd && (!c.getColumnName().equals(columnNameToChange))).forEach(c -> c.setPosition(c.getPosition()+1));

            String sql = "update column_board set position = ? where id_column = ?";
            try {
                Connection connection = DbConfig.getConnection();
                var statement = connection.prepareStatement(sql);
                for (ColumnBoard c : columnsNPositions) {
                    statement.setInt(1, c.getPosition());
                    statement.setInt(2, c.getId());
                    statement.executeUpdate();
                }
                System.out.println("Columns reorganized with sucessfull");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void deleteColumn(String columnName){
        int columnId = getIdFromColumn(columnName);
        String sql = "delete from columnBoard where id_column = ?";

        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setInt(1, columnId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
