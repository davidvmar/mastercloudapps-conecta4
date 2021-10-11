package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.controllers.Controller;
import net.dvazquez.conecta4.utils.models.Coordinate;
import net.dvazquez.conecta4.utils.views.Console;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoardView {

    public void print(Controller controller) {
        printHeader();
        for (int i = controller.getNumRows() - 1; i >= 0; i--) {
            StringBuilder rowSb = new StringBuilder("|");
            for (int j = 0; j < controller.getNumColumns(); j++) {
                rowSb.append(controller.getColor(new Coordinate(j, i)).getSymbol());
            }
            rowSb.append("|");
            Console.getInstance().writeln(rowSb.toString());
        }
        printFooter();
    }

    private void printHeader() {
        Console.getInstance().writeln();
    }

    private void printFooter() {
        StringBuilder footerSb = new StringBuilder("|");
        footerSb.append(IntStream.range(1, 22).mapToObj(i -> "-").collect(Collectors.joining()));
        footerSb.append("|");
        Console.getInstance().writeln(footerSb.toString());
        Console.getInstance().writeln("  0  1  2  3  4  5  6");
        Console.getInstance().writeln();
    }
}
