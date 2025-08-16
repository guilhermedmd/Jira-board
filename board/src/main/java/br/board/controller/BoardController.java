package br.board.controller;

import java.util.Scanner;

import br.board.model.Board;
import br.board.service.BoardService;
import br.board.service.serviceImp.BoardServiceImp;

public class BoardController {
    final Scanner input = new Scanner(System.in);
    private final static BoardService service = new BoardServiceImp();

    public String createBoard(){
        System.out.println("Write the name from a new board:");
        String boardName = input.nextLine();
        Board newboard = new Board(boardName);
        service.createBoard(newboard);
        return boardName;
    }

    public String loadBoard(){
        System.out.println("Write the name of the board that you want to load:");
        String boardName = input.nextLine();
        return boardName;

    }

    public void deleteBoard(){
        System.out.println("Write the name of the board that you want to delete:");
        String boardName = input.nextLine();
        service.deleteBoard(boardName);
    }
}
