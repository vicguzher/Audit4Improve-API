/**
 * 
 */
package us.muit.fs.a4i.config;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import us.muit.fs.a4i.model.entities.IndicatorI;
import us.muit.fs.a4i.model.entities.ReportItemI;

/**
 * @author isa
 *
 */
public interface IndicatorConfigurationI {
	public HashMap<String,String> definedIndicator(String name,String type) throws FileNotFoundException;
	
	public List<String> listAllIndicators() throws FileNotFoundException;
	/**
	 * Infiere el estado del indicador a partir del valor del ReportItem y de la configuración de estados en el fichero
	 * @param indicator
	 * @return El estado del indicador
	 */
	public IndicatorI.IndicatorState getIndicatorState(ReportItemI indicator);
}
