package net.dvazquez.conecta4.app;

import net.dvazquez.conecta4.views.graphics.GraphicsView;

public class GraphicsConecta4 extends Conecta4 {
    @Override
    protected GraphicsView createView() {
        return new GraphicsView();
    }

    public static void main(String[] args) {
        new GraphicsConecta4().play();
    }
}
