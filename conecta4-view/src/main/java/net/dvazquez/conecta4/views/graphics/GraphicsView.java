package net.dvazquez.conecta4.views.graphics;

import net.dvazquez.conecta4.controllers.PlayController;
import net.dvazquez.conecta4.controllers.ResumeController;
import net.dvazquez.conecta4.controllers.StartController;
import net.dvazquez.conecta4.views.View;

public class GraphicsView implements View {


    @Override
    public void start(StartController startController) {
    }

    @Override
    public void play(PlayController playController) {
    }

    @Override
    public boolean resume(ResumeController resumeController) {
        return true;
    }

}
