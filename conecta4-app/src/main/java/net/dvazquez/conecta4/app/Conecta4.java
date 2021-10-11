package net.dvazquez.conecta4.app;

import net.dvazquez.conecta4.controllers.*;
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
        Controller controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                controller.accept(this.view);
            }
        } while (controller != null);
    }
}
