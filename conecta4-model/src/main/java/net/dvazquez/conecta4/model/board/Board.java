package net.dvazquez.conecta4.model.board;

import net.dvazquez.conecta4.model.game.Chip;

public class Board {

    private static final Integer COLUMNS = 7;
    private static final Integer ROWS = 6;

    private Column[] columns;

    public Board() {
        Column[] columns = new Column[COLUMNS];
        for (int i = 0; i < COLUMNS; i++) {
            columns[i] = new Column(new Coordinate(i), ROWS);
        }
        this.columns = columns;
    }

    public boolean hasGoal() {
        // TODO: comprobación de 4 en raya
        return false;
    }

    public boolean canAddChip(int columnIndex) {
        assert columnIndex > 0 && columnIndex < 7;
        return !this.columns[columnIndex].isFull();
    }

    public void addChip(Chip chip, int columnIndex) {
        assert columnIndex > 0 && columnIndex < 7;
        this.columns[columnIndex].addChip(chip);
    }

    public Column[] getColumns() {
        return this.columns;
    }

    public Integer getNumColumns() {
        return COLUMNS;
    }

    public Integer getNumRows() {
        return ROWS;
    }
}
