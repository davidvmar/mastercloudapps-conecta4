package net.dvazquez.conecta4.models;

import net.dvazquez.conecta4.types.Color;
import net.dvazquez.conecta4.types.Error;

public class Turn {

    private static final Integer PLAYERS_NUMBER = 2;

    private Board board;
    private Player[] players = new Player[PLAYERS_NUMBER];
    private int currentPlayerIndex = 0;

    public Turn(Board board) {
        assert Color.values().length >= PLAYERS_NUMBER || PLAYERS_NUMBER % Color.values().length == 0;
        this.board = board;
        for (int i = 0; i < PLAYERS_NUMBER; i++) {
            players[i] = new Player(Color.values()[i % Color.values().length], this.board);
        }
    }

    public boolean putChip(int columnToAddChip) {
        boolean putChipWasOk = this.getCurrentPlayer().putChip(columnToAddChip);
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

    public void reset() {
        for (int i = 0; i < PLAYERS_NUMBER; i++) {
            players[i].reset();
        }
        currentPlayerIndex = 0;
    }

    public Error getPutChipError(int column) {
        return this.getCurrentPlayer().getPutChipError(column);
    }

    public void next() {
        if (!this.board.hasGoal()) {
            this.currentPlayerIndex = (this.currentPlayerIndex + 1) % PLAYERS_NUMBER;
        }
    }
}
