package br.board.controller;

import java.util.List;
import java.util.Scanner;

import br.board.model.ColumnBoard;
import br.board.service.ColumnService;
import br.board.service.serviceImp.ColumnServiceImp;

public class ColumnController {
    final Scanner input = new Scanner(System.in);
    final ColumnService service = new ColumnServiceImp();

    public void createColumn(String boardName){
        System.out.println("Write the name of the new column:");
        String columnName = input.nextLine();
        System.out.println("Write the position of the new column:");
        int columnPosition = input.nextInt();
        // input daqui serve para que o enter do input da position não entre no type
        input.nextLine();
        System.out.println("Write the type of the column:");
        String type = input.nextLine();
        ColumnBoard newColumn = new ColumnBoard(columnName, type, columnPosition);
        service.createColumn(newColumn, boardName);
        List<ColumnBoard>columns = service.getColumns(boardName);
        // Organizando colunas
        service.setPositionsOfColumns(columns, columnName, columnPosition);
    }

    public void getColumns(String boardName){
        service.getColumns(boardName).forEach(c -> System.out.println(c));
    }

    public void deleteColumn(){
        System.out.println("Write the name of the column that you want to delete:");
        String columnName = input.nextLine();
        service.deleteColumn(columnName);
    }
    public void initializeColumns(String boardName){
        service.initializeColumns(boardName);
    }
}
