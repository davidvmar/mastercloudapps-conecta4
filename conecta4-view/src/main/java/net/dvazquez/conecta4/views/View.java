package net.dvazquez.conecta4.views;

import net.dvazquez.conecta4.controllers.PlayController;
import net.dvazquez.conecta4.controllers.ResumeController;
import net.dvazquez.conecta4.controllers.StartController;

public abstract class View {

    protected StartController startController;
    protected PlayController playController;
    protected ResumeController resumeController;

    public View(StartController startController, PlayController playController, ResumeController resumeController) {
        this.startController = startController;
        this.playController = playController;
        this.resumeController = resumeController;
    }

    public abstract void start();

    public abstract void play();

    public abstract boolean resume();

}
