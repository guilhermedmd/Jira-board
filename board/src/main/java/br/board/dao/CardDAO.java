package br.board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.board.config.DbConfig;
import br.board.model.Card;

public class CardDAO {

    private final static ColumnDAO columnDao = new ColumnDAO();

    public int getCardId(String task){
        String sql = "select id_card from card where task = ?";
        int cardId = 0;
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setString(1, task);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            if(resultSet.next()) cardId = resultSet.getInt("id_card");
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return cardId;
    }

    public void insertCard(Card newCard, String columnName, int blockId){
        int columnId = columnDao.getIdFromColumn(columnName);
        String sql = "insert into card(task, description, last_column, id_column_fk, id_block_fk) values (?, ?, ?, ?, ?)";
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setString(1, newCard.getTask());
            statement.setString(2, newCard.getDescription());
            statement.setInt(3, columnId);
            statement.setInt(4, columnId);
            statement.setInt(5, blockId);
            statement.executeUpdate();
            System.out.println("New card created with sucessfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCard(String task, String newDescription){
        int cardId = getCardId(task);
        String sql = "update card set task = ?, description = ? where id_card = ?";
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setString(1, task);
            statement.setString(1, newDescription);
            statement.setInt(3, cardId);
            statement.executeUpdate();
            System.out.println("Description updated with sucessfull");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeCardColumn(String task, String columnToChange){
        int columnId = columnDao.getIdFromColumn(columnToChange);
        int cardId = getCardId(task);
        String sql = "call prc_change_card_column(?, ?)";
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setInt(1, cardId);
            statement.setInt(2, columnId);
            statement.executeUpdate();
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateCardPositionInBlockOperation(String task){
        int cardId = getCardId(task);
        String sql = "pcr_change_column_in_block(?)";
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setInt(1, cardId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCard(String task){
        int cardId = getCardId(task);
        String sql = "delete from card where id = ?";
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setInt(1, cardId);
            statement.executeUpdate();
            System.out.println("Card deleted with sucessfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Card> getAllCards(){
        List<Card> cards = new ArrayList<>();
        String sql = "select task, description, creation_date from card";
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.createStatement();
            statement.executeQuery(sql);
            var resultSet = statement.getResultSet();

            while(resultSet.next()){
                Card card = new Card();
                card.setTask(resultSet.getString("task"));
                card.setDescription(resultSet.getString("description"));
                cards.add(card);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

    public List<Card> getCardsForColumn(String columnName){
        int columnId = columnDao.getIdFromColumn(columnName);
        List<Card> cardsForColumn = new ArrayList<>();
        String sql = "select task, description from card c inner join column_board cb on c.id_column_fk = cb.id_column where cb.id_column = ?";
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setInt(1, columnId);
            statement.executeQuery();

            var resultSet = statement.getResultSet();
            while(resultSet.next()){
                Card card = new Card();
                card.setTask(resultSet.getString("task"));
                card.setDescription(resultSet.getString("description"));
                cardsForColumn.add(card);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardsForColumn;
    }
}
