package br.board.service;

import br.board.model.BlockCard;

public interface BlockCardService {
    
    public void createBlock(BlockCard newBlockCard, String task);

    public void showBlockOfCard(String task);

    public int initializeBlock();
}
