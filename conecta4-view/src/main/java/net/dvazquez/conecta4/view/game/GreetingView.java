package net.dvazquez.conecta4.view.game;

import net.dvazquez.conecta4.model.utils.Console;
import net.dvazquez.conecta4.model.utils.Messages;

public class GreetingView {

    public static void printGreeting(String greeting) {
        Console.getInstace().writeln(greeting);
    }

    public static void printGreeting(Messages greeting, String data) {
        Console.getInstace().writeln(String.format(greeting.getMessage(), data));
    }
}
