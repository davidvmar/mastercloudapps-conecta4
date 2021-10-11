package net.dvazquez.conecta4.app;

import net.dvazquez.conecta4.controllers.Logic;
import net.dvazquez.conecta4.views.console.ConsoleView;

public class ConsoleConecta4 extends Conecta4 {
    @Override
    protected ConsoleView createView(Logic logic) {
        return new ConsoleView(logic);
    }

    public static void main(String[] args) {
        new ConsoleConecta4().play();
    }
}
