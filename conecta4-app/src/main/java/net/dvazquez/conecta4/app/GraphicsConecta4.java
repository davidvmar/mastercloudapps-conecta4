package net.dvazquez.conecta4.app;

import net.dvazquez.conecta4.controllers.Logic;
import net.dvazquez.conecta4.views.graphics.GraphicsView;

public class GraphicsConecta4 extends Conecta4 {
    @Override
    protected GraphicsView createView(Logic logic) {
        return new GraphicsView(logic);
    }

    public static void main(String[] args) {
        new GraphicsConecta4().play();
    }
}
