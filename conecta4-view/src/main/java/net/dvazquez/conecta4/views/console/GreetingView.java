package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.utils.views.Console;
import net.dvazquez.conecta4.views.Messages;

public class GreetingView {

    public void print(Messages greeting, String data) {
        Console.getInstance().writeln();
        Console.getInstance().writeln("****************************************************************");
        Console.getInstance().writeln("*************************** CONECTA4 ***************************");
        Console.getInstance().writeln("****************************************************************");
        Console.getInstance().writeln();
        Console.getInstance().writeln(String.format(greeting.getMessage(), data));
    }
}
