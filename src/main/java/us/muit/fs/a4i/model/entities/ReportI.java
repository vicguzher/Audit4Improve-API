package us.muit.fs.a4i.model.entities;

import java.util.Collection;
import java.util.List;

import us.muit.fs.a4i.control.IndicatorsCalculator;
import us.muit.fs.a4i.exceptions.IndicatorException;

public interface ReportI {
	/**
	 * <p>Tipos de informes, puede necesitarse cuando los algoritmos de cï¿½lculo de indicadores difieran segï¿½n el tipo de informe</p>
	 * <p>Un informe sï¿½lo es de un tipo y no se puede modificar una vez establecido</p>
	 * 
	 */

	public static enum ReportType{
    	REPOSITORY,
    	DEVELOPER,
    	PROJECT,
    	ORGANIZATION
    }
	/**
	 * Consulta el tipo del informe
	 * @return tipo del informe
	 */
	ReportI.ReportType getType();
	/**
     * Obtiene el identificador de la entidad a la que se refiere el informe
     * @return Identificador unívoco de la entidad a la que se refiere el informe en el remoto
     */
	String getEntityId();
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
	 * Obtiene todos los indicadores del informe
	 * @return el conjunto de indicadores del informe
	 */
	Collection<ReportItem> getAllIndicators();

	/**
	 * Añade un indicador al informe
	 * @param Nuevo indicador
	 */


	void addIndicator(ReportItem ind);

	/**
	 * Calcula un indicador a partir de su nombre y lo aï¿½ade al informe
	 * Si se basa en mï¿½tricas que no estï¿½n aï¿½n incluidas en el informe las incluye
	 * @param name Nombre del indicador que se quiere calcular
	 */

	




}