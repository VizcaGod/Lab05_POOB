package domain;

/**
 * The test class Conecta4Exception.
 *
 * @author Santiago Parra / Juan Vizcaino
 * @version v1.0
 */
public class Conecta4Exception extends Exception {

    /**
     * The constant NO_PUEDES_EN_MISMA_POSICION.
     */
    public static String NO_PUEDES_EN_MISMA_POSICION = "No puede colocar la ficha en una posicion ocupada";
    /**
     * The constant NO_PUEDE_TENER_MISMOS_COLORES.
     */
    public static String NO_PUEDE_TENER_MISMOS_COLORES = "ya existe un jugador con los mismos colores";
    /**
     * The constant GANADOR.
     */
    public static String GANADOR = "Ganador : ";
    /**
     * The constant NO_SE_PUEDE_COLOCAR_AQUI.
     */
    public static String NO_SE_PUEDE_COLOCAR_AQUI = "No es posible colocar la ficha en este espacio";
    /**
     * The constant NO_PUEDE_CAMBIAR_DE_COLOR.
     */
    public static String NO_PUEDE_CAMBIAR_DE_COLOR = "No es posible cambiar de color, solo puedes antes del primer turno";

    /**
     * Instantiates a new Conecta 4 exception.
     *
     * @param message the message
     */
    public Conecta4Exception(String message) {
        super(message);
    }
}
