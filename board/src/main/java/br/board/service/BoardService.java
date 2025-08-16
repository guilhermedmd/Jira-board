package br.board.service;

import java.util.List;

import br.board.model.Board;

public interface BoardService {
    
    public void createBoard(Board board);

    public void deleteBoard(String boardName);

    public List<Board> showBoards();
}
