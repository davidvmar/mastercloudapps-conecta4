package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.types.Error;
import net.dvazquez.conecta4.utils.views.Console;

public class ErrorView extends net.dvazquez.conecta4.views.ErrorView {

    @Override
    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(
                    net.dvazquez.conecta4.views.ErrorView.MESSAGES.get(error));
        }
    }
}
