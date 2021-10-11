package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.controllers.StartController;
import net.dvazquez.conecta4.views.Messages;

class StartView{

    private StartController startController;

    StartView(StartController startController) {
        this.startController = startController;
    }

    void interact() {
        new GreetingView().print(Messages.GREETING_PLAYERS, String.valueOf(this.startController.getNumPlayers()));
        new BoardView().print(this.startController);
    }

}
