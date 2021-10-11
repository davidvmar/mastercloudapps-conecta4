package net.dvazquez.conecta4.app;

import net.dvazquez.conecta4.controllers.PlayController;
import net.dvazquez.conecta4.controllers.ResumeController;
import net.dvazquez.conecta4.controllers.StartController;
import net.dvazquez.conecta4.models.Game;
import net.dvazquez.conecta4.views.View;

public abstract class Conecta4 {

    private Game game;
    private View view;
    protected StartController startController;
    protected PlayController playController;
    protected ResumeController resumeController;

    protected Conecta4() {
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }
}
