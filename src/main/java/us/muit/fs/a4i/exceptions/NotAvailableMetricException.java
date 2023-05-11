package us.muit.fs.a4i.exceptions;

public class NotAvailableMetricException extends Exception{
	
	/**
	 * Excepcion que ocurre cuando se quiere calcular un indicador pero no se proporcionan las métricas adecuadas.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Informacion sobre el error
	 */
	private String message;

	/**
	 * <p>
	 * Constructor
	 * </p>
	 * 
	 * @param info Mensaje definiendo el error
	 */
	public NotAvailableMetricException(String info) {
		message = info;
	}

	@Override
	public String getMessage() {
		return message;
	}
}