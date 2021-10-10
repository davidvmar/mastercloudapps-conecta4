package net.dvazquez.conecta4.views.console;

import net.dvazquez.conecta4.models.board.Board;
import net.dvazquez.conecta4.utils.views.Console;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoardView {

    private Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    public void print() {
        Integer numRows = this.board.getNumRows();
        Integer numColumns = this.board.getNumColumns();

        printHeader();
        for (int i = numRows - 1; i >= 0; i--) {
            StringBuilder rowSb = new StringBuilder("|");
            for (int j = 0; j < numColumns; j++) {
                rowSb.append(this.board.getColumns()[j].getPlaces().get(i).getChip().getColor().getSymbol());
            }
            rowSb.append("|");
            Console.getInstace().writeln(rowSb.toString());
        }
        printFooter();
    }

    private void printHeader() {
        Console.getInstace().writeln();
    }

    private void printFooter() {
        StringBuilder footerSb = new StringBuilder("|");
        footerSb.append(IntStream.range(1, 22).mapToObj(i -> "-").collect(Collectors.joining()));
        footerSb.append("|");
        Console.getInstace().writeln(footerSb.toString());
        Console.getInstace().writeln();
    }
}
