package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.controllers.StartController;
import net.dvazquez.conecta4.views.Messages;

class StartView  {

    void interact(StartController startController) {
        new GreetingView().print(Messages.GREETING_PLAYERS, String.valueOf(startController.getNumPlayers()));
        new BoardView().print(startController);
        startController.nextState();
    }

}
