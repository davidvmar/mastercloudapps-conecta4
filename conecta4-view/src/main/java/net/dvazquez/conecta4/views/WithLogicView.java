package net.dvazquez.conecta4.views;

import net.dvazquez.conecta4.controllers.Logic;

public abstract class WithLogicView {

    protected Logic logic;

    public WithLogicView(Logic logic) {
        this.logic = logic;
    }
    
}
