package net.dvazquez.conecta4.models;

import net.dvazquez.conecta4.types.Color;
import net.dvazquez.conecta4.types.Error;
import net.dvazquez.conecta4.utils.models.Coordinate;

public class Game {

    private Board board;
    private Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void play() {
//        do {
//            this.turn.play();
//        } while (!this.board.hasGoal());
    }

    public Board getBoard() {
        return this.board;
    }

    public Turn getTurn() {
        return this.turn;
    }

    public boolean hasGoal() {
        return this.board.hasGoal();
    }

    public boolean putChip(int column) {
        return this.turn.putChip(column);
    }

    public Color getCurrentColor() {
        return this.turn.getCurrentColor();
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public int getNumColumns() {
        return this.board.getNumColumns();
    }

    public int getNumRows() {
        return this.board.getNumRows();
    }

    public int getNumPlayers() {
        return this.turn.getPlayersNumber();
    }

    public void reset() {
        this.board.reset();
        this.turn.reset();
    }

    public Error getPutChipError(int column) {
        return this.turn.getPutChipError(column);
    }

    public void next() {
        this.turn.next();
    }
}
