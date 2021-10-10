package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.utils.views.Console;
import net.dvazquez.conecta4.views.Messages;

public class ErrorView {

    public void print(Messages message) {
        Console.getInstace().writeln(message.getMessage());
    }
}
