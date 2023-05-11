/**
 * 
 */
package us.muit.fs.a4i.control;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import us.muit.fs.a4i.exceptions.IndicatorException;
import us.muit.fs.a4i.exceptions.NotAvailableMetricException;
import us.muit.fs.a4i.model.entities.Indicator;
import us.muit.fs.a4i.model.entities.ReportI;
import us.muit.fs.a4i.model.entities.ReportItemI;
import java.util.stream.Collectors;

/**
 * <p>
 * Implementa los métodos para calcular indicadores referidos a un repositorio
 * repositorio
 * </p>
 * <p>
 * Puede hacerse uno a uno o todos a la vez
 * </p>
 * 
 * @author Isabel Román
 *
 */
public class RepositoryCalculator implements IndicatorsCalculator {
	private static Logger log = Logger.getLogger(RepositoryCalculator.class.getName());
	private static ReportI.ReportType reportType = ReportI.ReportType.REPOSITORY;
	private static HashMap<String, IndicatorStrategy> strategies = new HashMap<>();

	@Override
	public void calcIndicator(String indicatorName, ReportManagerI reportManager) throws IndicatorException {
		log.info("Calcula el indicador de nombre " + indicatorName);
		/**
		 * Tiene que mirar si están ya las métricas que necesita Si están lo calcula
		 * Si no están busca las métricas, las añade al informe y lo calcula
		 * 
		 */
		IndicatorStrategy indicatorStrategy = strategies.get(indicatorName);
		List<String> requiredMetrics = indicatorStrategy.requiredMetrics();
		log.info("Las m�tricas necesarias son: " + requiredMetrics.toString());
		List<ReportItemI> metrics = reportManager.getReport().getAllMetrics().stream().collect(Collectors.toList());
		List<String> metricsName = metrics.stream().map(ReportItemI::getName).collect(Collectors.toList());
		if (metricsName.containsAll(requiredMetrics)) {
			try {
				indicatorStrategy.calcIndicator(metrics);
			} catch (NotAvailableMetricException e) {
				log.info("No se han proporcionado las m�tricas necesarias");
				e.printStackTrace();
			}
		} else {
			log.info("No se han proporcionado las metricas necesarias");
		}
	}

	/**
	 * Calcula todos los indicadores definidos para un repositorio Recupera todas
	 * las métricas que necesite y que no estén en el informe y las añade al
	 * mismo
	 * 
	 */
	@Override
	public void calcAllIndicators(ReportManagerI reportManager) throws IndicatorException {
		log.info("Calcula todos los indicadores del repositorio y los incluye en el informe");
	}

	private Indicator commitsPerUser(ReportI report) {
		Indicator indicator = null;

		return indicator;
	}

	@Override
	public ReportI.ReportType getReportType() {
		return reportType;
	}

	@Override
	public void setIndicator(String indicatorName, IndicatorStrategy strategy) {
		strategies.put(indicatorName, strategy);

	}

}