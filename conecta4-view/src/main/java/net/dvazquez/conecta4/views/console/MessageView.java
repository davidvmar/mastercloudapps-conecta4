package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.utils.views.Console;
import net.dvazquez.conecta4.views.Messages;

class MessageView {

    void write(Messages message) {
        Console.getInstance().write(message.toString());
    }

    void writeln(Messages message) {
        Console.getInstance().writeln(message.toString());
    }

    void writeln(Messages message, String params) {
        Console.getInstance().writeln(String.format(message.toString(), params.toString()));
    }
    
}
