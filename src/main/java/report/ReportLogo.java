package report;

import report.exception.ReportException;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;

import java.io.IOException;
/**
 *
 * <BR>
 * Projeto: reportpdf.IFunctionReport<BR>
 * @since 5 de jun de 2017 16:02:00
 * @author Ricardo Yamada<BR>
 * @author André Moreira<BR>
 * @param <T>
 */
public class ReportLogo {
	private Image image;

	public ReportLogo(String path, Float posX, Float posY) {
		setImage(path, posX, posY, null, null);
	}

	public ReportLogo(String path, Float posX, Float posY, Float sizeX, Float sizeY) {
		setImage(path, posX, posY, sizeX, sizeY);
	}

	private void setImage(String path, Float posX, Float posY, Float sizeX, Float sizeY) {
			Image img;
			try {
				img = Image.getInstance(String.format((path)));
			} catch (BadElementException | IOException e) {
				throw new ReportException(e);
			}

			if (sizeX != null && sizeY != null)
				img.scaleToFit(sizeX, sizeY);

			img.setAbsolutePosition(posX, posY);
			setImage(img);

	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
