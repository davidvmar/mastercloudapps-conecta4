package net.dvazquez.conecta4.model;

import net.dvazquez.conecta4.model.board.Board;
import net.dvazquez.conecta4.model.color.Color;
import net.dvazquez.conecta4.model.game.Turn;

public class Conecta4 {

    private Board board;
    private Turn turn;

    public Conecta4() {
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

    public Color getCurrentColor() {
        return this.turn.getCurrentColor();
    }
}
