package net.dvazquez.conecta4.views.graphics;

import net.dvazquez.conecta4.controllers.PlayController;
import net.dvazquez.conecta4.controllers.ResumeController;
import net.dvazquez.conecta4.controllers.StartController;
import net.dvazquez.conecta4.views.View;

public class GraphicsView implements View {

    @Override
    public void visit(StartController startController) {
    }

    @Override
    public void visit(PlayController playController) {
    }

    @Override
    public boolean visit(ResumeController resumeController) {
        return true;
    }

}
