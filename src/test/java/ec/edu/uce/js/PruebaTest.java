package ec.edu.uce.js;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.edu.uce.impl.js.Binarios;
import ec.edu.uce.impl.js.Palabra;
import ec.edu.uce.modelo.js.Contexto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class PruebaTest {

	private static final Logger LOG = LoggerFactory.getLogger(PruebaTest.class);


	@Test
	public void resultadosBinarios() {
		// Entrada

		Binarios binarios;
		Contexto contexto;

		String numero = "20";

		// Cuando
		contexto = new Contexto(numero);
		binarios = new Binarios(numero);
		String resultado = binarios.interprete(contexto);
		// Entonces
		assertEquals("10100", resultado);
	}

	@Test
	public void resultadoPalabra() {
		Palabra palabra;
		Contexto contexto;
		String numero = "2";

		// Cuando
		contexto = new Contexto(numero);
		palabra = new Palabra(numero);
		String resultado = palabra.interprete(contexto);

		// Entonces
		assertEquals("tres", resultado);
	}

}
