package net.dvazquez.conecta4.models.board;

import net.dvazquez.conecta4.types.Color;
import net.dvazquez.conecta4.models.game.Chip;
import net.dvazquez.conecta4.utils.models.Coordinate;

public class Place {

    private Coordinate coordinate;
    private Chip chip;

    // Tipo de relación ASOCIACIÓN entre place y coordinate?
    public Place(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.chip = new Chip(Color.NULL);
    }

    // Tipo de relación COMPOSICIÓN entre place y coordinate?
    public Place(Integer x, Integer y) {
        this.coordinate = new Coordinate(x, y);
    }

    public boolean isEmpty() {
        return Color.NULL.equals(this.chip.getColor());
    }

    public void setChip(Chip chip) {
        this.chip = chip;
    }

    public Chip getChip() {
        return this.chip;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public Color getColor() {
        return this.chip.getColor();
    }

}
