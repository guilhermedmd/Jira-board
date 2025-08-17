package br.board.ui;

public class Menu {

    public static void showInitialMenu(){
        System.out.println("-----------------------");
        System.out.println("0 - Exit");
        System.out.println("1 - Boards");
        System.out.println("2 - Columns");
        System.out.println("3 - Cards");
        System.out.println("4 - Blocks for cards");
        System.out.println("-----------------------");
    }
    
    public static void showMenuOfBoards(){
        System.out.println("-----------------------");
        System.out.println("0 - Back");
        System.out.println("1 - New Board");
        System.out.println("2 - Load Board");
        System.out.println("3 - Delete Board");
        System.out.println("4 - Show Boards");
        System.out.println("-----------------------");

    }

    public static void showMenuOfColumns(){
        System.out.println("-----------------------");
        System.out.println("0 - Back");
        System.out.println("1 - Create new column");
        System.out.println("2 - Show columns");
        System.out.println("3 - Delete column");
        System.out.println("-----------------------");


    }

    public static void showMenuOfCards(){
        System.out.println("-----------------------");
        System.out.println("0 - Back");
        System.out.println("1 - Create new card");
        System.out.println("2 - Edit card");
        System.out.println("3 - Delete card");
        System.out.println("4 - Change card of column");
        System.out.println("5 - Show all cards of a column");
        System.out.println("6 - Show info of a card");
        System.out.println("-----------------------");
    }

    public static void showMenuOfBlockCards(){
        System.out.println("-----------------------");
        System.out.println("0 - Back");
        System.out.println("1 - Create a block of a card");
        System.out.println("2 - Unblock a card");
        System.out.println("3 - Show block info for a card");
        System.out.println("-----------------------");


    }
}
