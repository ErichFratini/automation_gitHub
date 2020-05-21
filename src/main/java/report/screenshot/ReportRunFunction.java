package report.screenshot;

import com.google.common.base.Function;

/**
 * 
 * <BR>
 * Projeto: reportpdf.IFunctionReport<BR>
 * @since 5 de jun de 2017 16:02:00
 * @author Ricardo Yamada<BR>
 * @author André Moreira<BR>
 * @param <T>
 */

public class ReportRunFunction {

	public <V, T> V take(Function<? super T, V> isTrue) {
		try {
			return isTrue.apply(null);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}
}