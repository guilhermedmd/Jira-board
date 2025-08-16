package br.board.service.serviceImp;

import br.board.dao.BlockCardDAO;
import br.board.model.BlockCard;
import br.board.service.BlockCardService;

public class BlockCardServiceImp implements BlockCardService{

    private final static BlockCardDAO db = new BlockCardDAO();

    @Override
    public void createBlock(BlockCard newBlockCard, String task) {
        db.updateBlockCard(newBlockCard, task);
    }

    @Override
    public void showBlockOfCard(String task) {
        db.getBlockCard(task).forEach(b -> System.out.println(b));
    }

    @Override
    public int initializeBlock() {
        return db.blockInitialize(0);
    }
    
}
