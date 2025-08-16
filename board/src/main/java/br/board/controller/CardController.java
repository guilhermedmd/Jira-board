package br.board.controller;

import java.util.List;
import java.util.Scanner;

import br.board.model.Card;
import br.board.service.CardService;
import br.board.service.serviceImp.CardServiceImp;

public class CardController {
    final Scanner input = new Scanner(System.in);
    final CardService service = new CardServiceImp();

    public void createCard(int blockId){
        System.out.println("Write the name of column that you want to insert the task");
        String columnName = input.nextLine();
        System.out.println("Write task of the new card:");
        String task = input.nextLine();
        System.out.println("Write the description of the new task:");
        String description = input.nextLine();
        Card newCard = new Card(task, description);
        service.createCard(newCard, columnName, blockId);
    }

    public void editCard(){
        System.out.println("Write the task of the card that you want to edit:");
        String task = input.nextLine();
        System.out.println("Write the new description:");
        String description = input.nextLine();
        service.editCard(task, description);
    }

    public void deleteCard(){
        System.out.println("Write the task of the card that you want to delete:");
        String task = input.nextLine();
        service.deleteCard(task);
    }

    public void showAllCards(){
        service.showAllCards().forEach(c -> System.out.println(c));
    }

    public void ShowCardsForColumn(){
        System.out.println("Write the name of the column:");
        String columnName = input.nextLine();
        service.ShowCardsForColumn(columnName).forEach(c -> System.out.println(c));
    }

    public void changeColumnOfCard(){
        System.out.println("Write the task of the card that you want to change:");
        String task = input.nextLine();
        System.out.println("Write the name of the column that you want to change the card:");
        String columnName = input.nextLine();
        service.changeColumnOfCard(task, columnName);
    }

    public void updateCardPositionInBlockOperation(String task){
        service.updateCardPositionInBlockOperation(task);
    }
}
