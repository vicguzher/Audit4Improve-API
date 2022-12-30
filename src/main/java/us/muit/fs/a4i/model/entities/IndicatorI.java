/**
 * 
 */
package us.muit.fs.a4i.model.entities;

import java.util.Collection;

/**
 * @author Isabel Román
 * Interfaz para manejar los indicadores
 *
 */
public interface IndicatorI {
	/**
	 * <p>Estados posibles del indicador, indican el grado de atención que requiere por parte del analista</p>
	 * @author Isabel Román
	 *
	 */
	public static enum IndicatorState{
    	OK,
    	WARNING,
    	CRITICAL,
    	UNDEFINED
    }
	/**
	 * Devuelve el estado en el que se encuentra este indicador
	 * @return estado del indicador
	 */
	public IndicatorState getState();
	/**
	 * Devuelve el conjunto de métricas en las que se basa este indicador
	 * @return
	 */
	public Collection<ReportItem> getMetrics();

}
