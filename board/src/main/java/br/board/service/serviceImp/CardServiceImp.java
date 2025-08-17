package br.board.service.serviceImp;

import java.util.List;

import br.board.dao.CardDAO;
import br.board.model.Card;
import br.board.service.CardService;

public class CardServiceImp implements CardService{

    private CardDAO db = new CardDAO();

    @Override
    public void createCard(Card newCard, String columnName, int blockId) {
        db.insertCard(newCard, columnName, blockId);
    }

    @Override
    public void editCard(String task, String description) {
        db.updateCard(task, description);
    }

    @Override
    public void deleteCard(String task) {
        db.deleteCard(task);
    }

    @Override
    public List<Card> ShowCardsForColumn(String columnName) {
        return db.getCardsForColumn(columnName);
    }

    @Override
    public void changeColumnOfCard(String task, String columnToChange) {
        db.changeCardColumn(task, columnToChange);
    }

    @Override
    public void updateCardPositionInBlockOperation(String task) {
        db.updateCardPositionInBlockOperation(task);
    }

    @Override
    public List<Card> showCard(String task) {
        return db.getCard(task);
    }
    
}
