package net.dvazquez.conecta4.views.graphics;

import net.dvazquez.conecta4.controllers.PlayController;
import net.dvazquez.conecta4.controllers.ResumeController;
import net.dvazquez.conecta4.controllers.StartController;
import net.dvazquez.conecta4.views.View;

public class GraphicsView extends View {

    public GraphicsView(StartController startController, PlayController playController,
                        ResumeController resumeController) {
        super(startController, playController, resumeController);
    }

    @Override
    public void start() {
    }

    @Override
    public void play() {
    }

    @Override
    public boolean resume() {
        return true;
    }

}
