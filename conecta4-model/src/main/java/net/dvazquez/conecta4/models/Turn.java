package net.dvazquez.conecta4.models;

import net.dvazquez.conecta4.models.board.Board;
import net.dvazquez.conecta4.types.Color;

public class Turn {

    private static final Integer PLAYERS_NUMBER = 2;

    private Board board;
    private Player[] players = new Player[PLAYERS_NUMBER];
    private int currentPlayerIndex = 0;

    public Turn(Board board) {
        assert Color.values().length >= PLAYERS_NUMBER || PLAYERS_NUMBER % Color.values().length == 0;
        this.board = board;
        for (int i = 0; i < PLAYERS_NUMBER; i++) {
            players[i] = new Player(Color.values()[i % Color.values().length]);
        }
    }

    public boolean putChip(int columnToAddChip) {
        boolean putChipWasOk = this.getCurrentPlayer().putChip(this.board, columnToAddChip);
        if (putChipWasOk) {
            currentPlayerIndex = (currentPlayerIndex + 1) % PLAYERS_NUMBER;
        }
        return putChipWasOk;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public Integer getPlayersNumber() {
        return PLAYERS_NUMBER;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public Color getCurrentColor() {
        return this.getCurrentPlayer().getColor();
    }
}
