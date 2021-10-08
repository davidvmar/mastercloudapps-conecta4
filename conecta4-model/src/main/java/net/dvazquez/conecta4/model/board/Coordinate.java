package net.dvazquez.conecta4.model.board;

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
}
