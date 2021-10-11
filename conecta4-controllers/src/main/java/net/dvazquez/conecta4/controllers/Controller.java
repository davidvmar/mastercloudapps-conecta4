package net.dvazquez.conecta4.controllers;

import net.dvazquez.conecta4.models.Game;
import net.dvazquez.conecta4.models.State;
import net.dvazquez.conecta4.types.Color;
import net.dvazquez.conecta4.utils.models.Coordinate;

public abstract class Controller {

    protected Game game;
    protected State state;

    Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public void nextState() {
        this.state.next();
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
