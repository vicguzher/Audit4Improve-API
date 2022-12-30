/**
 * 
 */
package us.muit.fs.a4i.model.entities;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;


/**
 * @author Isabel Román
 *
 */
public class Indicator implements IndicatorI{
	private static Logger log=Logger.getLogger(Indicator.class.getName());
    private Collection<ReportItem>metrics;
	private IndicatorState state;

	/**
	 * Constructor
	 */
	public Indicator() {
		this.state=IndicatorState.UNDEFINED;
	}
	
	public Indicator(IndicatorState state,Collection<ReportItem> metrics){		
		this.metrics=metrics;
		this.state=state;
	}
	public void setMetrics(Collection<ReportItem> metrics) {
		this.metrics=metrics;
	}
    public void setState(IndicatorState state) {
    	this.state=state;
    }
	@Override
	public String toString() {
		String info;
		info="Indicador estado "+state+", a partir de metricas: " + metrics;
		return info;
	}

	@Override
	public IndicatorState getState() {
		// TODO Auto-generated method stub
		return state;
	}

	@Override
	public Collection<ReportItem> getMetrics() {
		// TODO Auto-generated method stub
		return metrics;
	}
	
	
}