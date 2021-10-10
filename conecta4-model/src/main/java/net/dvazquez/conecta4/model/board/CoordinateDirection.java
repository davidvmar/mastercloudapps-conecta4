package net.dvazquez.conecta4.model.board;

import java.util.function.Function;

public enum CoordinateDirection {
    ROW(
            coordinate -> new Coordinate(coordinate.getX() + 1, coordinate.getY()),
            coordinate -> new Coordinate(coordinate.getX() - 3, coordinate.getY())),
    COLUMN(
            coordinate -> new Coordinate(coordinate.getX(), coordinate.getY() + 1),
            coordinate -> new Coordinate(coordinate.getX(), coordinate.getY() - 3)),
    MAIN_DIAGONAL(
            coordinate -> new Coordinate(coordinate.getX() + 1, coordinate.getY() + 1),
            coordinate -> new Coordinate(coordinate.getX() - 3, coordinate.getY() - 3)),
    REVERSE_DIAGONAL(
            coordinate -> new Coordinate(coordinate.getX() + 1, coordinate.getY() - 1),
            coordinate -> new Coordinate(coordinate.getX() - 3, coordinate.getY() + 3));

    private Function<Coordinate, Coordinate> next;
    private Function<Coordinate, Coordinate> first;

    CoordinateDirection(Function<Coordinate, Coordinate> next, Function<Coordinate, Coordinate> first) {
        this.next = next;
        this.first = first;
    }

    public Coordinate getNext(Coordinate coordinate) {
        return this.next.apply(coordinate);
    }

    public Coordinate getFirst(Coordinate coordinate) {
        return this.first.apply(coordinate);
    }
}
