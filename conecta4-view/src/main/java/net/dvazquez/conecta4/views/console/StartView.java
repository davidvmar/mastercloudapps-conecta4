package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.controllers.Logic;
import net.dvazquez.conecta4.views.Messages;
import net.dvazquez.conecta4.views.WithLogicView;

class StartView extends WithLogicView {

    StartView(Logic logic) {
        super(logic);
    }

    void interact() {
        new GreetingView().print(Messages.GREETING_PLAYERS, String.valueOf(this.logic.getNumPlayers()));
        new BoardView().print(this.logic);
    }

}
