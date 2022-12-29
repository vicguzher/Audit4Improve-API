package us.muit.fs.a4i.model.entities;

import java.util.Collection;
import java.util.List;

import us.muit.fs.a4i.control.IndicatorsCalculator;
import us.muit.fs.a4i.exceptions.IndicatorException;

public interface ReportI {
	/**
	 * <p>Tipos de informes, puede necesitarse cuando los algoritmos de cálculo de indicadores difieran según el tipo de informe</p>
	 * <p>Un informe sólo es de un tipo y no se puede modificar una vez establecido</p>
	 * 
	 */

	public static enum Type{
    	REPOSITORY,
    	DEVELOPER,
    	PROJECT,
    	ORGANIZATION
    }
	
	/**
	 * Consulta una métrica de un informe a partir del nombre
	 * @param name Nombre de la métrica solicitada
	 * @return Métrica solicitada
	 */
	ReportItem getMetricByName(String name);
	/**
	 * Obtiene todas las métricas del informe
	 * @return Colleción de métricas que contiene el informe
	 */
	Collection<ReportItem> getAllMetrics();
    /**
     * Añade una métrica al informe
     * @param met Nueva métrica
     */
	void addMetric(ReportItem met);
	/**
	 * Obtiene un indicador del informe a partir del nombre del mismo
	 * @param name Nombre del indicador consultado
	 * @return El indicador
	 */

	ReportItem getIndicatorByName(String name);
	/**
	 * Añade un indicador al informe
	 * @param ind Nuevo indicador
	 */

	void addIndicator(ReportItem ind);
	/**
	 * Calcula un indicador a partir de su nombre y lo añade al informe
	 * Si se basa en métricas que no están aún incluidas en el informe las incluye
	 * @param name Nombre del indicador que se quiere calcular
	 */

	void calcIndicator(String name);

	/**
	 * Establede el identificador unívoco de la entidad a la que se refiere el informe, debe ser el identificador usado en el remoto
	 * @param id Identificador unívoco de la entidad a la que se refiere el informe en el remoto
	 */
	void setId(String id);
	
    /**
     * Obtiene el identificador de la entidad a la que se refiere el informe
     * @return Identificador unívoco de la entidad a la que se refiere el informe en el remoto
     */
	String getId();
	/**
	 * Establece la calculadora de indicadores, debe ser específica para el tipo de informe
	 * @param calc calculadora a utilizar para el cálculo de indicadores
	 * @throws IndicatorException Si el tipo de la calculadora no coincide con el tipo de informe
	 */
	void setIndicatorsCalculator(IndicatorsCalculator calc) throws IndicatorException;
	/**
	 * Calcula todos los indicadores especificados por defecto para el tipo de informe y los incluye en el informe
	 * También incluye las métricas utiizadas
	 */
	void calcAllIndicators();
	/**
	 * Establece el tipo del informe, sólo se puede establecer una vez y debe coincidir con la el tipo de la calculadora usada
	 * @param type Tipo del informe 
	 */
	void setType(ReportI.Type type);
	/**
	 * Obtiene el tipo del informe
	 * @return Tipo del informe
	 */
	ReportI.Type getType();

}