package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.controllers.PlayController;
import net.dvazquez.conecta4.views.Messages;

class PlayView {

    void interact(PlayController playController) {
        do {
            new PlayerView(playController).interact();
            playController.next();
            new BoardView().print(playController);
        } while (!playController.hasGoal());
        new MessageView().writeln(Messages.PLAYER_WIN, playController.getCurrentColor().name());
        playController.nextState();
    }

}
