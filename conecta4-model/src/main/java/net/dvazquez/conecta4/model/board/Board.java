package net.dvazquez.conecta4.model.board;

import net.dvazquez.conecta4.model.color.Color;
import net.dvazquez.conecta4.model.game.Chip;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final Integer COLUMNS = 7;
    private static final Integer ROWS = 6;

    private Column[] columns;

    private Place lastPlace;

    public Board() {
        Column[] columns = new Column[COLUMNS];
        for (int i = 0; i < COLUMNS; i++) {
            columns[i] = new Column(new Coordinate(i), ROWS);
        }
        this.columns = columns;
    }

    public boolean canAddChip(int columnIndex) {
        assert columnIndex > 0 && columnIndex < 7;
        return !this.columns[columnIndex].isFull();
    }

    public void addChip(Chip chip, int columnIndex) {
        assert columnIndex > 0 && columnIndex < 7;
        lastPlace = this.columns[columnIndex].addChip(chip);
    }

    public Column[] getColumns() {
        return this.columns;
    }

    public Integer getNumColumns() {
        return COLUMNS;
    }

    public Integer getNumRows() {
        return ROWS;
    }

    public boolean hasGoal() {
        List<List<Coordinate>> candidateGroups = getCandidateGroups(this.lastPlace.getCoordinate());
        return candidateGroups.stream()
                .anyMatch(candidate -> candidate.stream()
                        .allMatch(coordinate -> this.lastPlace.getColor().equals(getColorByCoordinate(coordinate))));
    }

    private List<List<Coordinate>> getCandidateGroups(Coordinate lastCoordinate) {
        List<List<Coordinate>> candidateGroups = new ArrayList();
        for (int i = 0; i < CoordinateDirection.values().length; i++) {
            candidateGroups.addAll(getCandidateGroupsByDirection(lastCoordinate, CoordinateDirection.values()[i]));
        }
        return candidateGroups;
    }

    private Color getColorByCoordinate(Coordinate coordinate) {
        assert coordinate != null && isInLimits(coordinate);
        return this.columns[coordinate.getX()].getColorByPosition(coordinate.getY());
    }

    private List<List<Coordinate>> getCandidateGroupsByDirection(Coordinate lastCoordinate, CoordinateDirection direction) {
        List<List<Coordinate>> groupsOfCandidates = new ArrayList();
        Coordinate firstCandidateCoordinate = getFirstCandidateCoordinate(lastCoordinate, direction);
        boolean handleLastPut = false;
        do {
            List<Coordinate> candidate = getCandidateByFirstCoordinate(firstCandidateCoordinate, direction);
            if (candidate.size() == 4) {
                groupsOfCandidates.add(candidate);
            }
            handleLastPut = firstCandidateCoordinate.equals(lastCoordinate);
            firstCandidateCoordinate = direction.getNext(firstCandidateCoordinate);
        } while (isInLimits(firstCandidateCoordinate) && !handleLastPut);

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

    private List<Coordinate> getCandidateByFirstCoordinate(Coordinate firstCoordinate, CoordinateDirection direction) {
        List<Coordinate> candidate = new ArrayList();
        candidate.add(firstCoordinate);
        Coordinate nextCoordinate = firstCoordinate;
        do {
            nextCoordinate = direction.getNext(nextCoordinate);
            if (isInLimits(nextCoordinate)) {
                candidate.add(nextCoordinate);
            }
        } while (candidate.size() < 4 && isInLimits(nextCoordinate));
        return candidate;
    }

    private boolean isInLimits(Coordinate coordinate) {
        return coordinate.isInLimits(0, COLUMNS, 0, ROWS);
    }



}
