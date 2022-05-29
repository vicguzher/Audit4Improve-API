/**
 * <p>Algoritmos para el c�lculo de indicadores espec�ficos al tipo de informe</p>
 */
package us.muit.fs.a4i.control;

import us.muit.fs.a4i.exceptions.IndicatorException;
import us.muit.fs.a4i.model.entities.ReportI;

/**
 * 
 * <p>Define los m�todos para calcular cada indicador y a�adirlo al informe</p>
 * <p>Puede hacerse uno a uno o todos a la vez</p>
 * <p>Las clases que la implementen ser�n espec�fias para un tipo de informe</p>
 * @author Isabel Rom�n
 *
 */
public interface IndicatorsCalculator {
	/**
	 * <p>Calcula el indicador con el nombre que se pasa y lo incluye en el informe
	 * Si las m�tricas que necesita no est�n en el informe las busca y las a�ade</p>
	 * @param name Nombre del indicador a c�lcular
	 * @param report Informe sobre el que realizar el c�lculo
	 * @throws IndicatorException Si el indicador no est� definido en la calculadora
	 */
	
	public void calcIndicator(String name,ReportI report) throws IndicatorException;
	/**
	 * <p>Calcula todos los indicadores configurados para el tipo de informe que se pasa. Debe verificar primero que el tipo de informe que se pasa es correcto</p>
	 * @param report Informe sobre el que realizar el c�lculo
	 * @throws IndicatorException Si el tipo del informe no coincide con el de la calculadora
	 */
	public void calcAllIndicators(ReportI report) throws IndicatorException;
	
	/**
	 * Devuelve el tipo de informe que maneja esta calculadora de indicadores
	 * @return El tipo de informes
	 */
	public ReportI.Type getReportType();
}