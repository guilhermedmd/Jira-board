package br.board.model;

public class BlockCard {
    private int isBlocked;
    private String blockReason;
    private String unBlockReason;
    
    public BlockCard() {
    }

    public BlockCard(int isBlocked, String blockReason, String unBlockReason) {
        this.isBlocked = isBlocked;
        this.blockReason = blockReason;
        this.unBlockReason = unBlockReason;
    }

    public int getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(int isBlocked) {
        this.isBlocked = isBlocked;
    }

    public String getBlockReason() {
        return blockReason;
    }

    public void setBlockReason(String blockReason) {
        this.blockReason = blockReason;
    }

    public String getUnBlockReason() {
        return unBlockReason;
    }

    public void setUnBlockReason(String unBlockReason) {
        this.unBlockReason = unBlockReason;
    }

    @Override
    public String toString() {
        return "BlockCard [isBlocked=" + isBlocked + ", blockReason=" + blockReason + ", unBlockReason=" + unBlockReason
                + "]";
    }

    
    
}
