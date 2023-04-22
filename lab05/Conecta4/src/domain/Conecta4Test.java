package domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.junit.*;

/**
 * The test class Conecta4Test.
 *
 * @author Santiago Parra / Juan Vizcaino
 * @version v1.0
 */
public class Conecta4Test {
    private Tablero prueba;

    /**
     * Constructor para la clase de testeo conecta4
     */
    public Conecta4Test() {
        prueba = new Tablero();
        try {
            prueba.addJugador("Parralol", Color.BLACK, 0);
            prueba.addJugador("Vizcagod", Color.BLUE, 1);
        } catch (Conecta4Exception e) {

        }
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

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

    @Test
    public void shouldPlay() {

    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }
}
