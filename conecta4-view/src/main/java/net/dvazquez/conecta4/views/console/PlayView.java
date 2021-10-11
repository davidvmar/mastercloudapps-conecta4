package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.controllers.Logic;
import net.dvazquez.conecta4.views.Messages;
import net.dvazquez.conecta4.views.WithLogicView;

class PlayView extends WithLogicView {

    PlayView(Logic logic) {
        super(logic);
    }

    void interact() {
        do {
            new PlayerView(this.logic).interact();
            this.logic.next();
            new BoardView().print(this.logic);
        } while (!this.logic.hasGoal());
        new MessageView().writeln(Messages.PLAYER_WIN, this.logic.getCurrentColor().name());
    }

}
