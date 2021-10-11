package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.models.Turn;
import net.dvazquez.conecta4.utils.views.Console;
import net.dvazquez.conecta4.views.Messages;

public class TurnView {

    private Turn turn;

    public TurnView(Turn turn) {
        this.turn = turn;
    }

    public int print() {
        return Console.getInstance()
                .readInt(String.format(Messages.PLAYER_COLUMN_TO_ADD_CHIP.getMessage(),
                        String.valueOf(this.turn.getCurrentPlayerIndex() + 1)));
    }
}
