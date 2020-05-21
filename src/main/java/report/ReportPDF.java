package report;

import org.apache.commons.io.FileUtils;
import report.exception.ReportException;
import report.interfaces.Report;
import com.itextpdf.text.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import static report.ReportManager.formatDate;
import static scenario.ScenarioManager.getScenario;

/**
 * <BR>
 * Projeto: reportpdf.IFunctionReport<BR>
 *
 * @author Ricardo Yamada<BR>
 * @author André Moreira<BR>
 * @since 5 de jun de 2017 16:02:00
 */
public class ReportPDF implements Report {

    private final float MARGIN = 30;
    public static final Logger logger = LogManager.getLogger();
    private Document document = new Document();
    //	private String path = Paths.get("").toAbsolutePath().toString() + File.separator +
//			"Evidences"+File.separator + getScenario().getName() + ".pdf";
    private String path = Paths.get("").toAbsolutePath().toString() + File.separator +
            "src/main/resources/" + getScenario().getName() + ".pdf";
    private ReportCapa capa = new ReportCapa(document, MARGIN, path);
    private ContentPDF contentPDF = new ContentPDF(document, MARGIN);
    Paragraph y = new Paragraph(265, "\n");

    @Override
    public void setCover(String titulo, String objetivo) {

        capa.setCapa(titulo, objetivo);
        try {
            document.add(y);
        } catch (DocumentException e) {
            throw new ReportException(e);
        }
    }

    @Override
    public void addStep(String description, byte[] imagem) {
        contentPDF.addStep(description, imagem);
    }

    public void addStep(String description, WebDriver driver) {
        contentPDF.addStep(description, takeScreenShot(driver));
    }

    @Override
    public void addStep(String description, String fontName, float size, int style, BaseColor color, byte[] imagem) {
        contentPDF.addStep(description, fontName, size, style, color, imagem);
    }

    @Override
    public void addStep(byte[] imagem) {
        contentPDF.addStep(imagem);
    }

    /*
     * @Override
     *
     * @Deprecated public void addMainframeStep(String description) {
     * contentPDF.addMainframeStep(description);
     *
     * }
     *
     * @Override public void addMainframeStep(String description, PdfPTable[]
     * screenshot) { contentPDF.addMainframeStep(description, screenshot);
     *
     * }
     *
     * @Override public void addMainframeStep(PdfPTable[] screenshot) {
     * contentPDF.addMainframeStep(screenshot);
     *
     * }
     */
    @Override
    public void addText(String description, String fontName, float size, int style, BaseColor color) {
        contentPDF.addText(description, fontName, size, style, color);
    }

    @Override
    public void addText(String description) {
        contentPDF.addText(description, FontFactory.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
    }

    @Override
    public void save(boolean isPassed, String[] versions) {
        save(path, isPassed, versions);
    }

    @Override
    public void save(boolean isPassed) {
        save(path, isPassed);
    }

    private void save(String path, boolean isPassed, String[] versions) {
        try {

            OutputStream output = new FileOutputStream(path);
            this.automationType(versions);
            capa.setStatus(isPassed);
            document.close();
            ReportManager.addEvidence(Paths.get(path));

        } catch (IOException e) {
            throw new ReportException(e);
        }
    }

    private void save(String path, boolean isPassed) {
        try {
            capa.setStatus(isPassed);
            document.getPageNumber();
            document.close();
            ReportManager.addEvidence(Paths.get(path));
        } catch (IOException e) {
            throw new ReportException(e);
        }
    }

    @Override
    public void automationType(String[] version) {
        StringBuilder strAutomationType = new StringBuilder();
        // strAutomationType.append("Automação:");
        for (int i = 0; i < version.length; i++) {
            strAutomationType.append((i == 0 ? " " : "\n, ") + "[" + version[i] + "]");
        }
        // capa.getDescText().addText(new Phrase(strAutomationType.toString()));
        try {
            capa.getDescText().go();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public Path getPath() {
        return ReportManager.getFullPath();
    }

    public static byte[] takeScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
