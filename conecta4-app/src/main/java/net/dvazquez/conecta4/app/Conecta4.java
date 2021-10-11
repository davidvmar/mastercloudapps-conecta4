package net.dvazquez.conecta4.app;

import net.dvazquez.conecta4.controllers.Logic;
import net.dvazquez.conecta4.controllers.PlayController;
import net.dvazquez.conecta4.controllers.ResumeController;
import net.dvazquez.conecta4.controllers.StartController;
import net.dvazquez.conecta4.views.View;

public abstract class Conecta4 {

    private View view;
    private Logic logic;

    protected Conecta4() {
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        do {
            if (this.logic.getController() instanceof StartController) {
                this.view.start((StartController) this.logic.getController());
            } else {
                if (this.logic.getController() instanceof PlayController) {
                    this.view.play((PlayController) this.logic.getController());
                } else {
                    this.view.resume((ResumeController) this.logic.getController());
                }
            }
        } while (this.logic.getController() != null);
    }
}
