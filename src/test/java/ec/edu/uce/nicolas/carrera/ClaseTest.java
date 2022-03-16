package ec.edu.uce.nicolas.carrera;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClaseTest {

	@Test
	public void testCombinarColores() {
		ClaseColor rojo = new ClaseColor(255, 0, 0);
		ClaseColor verde = new ClaseColor(0, 255, 0);
		
		ClaseColor resultado = new ClaseColor(255, 255, 0);
		
		assertTrue(rojo.combinarColores(verde).equals(resultado));
	}
	
}
