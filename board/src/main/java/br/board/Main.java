package br.board;

import java.util.ArrayList;
import java.util.List;

import br.board.dao.BlockCardDAO;
import br.board.dao.BoardDAO;
import br.board.dao.ColumnDAO;
import br.board.model.Board;
import br.board.model.ColumnBoard;

public class Main {
    public static void main(String[] args) {
       
        ColumnDAO dao3 = new ColumnDAO(); 
        ColumnBoard column = new ColumnBoard("colunateste", "test", 2);
        System.out.println(dao3.getColumns("teste"));
         System.out.println("----------------------");
        dao3.insertColumn(column, "teste");
        List<ColumnBoard> teste = new ArrayList<>();
        System.out.println(dao3.getColumns("teste"));
        System.out.println("----------------------");
        teste.addAll(dao3.getColumns("teste"));
        dao3.setColumnPosition(teste, "colunateste", 2);
        // dao.insertBoard(board1);
        // dao.insertBoard(board2);
    }
}