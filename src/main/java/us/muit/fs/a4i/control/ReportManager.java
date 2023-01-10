/**
 * 
 */
package us.muit.fs.a4i.control;

import java.util.logging.Logger;

import us.muit.fs.a4i.exceptions.ReportNotDefinedException;
import us.muit.fs.a4i.model.entities.ReportI;
import us.muit.fs.a4i.model.entities.ReportItemI;
import us.muit.fs.a4i.model.remote.RemoteEnquirer;
import us.muit.fs.a4i.persistence.PersistenceManager;
import us.muit.fs.a4i.persistence.ReportFormaterI;

/**
 * @author isa
 *
 */
public class ReportManager implements ReportManagerI {


	private static Logger log=Logger.getLogger(ReportManager.class.getName());
	private ReportI report;
	private PersistenceManager persister;
	private RemoteEnquirer enquirer;
	private ReportFormaterI formater;
	private IndicatorsCalculator calc;
	private String entityId;

	
	public ReportManager(PersistenceManager persister, RemoteEnquirer enquirer, IndicatorsCalculator calc) {
		this.persister = persister;
		this.enquirer = enquirer;
		this.calc = calc;
	}
	/**
	 * <p>Borra el informe pasado como parámetro, según las reglas establecidas por el gestor de persistencia</p>
	 * @param report El informe que se quiere borrar
	 */
	public static void deleteReport(ReportI report) {
		
	}

	/**
	 * <p>Establece el objeto que se usará para consultar al servidor remoto y obtener las métricas</p>
	 * @param remote Objeto RemoteEnquirer que consultará al servidor remoto
	 */
	public void setRemoteEnquirer(RemoteEnquirer remote) {
		this.enquirer=remote;

	}


	public void setPersistenceManager(PersistenceManager persistence) {
		this.persister=persistence;

	}

	@Override
	public void setFormater(ReportFormaterI formater) {
		this.formater=formater;

	}


	public void setIndicatorCalc(IndicatorsCalculator calc) {
		this.calc=calc;

	}
	/**
	 * <p>Persiste el informe que recibe como parámetro, según las reglas del gestor de persistencia y formateador establecidos</p>
	 * @param report <p>El informe a persistir</p>
	 */
	public void saveReport(ReportI report) {
		
		persister.setFormater(formater);
		try {
			persister.saveReport(report);
		} catch (ReportNotDefinedException e) {
			log.info("El informe que se quiere guardar no está definido");
			e.printStackTrace();
		}
	}

	@Override
	public void saveReport() throws ReportNotDefinedException {
		if(report!=null) {
			saveReport(report);
		}else throw new ReportNotDefinedException();
		
	}
   
	@Override
	public ReportI newReport(String entityId) {
		report=enquirer.buildReport(entityId);
		return report;
	}

	@Override
	public void deleteReport() {
		// TODO Auto-generated method stub

	}

	/**
	 * Devuelve el informe que está manejando este gestor
	 */
	@Override
	public ReportI getReport() {
		return report;
	}

	@Override
	public void addMetric(String metricName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ReportItemI getMetric(String metricName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addIndicator(String indicatorName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getIndicator(String indicatorName) {
		// TODO Auto-generated method stub
		
	}	

}
