package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.controllers.PlayController;
import net.dvazquez.conecta4.views.Messages;

class PlayView {

    private PlayController playController;

    PlayView(PlayController playController) {
        this.playController = playController;
    }

    void interact() {
        do {
            new PlayerView(this.playController).interact();
            this.playController.next();
            new BoardView().print(this.playController);
        } while (!this.playController.hasGoal());
        new MessageView().writeln(Messages.PLAYER_WIN, this.playController.getActiveColor().name());
    }

}
