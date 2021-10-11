package net.dvazquez.conecta4.models;

import net.dvazquez.conecta4.types.Color;
import net.dvazquez.conecta4.types.Error;

import java.util.LinkedList;

public class Player {

    // Extraer de la matriz del Board? podría recibirlo el constructor por parámetro -> Asociación o Composición?
    private final Integer PIECES_BY_PLAYER = 21;

    private Color color;
    private LinkedList<Color> chips = new LinkedList<>();
    private Board board;

    public Player(Color color, Board board) {
        this.color = color;
        this.board = board;
        for (int i = 0; i < PIECES_BY_PLAYER; i++) {
            chips.add(this.color);
        }
    }

    public boolean hasChips() {
        return !chips.isEmpty();
    }

    public boolean putChip(int columnIndex) {
        if (this.board.canAddChip(columnIndex)) {
            this.board.addChip(this.chips.pop(), columnIndex);
            return true;
        }
        return false;
    }

    public Color getColor() {
        return this.color;
    }

    public void reset() {
        this.chips = new LinkedList<>();
        for (int i = 0; i < PIECES_BY_PLAYER; i++) {
            chips.add(this.color);
        }
    }

    public Error getPutChipError(int column) {
        if (this.board.isFull(column)) {
            return Error.COLUMN_IS_FULL;
        }
        return Error.NULL;
    }
}
