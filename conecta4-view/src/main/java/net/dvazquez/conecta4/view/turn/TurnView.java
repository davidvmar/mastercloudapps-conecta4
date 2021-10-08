package net.dvazquez.conecta4.view.turn;

import net.dvazquez.conecta4.model.game.Turn;
import net.dvazquez.conecta4.model.utils.Console;
import net.dvazquez.conecta4.model.utils.Messages;

public class TurnView {

    private Turn turn;

    public TurnView(Turn turn) {
        this.turn = turn;
    }

    public int print() {
        return Console.getInstace()
                .readInt(String.format(Messages.PLAYER_COLUMN_TO_ADD_CHIP.getMessage(),
                        String.valueOf(this.turn.getCurrentPlayerIndex() + 1)));
    }
}
