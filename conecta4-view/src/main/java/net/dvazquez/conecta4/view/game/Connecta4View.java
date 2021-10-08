package net.dvazquez.conecta4.view.game;

import net.dvazquez.conecta4.model.Conecta4;
import net.dvazquez.conecta4.model.utils.Messages;
import net.dvazquez.conecta4.view.board.BoardView;
import net.dvazquez.conecta4.view.error.ErrorView;
import net.dvazquez.conecta4.view.turn.TurnView;

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
        } while (!this.connecta4.getBoard().hasGoal());
    }

    public static void main(String[] args) {
        new Connecta4View().play();
    }
}
