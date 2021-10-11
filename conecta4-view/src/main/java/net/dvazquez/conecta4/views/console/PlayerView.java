package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.controllers.Logic;
import net.dvazquez.conecta4.types.Error;
import net.dvazquez.conecta4.views.Messages;
import net.dvazquez.conecta4.views.WithLogicView;

class PlayerView extends WithLogicView {

    PlayerView(Logic logic) {
        super(logic);
    }

    void interact() {
        if (!this.logic.hasGoal()) {
            this.addChip();
        }
    }

    private void addChip() {
        int colummn;
        Error error;
        do {
            colummn = this.getColumn(Messages.PLAYER_COLUMN_TO_ADD_CHIP);
            error = this.getPutChipError(colummn);
        } while (!error.isNull());
        this.logic.putChip(colummn);
    }

    int getColumn(Messages message) {
        assert message != null;
        return new ColumnView().read(this.logic.getCurrentColor().toString());
    }

    private Error getPutChipError(int column) {
        Error error = this.logic.getPutChipError(column);
        new ErrorView().writeln(error);
        return error;
    }

    
}
