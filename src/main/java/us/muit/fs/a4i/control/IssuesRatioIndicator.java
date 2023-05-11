package us.muit.fs.a4i.control;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import us.muit.fs.a4i.exceptions.NotAvailableMetricException;
import us.muit.fs.a4i.exceptions.ReportItemException;
import us.muit.fs.a4i.model.entities.Indicator;
import us.muit.fs.a4i.model.entities.IndicatorI.IndicatorState;
import us.muit.fs.a4i.model.entities.ReportItem;
import us.muit.fs.a4i.model.entities.ReportItemI;

public class IssuesRatioIndicator implements IndicatorStrategy {

	private static Logger log = Logger.getLogger(Indicator.class.getName());

	// Métricas necesarias para calcular el indicador
	private static final List<String> REQUIRED_METRICS = Arrays.asList("openIssues", "closedIssues");

	@Override
	public <T> ReportItemI<T> calcIndicator(List<ReportItemI<T>> metrics) throws NotAvailableMetricException {
		// Se obtienen y se comprueba que se pasan las métricas necesarias para calcular
		// el indicador.
		var openIssues = metrics.stream().filter(m -> REQUIRED_METRICS.get(0).equals(m.getName())).findAny();
		var closedIssues = metrics.stream().filter(m -> REQUIRED_METRICS.get(1).equals(m.getName())).findAny();
		ReportItemI<Double> indicatorReport = null;

		if (openIssues.isPresent() && closedIssues.isPresent()) {

			// Se realiza el cálculo del indicador
			Double issuesRatio = Double.parseDouble(openIssues.get().getValue().toString())
					/ Double.parseDouble(closedIssues.get().getValue().toString());

			try {
				indicatorReport = new ReportItem.ReportItemBuilder<Double>("issuesRatio", issuesRatio)
						.metrics(Arrays.asList(openIssues.get(), closedIssues.get()))
						.indicator(IndicatorState.UNDEFINED).build();
			} catch (ReportItemException e) {
				log.info("Error en ReportItemBuilder.");
				e.printStackTrace();
			}

		} else {
			log.info("No se han proporcionado las métricas necesarias");
			throw new NotAvailableMetricException("No se han proporcionado las métricas necesarias");
		}

		return (ReportItemI<T>) indicatorReport;
	}

	@Override
	public List<String> requiredMetrics() {
		// Para calcular el indicador "IssuesRatio", serán necesarias las métricas
		// "openIssues" y "closedIssues".
		return REQUIRED_METRICS;
	}
}