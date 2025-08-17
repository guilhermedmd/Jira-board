package br.board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.board.config.DbConfig;
import br.board.model.BlockCard;

public class BlockCardDAO {
    private final static CardDAO cardDao = new CardDAO();
    
    public int blockInitialize(int is_blocked){
        int blockId = 0;
        String sql = "insert into block_card (is_blocked) values (?)";
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, is_blocked);
            statement.executeUpdate();
            // pegando a chave primária do objeto inserido
            var resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
               blockId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blockId;
    }

    public void updateBlockCard(BlockCard newBlockCard, String task){
        int blockId = getBlockId(task);
        String sql = "update block_card set is_blocked = ?, block_reason = ?, unblock_reason = ? where id_block = ?";
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setInt(1, newBlockCard.getIsBlocked());
            statement.setString(2, newBlockCard.getBlockReason());
            statement.setString(3, newBlockCard.getUnBlockReason());
            statement.setInt(4, blockId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getBlockId(String taskFromCard){
        int blockId = 0;
        int cardId = cardDao.getCardId(taskFromCard);
        String sql = "select id_block from block_card b inner join card c on b.id_block = c.id_card where c.id_card = ?";
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setInt(1, cardId);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            if(resultSet.next()) blockId = resultSet.getInt("id_block");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blockId;
    }

    public List<BlockCard> getBlockCard(String task){
        int cardId = cardDao.getCardId(task);
        List<BlockCard> blockInfo = new ArrayList<>();
        String sql = "select b.is_blocked, b.block_reason, b.unblock_reason from block_card b inner join card c on b.id_block = c.id_block_fk where c.id_card = ?";
        try {
            Connection connection = DbConfig.getConnection();
            var statement = connection.prepareStatement(sql);
            statement.setInt(1, cardId);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            while(resultSet.next()){
                BlockCard blockCard = new BlockCard();
                blockCard.setIsBlocked(resultSet.getInt("is_blocked"));
                blockCard.setBlockReason(resultSet.getString("block_reason"));
                blockCard.setUnBlockReason(resultSet.getString("unblock_reason"));
                blockInfo.add(blockCard);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blockInfo;
    }
}
