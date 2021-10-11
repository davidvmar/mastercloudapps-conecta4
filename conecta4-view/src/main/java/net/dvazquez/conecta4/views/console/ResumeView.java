package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.controllers.Logic;
import net.dvazquez.conecta4.utils.views.YesNoDialog;
import net.dvazquez.conecta4.views.Messages;
import net.dvazquez.conecta4.views.WithLogicView;

class ResumeView extends WithLogicView {

    ResumeView(Logic logic) {
        super(logic);
    }

    boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Messages.RESUME.toString());
        if (isResumed.isAffirmative()) {
            this.logic.reset();
        }
        return isResumed.isAffirmative();
    }

}
