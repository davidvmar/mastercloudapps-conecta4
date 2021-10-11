package net.dvazquez.conecta4.app;

import net.dvazquez.conecta4.views.console.ConsoleView;

public class ConsoleConecta4 extends Conecta4 {
    @Override
    protected ConsoleView createView() {
        return new ConsoleView(this.startController, this.playController, this.resumeController);
    }

    public static void main(String[] args) {
        new ConsoleConecta4().play();
    }
}
