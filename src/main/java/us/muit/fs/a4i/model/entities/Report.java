/**
 * 
 */
package us.muit.fs.a4i.model.entities;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import us.muit.fs.a4i.control.IndicatorsCalculator;
import us.muit.fs.a4i.exceptions.IndicatorException;

/**
 * <p>Aspectos generales de todos los informes</p>
 * <p>Todos incluyen un conjunto de métricas de tipo numérico y otro de tipo Date</p>
 * @author Isabel Romï¿½n
 *
 */

public class Report implements ReportI {
	private static Logger log=Logger.getLogger(Report.class.getName());
	/**
	 * <p>Identificador unï¿½voco de la entidad a la que se refire el informe en el servidor remoto que se va a utilizar</p>
	 */
	private String entityId;
	/**
	 * <p>Los objetos que implementen esta interfaz recurren a calcuadoras con los algoritmos para el cï¿½lculo de indicadores<p>
	 * <p>Los algoritmos de cï¿½lculo de indicadores serï¿½n especï¿½ficos para un tipo de informe<p>
	 */
	private IndicatorsCalculator calc;
	
	
	
	
	private ReportI.ReportType type=null;
	/**
	 * Mapa de Mï¿½tricas
	 * 
	 * */
	 
	private HashMap<String,ReportItem> metrics;
	
	/**
	 * Mapa de indicadores
	 */
		
	private HashMap<String,ReportItem> indicators;
	
	public Report(){
		createMaps();
		
	}
	public Report(String entityId){
		createMaps();
		this.entityId=entityId;		
	}
	public Report(ReportType type){
		createMaps();
		this.type=type;		
	}
	public Report(ReportType type,String entityId){
		createMaps();
		this.type=type;	
		this.entityId=entityId;		
	}	
	private void createMaps() {
		metrics=new HashMap<String,ReportItem>();
		indicators=new HashMap<String,ReportItem>();
	}
	/**
	 * <p>Busca la mï¿½trica solicita en el informe y la devuelve</p>
	 * <p>Si no existe devuelve null</p>
	 * @param name Nombre de la mï¿½trica buscada
	 * @return la mï¿½trica localizada
	 */
	public ReportItem getMetricByName(String name) {
		log.info("solicitada métrica de nombre "+name);
		ReportItem metric=null;
		
		if (metrics.containsKey(name)){
			log.info("La mï¿½trica estï¿½ en el informe");
			metric=metrics.get(name);
		}
		return metric;
	}
	/**
	 * <p>Aï¿½ade una mï¿½trica al informe</p>
	 */

	@Override
	public void addMetric(ReportItem met) {		
		metrics.put(met.getName(), met);
		log.info("Aï¿½adida mï¿½trica "+met+" Con nombre "+met.getName());
	}
	/**
	 * <p>Busca el indicador solicitado en el informe y lo devuelve</p>
	 * <p>Si no existe devuelve null</p>
	 * @param name Nombre del indicador buscado
	 * @return el indicador localizado
	 */
	@Override
	public ReportItem getIndicatorByName(String name) {
		log.info("solicitado indicador de nombre "+name);
		ReportItem indicator=null;
		
		if (indicators.containsKey(name)){
			indicator=indicators.get(name);
		}
		return indicator;
	}
/**
 * <p>Aï¿½ade un indicador al informe</p>	
 * 
 */ 
	@Override
	public void addIndicator(ReportItem ind) {
		
		indicators.put(ind.getName(), ind);
		log.info("Aï¿½adido indicador "+ind);

	}
	/**
	 * <p>Calcula el indicador solicitado y lo incluye en el informe, si se necesita alguna mï¿½trica que no exista la calculadora la busca y la incluye</p>
	 */
    @Override
	public String getEntityId() {
    	return entityId;
    }
	@Override
	public String toString() {
		String repoinfo;
		repoinfo="Informaciï¿½n del Informe:\n - Mï¿½tricas: ";
		for (String clave:metrics.keySet()) {
		     repoinfo+="\n Clave: " + clave + metrics.get(clave);
		}
		repoinfo+="\n - Indicadores: ";
		for (String clave:indicators.keySet()) {
		     repoinfo+="\n Clave: " + clave + indicators.get(clave);
		}
		return repoinfo;
	}
	@Override
	public Collection<ReportItem> getAllMetrics() {
		// TODO Auto-generated method stub
		return metrics.values();
	}
	
	@Override
	public Collection<ReportItem> getAllIndicators() {
		// TODO Auto-generated method stub
		return indicators.values();
	}
	@Override
	public ReportType getType() {
		return type;
	}
}
