package net.dvazquez.conecta4.controllers;

import net.dvazquez.conecta4.models.Game;
import net.dvazquez.conecta4.types.Color;
import net.dvazquez.conecta4.types.Error;
import net.dvazquez.conecta4.utils.models.Coordinate;

public class Logic {

    private Game game;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;

    public Logic() {
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
    }

    public int getNumRows() {
        return this.playController.getNumRows();
    }

    public int getNumColumns() {
        return this.playController.getNumColumns();
    }

    public Color getColor(Coordinate coordinate) {
        return this.playController.getColor(coordinate);
    }

    public int getNumPlayers() {
        return this.playController.getNumPlayers();
    }

    public void next() {
        this.playController.next();
    }

    public boolean hasGoal() {
        return this.playController.hasGoal();
    }

    public Color getCurrentColor() {
        return this.playController.getCurrentColor();
    }

    public void reset() {
        this.resumeController.reset();
    }

    public void putChip(int colummn) {
        this.playController.putChip(colummn);
    }

    public Error getPutChipError(int column) {
        return this.playController.getPutChipError(column);
    }
}
