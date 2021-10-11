package net.dvazquez.conecta4.views;

import net.dvazquez.conecta4.types.Error;

import java.util.HashMap;

public abstract class ErrorView {

    public static final HashMap<Error, String> MESSAGES = new HashMap<Error, String> () {{
        put(Error.COLUMN_OUT_OF_RANGE, "Column out of range");
        put(Error.COLUMN_IS_FULL, "Column is full");
    }};

    public abstract void writeln(Error error);

}
