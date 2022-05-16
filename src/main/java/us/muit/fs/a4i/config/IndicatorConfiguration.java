package us.muit.fs.a4i.config;

import java.util.HashMap;
import java.util.List;

import us.muit.fs.a4i.model.entities.Indicator.State;
import us.muit.fs.a4i.model.entities.Report;

public class IndicatorConfiguration implements IndicatorsConfiguration {

	@Override
	public HashMap<String, String> definedMetric(String metricName, String metricType) {
		// TODO Auto-generated method stub
		return null;
	}

	private String appIndicators = null;
	@Override
	public void setAppIndicators(String appIndicatorsPath) {
		appIndicators = appIndicatorsPath;

	}

	@Override
	public List<String> listAllIndicators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State getIndicatorState(Report indicator) {
		// TODO Auto-generated method stub
		return null;
	}

}
