package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.controllers.Logic;
import net.dvazquez.conecta4.utils.models.Coordinate;
import net.dvazquez.conecta4.utils.views.Console;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoardView {

    private static final String MARGIN_LEFT = "          ";
    private static final String DELIMITER = "|";

    public void print(Logic logic) {
        printHeader();
        for (int i = logic.getNumRows() - 1; i >= 0; i--) {
            StringBuilder rowSb = new StringBuilder(MARGIN_LEFT + DELIMITER);
            for (int j = 0; j < logic.getNumColumns(); j++) {
                rowSb.append(logic.getColor(new Coordinate(j, i)).getSymbol());
            }
            rowSb.append(DELIMITER);
            Console.getInstance().writeln(rowSb.toString());
        }
        printFooter(logic.getNumColumns());
    }

    private void printHeader() {
        Console.getInstance().writeln();
    }

    private void printFooter(int numColumns) {
        StringBuilder footerSb = new StringBuilder(MARGIN_LEFT + DELIMITER);
        footerSb.append(IntStream.range(1, 22).mapToObj(i -> "-").collect(Collectors.joining()));
        footerSb.append("|");
        Console.getInstance().writeln(footerSb.toString());
        Console.getInstance().writeln("  índice -> "
                + IntStream.range(0, numColumns).mapToObj(Integer::toString).collect(Collectors.joining("  ")));
        Console.getInstance().writeln();
    }
}
