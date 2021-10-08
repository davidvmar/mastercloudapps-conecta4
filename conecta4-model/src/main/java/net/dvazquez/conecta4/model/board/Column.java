package net.dvazquez.conecta4.model.board;

import net.dvazquez.conecta4.model.game.Chip;

import java.util.ArrayList;
import java.util.List;

public class Column {

    private List<Place> places;

    public Column(Coordinate baseColumnCoordinate, int columnSize) {
        this.places = new ArrayList<>();
        for (int j = 0; j < columnSize; j++) {
            Coordinate coordinate = baseColumnCoordinate.clone();
            coordinate.setY(j);
            places.add(new Place(coordinate));
        }
    }

    public List<Place> getPlaces() {
        return this.places;
    }

    public boolean isFull() {
        return this.places.stream().noneMatch(Place::isEmpty);
    }

    public void addChip(Chip chip) {
        Place placeToAdd = places.stream().filter(Place::isEmpty).findFirst().orElse(null);
        assert placeToAdd != null;
        placeToAdd.setChip(chip);
    }
}
