package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.controllers.PlayController;
import net.dvazquez.conecta4.controllers.ResumeController;
import net.dvazquez.conecta4.controllers.StartController;
import net.dvazquez.conecta4.views.View;

public class ConsoleView implements View {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public ConsoleView() {
        this.startView = new StartView();
        this.playView = new PlayView();
        this.resumeView = new ResumeView();
    }

    @Override
    public void start(StartController startController) {
        this.startView.interact(startController);
    }

    @Override
    public void play(PlayController playController) {
        this.playView.interact(playController);
    }

    @Override
    public boolean resume(ResumeController resumeController) {
        return this.resumeView.interact(resumeController);
    }

}
