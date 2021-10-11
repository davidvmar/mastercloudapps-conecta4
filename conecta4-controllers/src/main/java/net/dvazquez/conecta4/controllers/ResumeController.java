package net.dvazquez.conecta4.controllers;

import net.dvazquez.conecta4.models.Game;

public class ResumeController extends Controller {

    public ResumeController(Game game) {
        super(game);
    }

    public void reset() {
        this.game.reset();
    }

}
