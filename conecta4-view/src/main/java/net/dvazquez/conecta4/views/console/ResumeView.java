package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.controllers.ResumeController;
import net.dvazquez.conecta4.utils.views.YesNoDialog;
import net.dvazquez.conecta4.views.Messages;

class ResumeView {

    boolean interact(ResumeController resumeController) {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Messages.RESUME.toString());
        if (isResumed.isAffirmative()) {
            resumeController.reset();
        } else {
            resumeController.nextState();
        }
        return isResumed.isAffirmative();
    }

}
