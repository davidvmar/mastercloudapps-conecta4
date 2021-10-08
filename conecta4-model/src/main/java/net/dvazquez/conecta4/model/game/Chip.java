package net.dvazquez.conecta4.model.game;

import net.dvazquez.conecta4.model.color.Color;

public class Chip {

    private Color color;

    public Chip(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}
