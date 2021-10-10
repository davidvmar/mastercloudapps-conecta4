package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.utils.views.Console;
import net.dvazquez.conecta4.views.Messages;

public class GreetingView {

    public static void printGreeting(String greeting) {
        Console.getInstace().writeln(greeting);
    }

    public static void printGreeting(Messages greeting, String data) {
        Console.getInstace().writeln(String.format(greeting.getMessage(), data));
    }
}
