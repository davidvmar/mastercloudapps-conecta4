package net.dvazquez.conecta4.types;

public enum Color {
    BLUE(" O "),
    RED(" X "),
    NULL(" · ");

    private String symbol;

    Color(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public boolean isNull() {
        return this == Color.NULL;
    }
}
