/**
 * 
 */
package us.muit.fs.a4i.test.config;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import us.muit.fs.a4i.config.Checker;
import us.muit.fs.a4i.config.IndicatorConfiguration;

/**
 * @author jacinto
 *
 */
class IndicatorConfigurationTest {
	
	private static Logger log = Logger.getLogger(CheckerTest.class.getName());
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

	/**
	 * Test method for {@link us.muit.fs.a4i.config.IndicatorConfiguration#setAppIndicators(java.lang.String)}.
	 */
	@Test
	void testSetAppIndicators() {
		
	}

}
