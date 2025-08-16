package br.board;

import java.util.Scanner;

import br.board.controller.BlockCardController;
import br.board.controller.BoardController;
import br.board.controller.CardController;
import br.board.controller.ColumnController;
import br.board.ui.Menu;

public class Main {
    final static Scanner input = new Scanner(System.in);
    final static BoardController board = new BoardController();
    final static ColumnController column = new ColumnController();
    final static CardController card = new CardController();
    final static BlockCardController block = new BlockCardController();
    

    public static void main(String[] args) {
    int option = 0;
    String selectedBoard = null;

    do{
        System.out.println("-----------------------");
        System.out.println("0 - Exit");
        System.out.println("1 - Boards");
        System.out.println("2 - Columns");
        System.out.println("3 - Cards");
        System.out.println("4 - Blocks for cards");
        System.out.println("-----------------------");

        option = input.nextInt();
        switch (option) {
            case 0 -> System.exit(0);
            case 1 -> {
                do{
                Menu.showMenuOfBoards();
                option = input.nextInt();
                switch (option) {
                    case 1 -> {
                        selectedBoard = board.createBoard();
                        column.initializeColumns(selectedBoard);
                    }
                    case 2 -> selectedBoard = board.loadBoard();
                    case 3 -> board.deleteBoard();
                    // implementar versão para mostrar os boards
                    }
                }while(option != 0);
            }
            case 2 -> {
                if(selectedBoard.isEmpty()){
                    throw new RuntimeException("Error: First you need to select a board");
                }
                do{
                    Menu.showMenuOfColumns();
                    option = input.nextInt();
                    switch (option) {
                        case 1 -> column.createColumn(selectedBoard);
                        case 2 -> column.getColumns(selectedBoard);
                        // precisa implementar
                        case 3 -> column.deleteColumn();
                    }
                }while(option != 0);
                
            }
            case 3 -> {
                do{
                Menu.showMenuOfCards();
                option = input.nextInt();
                    switch (option) {
                        case 1 -> {
                            int blockId = block.initializeBlock();
                            card.createCard(blockId);
                        }
                        case 2 -> card.editCard();
                        case 3 -> card.deleteCard();
                        case 4 -> card.changeColumnOfCard();
                        case 5 -> card.ShowCardsForColumn();
                        case 6 -> card.showAllCards();
                        }
                }while(option != 0);
            }
            case 4 ->{
                do{
                    Menu.showMenuOfBlockCards();
                    option = input.nextInt();
                    switch (option) {
                        case 1 -> {
                            String taskSelected = block.createBlock();
                            card.updateCardPositionInBlockOperation(taskSelected);
                        }
                        case 2 ->{
                            String taskSelected = block.unBlock();
                            card.updateCardPositionInBlockOperation(taskSelected);
                        }
                        case 3 -> block.getBlockFromCard();
                    }
                }while(option != 0);
            }
        }
    }while(true);



    }
}