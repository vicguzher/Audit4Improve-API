package us.muit.fs.a4i.test.config;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import us.muit.fs.a4i.config.Checker;
import us.muit.fs.a4i.config.IndicatorConfiguration;

class IndicatorConfigurationTest {
	private static Logger log = Logger.getLogger(IndicatorConfigurationTest.class.getName());
	static IndicatorConfiguration underTest;
	static String appConfPath;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//Acciones a realizar antes de ejecutar los tests de esta clase
		appConfPath="src"+File.separator+"test"+File.separator+"resources"+File.separator+"appConfTest.json";
	}

	/**
	 * @throws java.lang.Exception
	 * @see org.junit.jupiter.api.AfterAll
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		//Acciones a realizar despu�s de ejecutar todos los tests de esta clase
	}

	/**
	 * @throws java.lang.Exception
	 * @see org.junit.jupiter.api.BeforeEach
	 */
	@BeforeEach
	void setUp() throws Exception {
		//Acciones a realizar antes de cada uno de los tests de esta clase
		//Creo el objeto bajo test, un Checker
		underTest = new IndicatorConfiguration();
	}

	/**
	 * @throws java.lang.Exception
	 * @see org.junit.jupiter.api.AfterEach
	 */
	@AfterEach
	void tearDown() throws Exception {
		//Acciones a realizar despu�s de cada uno de los tests de esta clase
	}

	@Test
	void testDefinedIndicator() {
		//Creo valores Mock para verificar si comprueba bien el tipo
		//Las m�tricas del test son de enteros, as� que creo un entero y un string (el primero no dar� problemas el segundo s�)
		Double valOKMock = Double.valueOf(0.3);
		String valKOMock = "KO";
		HashMap<String,String> returnedMap=null;
		//Primero, sin fichero de configuraci�n de aplicaci�n
		try {
			//Consulta un indicador no definido, con valor de tipo entero
			//debe devolver null, no est� definido
			log.info("Busco el indicador llamado pullReqGlory");
			returnedMap=underTest.definedIndicator("pullReqGlory", valOKMock.getClass().getName());
			assertNull(returnedMap, "Deber�a ser nulo, el indicador pullReqGlory no est� definido");
			
			//Busco el indicador overdued con valor double, no deber�a dar problemas
			log.info("Busco el indicador overdued");
			returnedMap=underTest.definedIndicator("overdued", valOKMock.getClass().getName());
			assertNotNull(returnedMap,"Deber�a devolver un hashmap, el indicador overdued est� definido");
			assertTrue(returnedMap.containsKey("unit"),"La clave unit tiene que estar en el mapa");
			assertTrue(returnedMap.containsKey("description"),"La clave description tiene que estar en el mapa");
		       
			//Busco una m�trica que existe pero con un tipo incorrecto en el valor
			assertNull(underTest.definedIndicator("overdued", valKOMock.getClass().getName()),
					"Deber�a ser nulo, el indicador overdued est� definido para Double");
		} catch (FileNotFoundException e) {
			fail("El fichero est� en la carpeta resources");
			e.printStackTrace();
		}
		//Ahora establezco el fichero de configuraci�n de la aplicaci�n, con un nombre de fichero que no existe
		underTest.setAppIndicators("pepe");
		try {
			//Busco un indicador que se que no est� en la configuraci�n de la api
			returnedMap=underTest.definedIndicator("pullReqGlory", valOKMock.getClass().getName());
			fail("Deber�a lanzar una excepci�n porque intenta buscar en un fichero que no existe");
		} catch (FileNotFoundException e) {
			log.info("Lanza la excepci�n adecuada, FileNotFoud");
		} catch (Exception e) {
			fail("Lanza la excepci�n equivocada " + e);
		}
				
		//Ahora establezco un fichero de configuraci�n de la aplicaci�n que s� existe
		underTest.setAppIndicators(appConfPath);
		try {
			//Busco una m�trica que se que no est� en la configuraci�n de la api pero s� en la de la aplicaci�n
			log.info("Busco el indicador llamado pullReqGlory");
			returnedMap=underTest.definedIndicator("pullReqGlory", valOKMock.getClass().getName());
			assertNotNull(returnedMap,"Deber�a devolver un hashmap, el indicador est� definido");
			assertTrue(returnedMap.containsKey("unit"),"La clave unit tiene que estar en el mapa");
			assertTrue(returnedMap.containsKey("description"),"La clave description tiene que estar en el mapa");
		} catch (FileNotFoundException e) {
			fail("No deber�a devolver esta excepci�n");
		} catch (Exception e) {
			fail("Lanza una excepci�n no reconocida " + e);
		}
	}

	@Test
	void testSetAppIndicators() {
		fail("Not yet implemented");
	}

	@Test
	void testListAllIndicators() {
		fail("Not yet implemented");
	}

	@Test
	void testGetIndicatorState() {
		fail("Not yet implemented");
	}

}
