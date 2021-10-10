package net.dvazquez.conecta4.models.game;

import net.dvazquez.conecta4.types.Color;

public class Chip {

    private Color color;

    public Chip(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}
