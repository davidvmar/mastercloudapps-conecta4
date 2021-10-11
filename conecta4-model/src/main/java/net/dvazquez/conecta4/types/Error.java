package net.dvazquez.conecta4.types;

public enum Error {

    COLUMN_OUT_OF_RANGE,
    COLUMN_IS_FULL,
    NULL;

    public boolean isNull() {
        return this == Error.NULL;
    }
}
