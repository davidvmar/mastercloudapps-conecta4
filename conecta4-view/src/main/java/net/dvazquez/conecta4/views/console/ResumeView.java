package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.controllers.ResumeController;
import net.dvazquez.conecta4.utils.views.YesNoDialog;
import net.dvazquez.conecta4.views.Messages;

class ResumeView {

    private ResumeController resumeController;

    ResumeView(ResumeController resumeController) {
        this.resumeController = resumeController;
    }

    boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Messages.RESUME.toString());
        if (isResumed.isAffirmative()) {
            this.resumeController.reset();
        }
        return isResumed.isAffirmative();
    }

}
