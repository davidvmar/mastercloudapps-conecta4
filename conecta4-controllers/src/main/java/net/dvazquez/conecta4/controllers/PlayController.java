package net.dvazquez.conecta4.controllers;


import net.dvazquez.conecta4.models.Game;
import net.dvazquez.conecta4.types.Color;
import net.dvazquez.conecta4.types.Error;

public class PlayController extends Controller {

    public PlayController(Game game) {
        super(game);
    }

    public boolean hasGoal() {
        return this.game.hasGoal();
    }

    public void next() {
        this.game.next();
    }

    public Color getActiveColor() {
        return this.game.getCurrentColor();
    }

    public void putChip(int column) {
        this.game.putChip(column);
    }

    public Error getPutChipError(int column) {
        return this.game.getPutChipError(column);
    }

}
