package br.board.service.serviceImp;

import java.util.List;

import br.board.dao.BoardDAO;
import br.board.model.Board;
import br.board.service.BoardService;

public class BoardServiceImp implements BoardService{

    private final static BoardDAO db = new BoardDAO();

    @Override
    public void createBoard(Board newBoard) {
        db.insertBoard(newBoard);
    }

    @Override
    public void deleteBoard(String boardName) {
        db.deleteBoard(boardName);
    }

    @Override
    public List<Board> showBoards() {
        return db.getBoards();
    }
    
}
