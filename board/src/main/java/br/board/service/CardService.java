package br.board.service;

import java.util.List;

import br.board.model.Card;

public interface CardService {
    
    public void createCard(Card newCard, String columnName, int block_id);

    public void editCard(String task, String description);

    public void deleteCard(String task);

    public List<Card> ShowCardsForColumn(String columnName);

    public void changeColumnOfCard(String task, String columnToChange);

    public void updateCardPositionInBlockOperation(String task);

    public List<Card> showCard(String task);
}
