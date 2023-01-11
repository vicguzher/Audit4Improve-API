package us.muit.fs.a4i.config;

import java.util.logging.Logger;

/**
 * Mantengo separada la lógica de la gestión de configuración de métricas e
 * indicadores porque en el futuro van a ser bastante diferentes En la versión
 * actual son muy similares y por tanto el diseño no es bueno ya que no
 * identifica bien la reutilización
 * 
 * @author Isabel Román
 *
 */
public class Checker {
	private static Logger log = Logger.getLogger(Checker.class.getName());

	private MetricConfigurationI metricConf;
	private IndicatorConfigurationI indiConf;

	Checker() {
		this.metricConf = new MetricConfiguration();
		this.indiConf = new IndicatorConfiguration();
	}

	public MetricConfigurationI getMetricConfiguration() {
		return this.metricConf;
	}

	public IndicatorConfigurationI getIndicatorConfiguration() {
		return this.indiConf;
	}
}
