package domain;

/**
 * The test class Conecta4Exception.
 *
 * @author Santiago Parra / Juan Vizcaino
 * @version v1.0
 */
public class Conecta4Exception extends Exception {

    public static String NO_PUEDES_EN_MISMA_POSICION = "No puede colocar la ficha en una posicion ocupada";
    public static String NO_PUEDE_TENER_MISMOS_COLORES = "ya existe un jugador con los mismos colores";
    public static String GANADOR = "Ganador : ";
    public static String NO_SE_PUEDE_COLOCAR_AQUI = "No es posible colocar la ficha en este espacio";
    public static String NO_PUEDE_CAMBIAR_DE_COLOR = "No es posible cambiar de color, solo puedes antes del primer turno";

    public Conecta4Exception(String message) {
        super(message);
    }
}
