/**
 * 
 */
package us.muit.fs.a4i.test.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.HashMap;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import us.muit.fs.a4i.config.Checker;
import us.muit.fs.a4i.config.Context;

/**
 * @author isa
 *
 */
class MetricInfo {

	/**
	 * Test method for {@link us.muit.fs.a4i.config.Context#getChecker()}.
	 */
	@Test
	@Tag("Integracion")
	void testGetChecker() {
		try {
			Checker checker = Context.getContext().getChecker();
			HashMap<String, String> metricInfo = checker.getMetricConfiguration().getMetricInfo("issues");
			assertEquals(metricInfo.get("name"), "issues", "No se ha le�do bien el nombre de la m�trica");
			assertEquals(metricInfo.get("type"), "java.lang.Integer", "No se ha le�do bien el tipo de la m�trica");
			assertEquals(metricInfo.get("description"), "Tareas sin finalizar en el repositorio",
					"No se ha le�do bien la descripci�n de la m�trica");
			assertEquals(metricInfo.get("unit"), "issues", "No se ha le�do bien las unidades de la m�trica");
		} catch (IOException e) {

			e.printStackTrace();
			fail("No deber�a devolver esta excepci�n");
		}

	}

}
