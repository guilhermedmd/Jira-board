package br.board.controller;

import java.util.Scanner;

import br.board.model.BlockCard;
import br.board.service.BlockCardService;
import br.board.service.serviceImp.BlockCardServiceImp;

public class BlockCardController {
    final Scanner input = new Scanner(System.in);
    final BlockCardService service = new BlockCardServiceImp();

    public int initializeBlock(){
        // retorna o id do bloqueio
        return service.initializeBlock();
    }

    public String createBlock(){
        System.out.println("Write the name of the task that you want to block:");
        String task = input.nextLine();
        System.out.println("Write the reason of the block:");
        String reasonOfBlock = input.nextLine();
        BlockCard newBlockCard = new BlockCard(1, reasonOfBlock, null);
        service.createBlock(newBlockCard, task);
        return task;
    }

    public String unBlock(){
        System.out.println("Write the name of the task that you want to unblock:");
        String task = input.nextLine();
        System.out.println("Write the reason of the unblock:");
        String unBlockReason = input.nextLine();
        BlockCard newBlockCard = new BlockCard(0, null, unBlockReason);
        service.createBlock(newBlockCard, task);
        return task;
    }

    public void getBlockFromCard(){
        System.out.println("Write the task of the card to check the block:");
        String task = input.nextLine();
        service.showBlockOfCard(task);
    }
}
