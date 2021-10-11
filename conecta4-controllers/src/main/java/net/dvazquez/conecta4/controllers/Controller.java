package net.dvazquez.conecta4.controllers;

import net.dvazquez.conecta4.models.Game;
import net.dvazquez.conecta4.types.Color;
import net.dvazquez.conecta4.utils.models.Coordinate;

public abstract class Controller {

    protected Game game;

    Controller(Game game) {
        this.game = game;
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

    public int getNumColumns() {
        return this.game.getNumColumns();
    }

    public int getNumRows() {
        return this.game.getNumRows();
    }

    public int getNumPlayers() {
        return this.game.getNumPlayers();
    }
}
