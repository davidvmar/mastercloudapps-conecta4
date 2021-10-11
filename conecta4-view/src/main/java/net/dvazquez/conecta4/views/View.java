package net.dvazquez.conecta4.views;

import net.dvazquez.conecta4.controllers.PlayController;
import net.dvazquez.conecta4.controllers.ResumeController;
import net.dvazquez.conecta4.controllers.StartController;

public interface View {

    void start(StartController startController);

    void play(PlayController playController);

    boolean resume(ResumeController resumeController);

}
