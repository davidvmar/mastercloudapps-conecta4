package net.dvazquez.conecta4.controllers;

import net.dvazquez.conecta4.models.Game;
import net.dvazquez.conecta4.models.State;

public class ResumeController extends Controller {

    public ResumeController(Game game, State state) {
        super(game, state);
    }

    public void reset() {
        this.game.reset();
        this.state.reset();
    }

    @Override
    public void accept(ControllersVisitor visitor) {
        visitor.visit(this);
    }

}
