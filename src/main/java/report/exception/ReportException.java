package report.exception;


/**
 *
 * <BR>
 * Projeto: reportpdf.IFunctionReport<BR>
 * @since 5 de jun de 2017 16:02:00
 * @author Ricardo Yamada<BR>
 * @author André Moreira<BR>
 * @param <T>
 */
public class ReportException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor
	 * @param msg
	 */
	public ReportException(String msg) {
		super(msg);
	}
	
	/**
	 * Construtor
	 * @param e
	 */
	public ReportException(Exception e) {
		super(e);
	}
	
	/**
	 * Construtor
	 * @param msg
	 * @param e
	 */
	public ReportException(String msg, Exception e) {
		super(msg, e);
	}

}
