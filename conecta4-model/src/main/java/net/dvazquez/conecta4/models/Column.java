package net.dvazquez.conecta4.models;

import net.dvazquez.conecta4.types.Color;

import java.util.ArrayList;
import java.util.List;

public class Column {

    private List<Color> places;

    public Column(int columnSize) {
        this.places = new ArrayList<>();
        for (int j = 0; j < columnSize; j++) {
            this.places.add(Color.NULL);
        }
    }

    public boolean isFull() {
        return this.places.stream().noneMatch(Color::isNull);
    }

    public boolean isEmpty() {
        return this.places.stream().allMatch(Color::isNull);
    }

    public void addChip(Color color) {
        assert !this.isFull();
        int indexToAdd = 0;
        while (!this.places.get(indexToAdd).isNull()) {
            indexToAdd++;
        }
        this.places.set(indexToAdd, color);
    }

    public Color getColor(Integer position) {
        try {
            return this.places.get(position);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int getLastIndexWithColor() {
        if (this.isEmpty()) {
            return 0;
        }
        if (this.isFull()) {
            return this.places.size() - 1;
        }
        int lastIndexWithColor = this.places.size() - 1;
        while (this.places.get(lastIndexWithColor).isNull()) {
            lastIndexWithColor--;
        }
        return lastIndexWithColor;
    }

    public Color getLastColor() {
        return this.places.get(this.getLastIndexWithColor());
    }

    public void reset() {
        for (int i = 0; i < this.places.size(); i++) {
            this.places.set(i, Color.NULL);
        }
    }
}
