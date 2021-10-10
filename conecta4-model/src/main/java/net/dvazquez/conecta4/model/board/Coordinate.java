package net.dvazquez.conecta4.model.board;

import java.util.Objects;

public class Coordinate {

    private Integer x;
    private Integer y;

    public Coordinate(Integer x) {
        this.x = x;
        this.y = 0;
    }

    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate clone(){
        return new Coordinate(this.x, this.y);
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getX() {
        return this.x;
    }
    public Integer getY() {
        return this.y;
    }

    public boolean isInLimits(int minX, int maxX, int minY, int maxY) {
        return this.x >= minX && this.x <= maxX && this.y >= minY && this.y <= maxY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
