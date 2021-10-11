package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.controllers.PlayController;
import net.dvazquez.conecta4.types.Error;
import net.dvazquez.conecta4.views.Messages;

class PlayerView {

    private PlayController playController;

    PlayerView(PlayController playController) {
        this.playController = playController;
    }

    void interact() {
        if (!this.playController.hasGoal()) {
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
        this.playController.putChip(colummn);
    }

    int getColumn(Messages message) {
        assert message != null;
        return new ColumnView().read(this.playController.getCurrentColor().toString());
    }

    private Error getPutChipError(int column) {
        Error error = this.playController.getPutChipError(column);
        new ErrorView().writeln(error);
        return error;
    }

    
}
