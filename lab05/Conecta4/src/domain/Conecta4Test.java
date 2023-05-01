package domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * The test class Conecta4Test.
 *
 * @author Santiago Parra / Juan Vizcaino
 * @version v1.0
 */
public class Conecta4Test {
    private Tablero prueba;
    /**
     * The Pruebaf.
     */
    Conecta4 pruebaf;

    /**
     * Constructor para la clase de testeo conecta4
     */
    public Conecta4Test() {
        pruebaf = new Conecta4();
        prueba = new Tablero();
        try {
            prueba.addJugador("Parralol", Color.BLACK, 0);
            prueba.addJugador("Vizcagod", Color.BLUE, 1);
            pruebaf.addJugador("Parralol", Color.BLACK, 0);
            pruebaf.addJugador("Vizcagod", Color.BLUE, 1);

        } catch (Conecta4Exception e) {

        }
    }

    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * verifica si pasan los turnos
     */
    @Test
    public void shouldPassTurn() {
        String res1 = prueba.getInTurnPlayerName();
        prueba.changeTurn();
        String res2 = prueba.getInTurnPlayerName();
        if (res1 == "Parralol" && res2 == "Vizcagod") {
            assertTrue(res1 + "-" + res2, true);
        } else {
            assertFalse("No funciona", true);
        }
    }

    /**
     * verifica si juega
     */
    @Test
    public void shouldPlay() {
        try {
            pruebaf.play(0, 7);
        } catch (Conecta4Exception e) {
            assertFalse(e.getMessage(), true);
        }
    }

    /**
     * Tears down the test fixture.
     * <p>
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }
}
