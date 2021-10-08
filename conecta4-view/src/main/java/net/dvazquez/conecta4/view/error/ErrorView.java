package net.dvazquez.conecta4.view.error;

import net.dvazquez.conecta4.model.utils.Console;
import net.dvazquez.conecta4.model.utils.Messages;

public class ErrorView {

    public void print(Messages message) {
        Console.getInstace().writeln(message.getMessage());
    }
}
