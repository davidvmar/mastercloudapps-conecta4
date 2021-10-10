package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.models.Conecta4;
import net.dvazquez.conecta4.views.Messages;

public class Connecta4View {

    private Conecta4 connecta4;
    private BoardView boardView;
    private TurnView turnView;

    private Connecta4View() {
        this.connecta4 = new Conecta4();
        this.boardView = new BoardView(this.connecta4.getBoard());
        this.turnView = new TurnView(this.connecta4.getTurn());
    }

    private void play() {
        GreetingView.printGreeting(Messages.GREETING_PLAYERS, String.valueOf(this.connecta4.getTurn().getPlayersNumber()));
        do {
            this.boardView.print();
            int column = this.turnView.print();
            if (!this.connecta4.getTurn().putChip(column)) {
                new ErrorView().print(Messages.ERROR_COLUMN_OUT_OF_INDEX);
            }
        } while (!this.connecta4.hasGoal());
        this.boardView.print();
    }

    public static void main(String[] args) {
        new Connecta4View().play();
    }
}
