package net.dvazquez.conecta4.views;

import net.dvazquez.conecta4.utils.views.Console;

public class ErrorView {

    public void print(Messages message) {
        Console.getInstace().writeln(message.getMessage());
    }
}
