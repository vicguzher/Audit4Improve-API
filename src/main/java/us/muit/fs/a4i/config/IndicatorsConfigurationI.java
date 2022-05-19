package us.muit.fs.a4i.config;

import java.util.HashMap;
import java.util.List;

import us.muit.fs.a4i.model.entities.Indicator;
import us.muit.fs.a4i.model.entities.Report;

public interface IndicatorsConfigurationI {
	
	public HashMap<String,String> definedIndicator(String indicatorName, String indicatorType);
	
	public void setAppIndicators(String appIndicatorsPath);
	
	public List<String> listAllIndicators();
	
	public Indicator.State getIndicatorState(ReportItem indicator);

}
