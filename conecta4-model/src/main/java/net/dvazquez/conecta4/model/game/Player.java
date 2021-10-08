package net.dvazquez.conecta4.model.game;

import net.dvazquez.conecta4.model.board.Board;
import net.dvazquez.conecta4.model.color.Color;

import java.util.LinkedList;

public class Player {

    // Extraer de la matriz del Board? podría recibirlo el constructor por parámetro -> Asociación o Composición?
    private final Integer PIECES_BY_PLAYER = 21;

    private Color color;
    private LinkedList<Chip> chips = new LinkedList<>();

    public Player(Color color) {
        this.color = color;
        for (int i = 0; i < PIECES_BY_PLAYER; i++) {
            chips.add(new Chip(this.color));
        }
    }

    public boolean hasChips() {
        return !chips.isEmpty();
    }

    public boolean putChip(Board board, int columnIndex) {
        if (board.canAddChip(columnIndex)) {
            board.addChip(this.chips.pop(), columnIndex);
            return true;
        }
        return false;
    }
}
