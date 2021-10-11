package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.utils.views.Console;
import net.dvazquez.conecta4.views.Messages;

class ColumnView {

    public int read(String playerColor) {
        return Console.getInstance()
                .readInt(String.format(Messages.PLAYER_COLUMN_TO_ADD_CHIP.getMessage(), playerColor));
    }

}
