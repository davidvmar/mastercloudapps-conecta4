package net.dvazquez.conecta4.models;

import net.dvazquez.conecta4.types.CoordinateDirection;
import net.dvazquez.conecta4.types.Color;
import net.dvazquez.conecta4.utils.models.Coordinate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private static final Integer COLUMNS = 7;
    private static final Integer ROWS = 6;

    private Column[] columns;

    private int lastColumn;

    public Board() {
        Column[] columns = new Column[COLUMNS];
        for (int i = 0; i < COLUMNS; i++) {
            columns[i] = new Column(ROWS);
        }
        this.columns = columns;
    }

    public boolean canAddChip(int columnIndex) {
        assert columnIndex > 0 && columnIndex < 7;
        return !this.columns[columnIndex].isFull();
    }

    public void addChip(Color color, int columnIndex) {
        assert columnIndex > 0 && columnIndex < 7;
        this.columns[columnIndex].addChip(color);
        lastColumn = columnIndex;
    }

    public Integer getNumColumns() {
        return COLUMNS;
    }

    public Integer getNumRows() {
        return ROWS;
    }

    public Color getColor(Coordinate coordinate) {
        assert coordinate != null && isInLimits(coordinate);
        return this.columns[coordinate.getX()].getColor(coordinate.getY());
    }

    private boolean isInLimits(Coordinate coordinate) {
        return coordinate.isInLimits(0, COLUMNS - 1, 0, ROWS - 1);
    }

    public void reset() {
        Arrays.stream(this.columns).forEach(Column::reset);
    }

    public boolean isFull(int column) {
        return this.columns[column].isFull();
    }

    public boolean isInRange(int column) {
        assert column >= 0;
        return column >= 0 && column < this.columns.length;
    }

    private boolean isEmpty() {
        return Arrays.stream(this.columns).allMatch(Column::isEmpty);
    }

    public boolean hasGoal() {
        if (isEmpty()) {
            return false;
        }
        Coordinate lastCoordinate = new Coordinate(lastColumn, this.columns[lastColumn].getLastIndexWithColor());
        List<List<Coordinate>> candidateGroups = getCandidateGroups(lastCoordinate);
        return candidateGroups.stream()
                .anyMatch(candidate -> candidate.stream()
                        .allMatch(coordinate -> this.columns[lastColumn].getLastColor().equals(getColor(coordinate))));
    }

    private List<List<Coordinate>> getCandidateGroups(Coordinate coordinate) {
        List<List<Coordinate>> candidateGroups = new ArrayList();
        for (int i = 0; i < CoordinateDirection.values().length; i++) {
            candidateGroups.addAll(getCandidateGroupsByDirection(coordinate, CoordinateDirection.values()[i]));
        }
        return candidateGroups;
    }

    private List<List<Coordinate>> getCandidateGroupsByDirection(Coordinate coordinate, CoordinateDirection direction) {
        List<List<Coordinate>> groupsOfCandidates = new ArrayList();
        Coordinate firstCandidateCoordinate = getFirstCandidateCoordinate(coordinate, direction);
        boolean handleStarterCoordinate = false;
        do {
            List<Coordinate> candidate = getCandidateByFirstCoordinate(firstCandidateCoordinate, direction);
            if (candidate.size() == 4) {
                groupsOfCandidates.add(candidate);
            }
            handleStarterCoordinate = firstCandidateCoordinate.equals(coordinate);
            firstCandidateCoordinate = direction.getNext(firstCandidateCoordinate);
        } while (isInLimits(firstCandidateCoordinate) && !handleStarterCoordinate);

        return groupsOfCandidates;
    }

    private Coordinate getFirstCandidateCoordinate(Coordinate coordinate, CoordinateDirection direction) {
        Coordinate firstCandidateCoordinate = direction.getFirst(coordinate);
        if (!isInLimits(firstCandidateCoordinate)) {
            do {
                firstCandidateCoordinate = direction.getNext(firstCandidateCoordinate);
            } while (!isInLimits(firstCandidateCoordinate));
        }
        return firstCandidateCoordinate;
    }

    private List<Coordinate> getCandidateByFirstCoordinate(Coordinate coordinate, CoordinateDirection direction) {
        List<Coordinate> candidate = new ArrayList();
        candidate.add(coordinate);
        Coordinate nextCoordinate = coordinate;
        do {
            nextCoordinate = direction.getNext(nextCoordinate);
            if (isInLimits(nextCoordinate)) {
                candidate.add(nextCoordinate);
            }
        } while (candidate.size() < 4 && isInLimits(nextCoordinate));
        return candidate;
    }




}
