package net.dvazquez.conecta4.views;

public enum Messages {
    GREETING_PLAYERS("Bienvenido al juego de conecta4 para %s jugadores. Empezamos!"),
    PLAYER_COLUMN_TO_ADD_CHIP("Player %s, indica el índice de columna para insertar ficha: "),
    PLAYER_WIN("Jugador %s has ganado!!"),
    RESUME("Desea reiniciar el juego");

    private String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
