package us.muit.fs.a4i.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import us.muit.fs.a4i.model.entities.Indicator;
import us.muit.fs.a4i.model.entities.Metric;
import us.muit.fs.a4i.model.entities.Indicator.State;
import us.muit.fs.a4i.model.entities.Report;

public class IndicatorConfiguration implements IndicatorsConfigurationI {
	private static Logger log = Logger.getLogger(IndicatorConfiguration.class.getName());
	private String a4iMetrics = "a4iDefault.json";
	private String appIndicators = null;
	private HashMap<String,Indicator> indicators;
	
	
	private void createMaps() {
		indicators=new HashMap<String,Indicator>();
	}

	@Override
	public HashMap<String, String> definedIndicator(String indicatorName, String indicatorType) {
		log.info("IndicatorConfiguration solicitud de busqueda indicator " + indicatorName);
		
		HashMap<String,String> indicatorDefinition=null;
		
		String filePath="/"+a4iMetrics;
		log.info("Buscando el archivo " + filePath);
		InputStream is=this.getClass().getResourceAsStream(filePath);
		log.info("InputStream "+is+" para "+filePath);
		InputStreamReader isr = new InputStreamReader(is);
		
	
		indicatorDefinition = isDefinedIndicator(indicatorName, indicatorType, isr);
		if ((indicatorDefinition==null) && appIndicators != null) {
			is=new FileInputStream(appIndicators);
			isr=new InputStreamReader(is);			
			indicatorDefinition = isDefinedIndicator(indicatorName, indicatorType, isr);
		}

		return indicatorDefinition;
	}


	@Override
	public void setAppIndicators(String appIndicatorsPath) {
		appIndicators = appIndicatorsPath;

	}

	@Override
	public List<String> listAllIndicators() {
		List<String> indicatorsName = null;
		Indicator indicator = null;
        Iterator<String> it = indicators.keySet().iterator();
 
        while (it.hasNext()) {
            String clave = it.next();
            Indicator valor = indicators.get(clave);
            String name = valor.getName();
            indicatorsName.add(name);
        }
            
		return indicatorsName;
	}

	@Override
	public Indicator.State getIndicatorState(ReportItem indicator) {
		// Suponemos que Indicator tiene el constructor que te devuelve una coleccion de
		// ReportItems

		State estado = indicator.getIndicator().State;
		return estado;
	}
	
	
	private HashMap<String,String> isDefinedIndicator(String IndicatorName, String IndicatorType, InputStreamReader isr)
			throws FileNotFoundException {
		
		HashMap<String,String> indicatorDefinition=null;

	
		JsonReader reader = Json.createReader(isr);
		log.info("Creo el JsonReader");

		JsonObject confObject = reader.readObject();
		log.info("Leo el objeto");
		reader.close();

		log.info("Muestro la configuraci�n le�da " + confObject);
		JsonArray indicators = confObject.getJsonArray("indicators");
		log.info("El n�mero de m�tricas es " + indicators.size());
		for (int i = 0; i < indicators.size(); i++) {
			log.info("nombre: " + indicators.get(i).asJsonObject().getString("name"));
			if (indicators.get(i).asJsonObject().getString("name").equals(IndicatorName)) {
				log.info("Localizada la m�trica");
				log.info("tipo: " + indicators.get(i).asJsonObject().getString("type"));
				if (indicators.get(i).asJsonObject().getString("type").equals(IndicatorType)) {
					indicatorDefinition=new HashMap<String,String>();
					indicatorDefinition.put("description", indicators.get(i).asJsonObject().getString("description"));
					indicatorDefinition.put("unit", indicators.get(i).asJsonObject().getString("unit"));
				}

			}
		}

		return indicatorDefinition;
	}

}
