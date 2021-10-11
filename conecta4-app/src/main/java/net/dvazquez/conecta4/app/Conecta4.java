package net.dvazquez.conecta4.app;

import net.dvazquez.conecta4.controllers.Logic;
import net.dvazquez.conecta4.views.View;

public abstract class Conecta4 {

    private View view;
    private Logic logic;

    protected Conecta4() {
        this.logic = new Logic();
        this.view = this.createView(this.logic);
    }

    protected abstract View createView(Logic logic);

    protected void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }
}
