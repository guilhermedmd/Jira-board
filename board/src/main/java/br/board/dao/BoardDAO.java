package br.board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.board.config.DbConfig;
import br.board.model.Board;

public class BoardDAO {

    public void insertBoard(final Board newBoard){
        String sql = "insert into Board (name) values (?)";
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setString(1, newBoard.getBoardName());
            statement.executeUpdate();

            System.out.println("New board save with sucessfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Board> getBoards(){
        String sql = "select name from board";
        List<Board> boards = new ArrayList<>();
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.createStatement();
            statement.executeQuery(sql);
            var resultSet = statement.getResultSet();

            while(resultSet.next()){
                Board board = new Board();
                board.setBoardName(resultSet.getString("name"));
                boards.add(board);
            }
                           
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return boards;
    }

    public int getIdFromBoard(String boardName){
        String sql = "select id_board from board where name = ?";
        int boardId = 0;
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setString(1, boardName);
            statement.executeQuery();
            var resultSet = statement.getResultSet();

            if(resultSet.next()) boardId = resultSet.getInt("id_board");
            

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return boardId;
    }

    public void deleteBoard(String boardName){
        int boardId = getIdFromBoard(boardName);
        String sql = "delete from board where board_id = "+boardId;
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Board deleted with sucessfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
