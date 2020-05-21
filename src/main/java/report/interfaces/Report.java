package report.interfaces;

import com.itextpdf.text.BaseColor;

public interface Report {


	public void setCover(String titulo, String objetivo);

	public void addStep(String description, byte[] imagem);

	public void addStep(byte[] imagem);

	public void addStep(String description, String fontName, float size, int style, BaseColor color, byte[] imagem);

	public void addText(String description, String fontName, float size, int style, BaseColor color);

	public void addText(String description);

	public void save(boolean isPassed, String[] versions);

	public void save(boolean isPassed);

	// /**
	// * Salva a evidencia no diretório de execução e põe na capa da evidência o
	// * tipo de automação: web
	// */
	// public void save(boolean isPassed, WebDriver driver);
	//
	// /**
	// * Salva a evidencia no diretório de execução e põe na capa da evidência o
	// * tipo de automação: mainframe
	// */
	// public void save(boolean isPassed, Session3270 session);

	public void automationType(String[] version);

	// public void automationType();

	// public void automationType(WebDriver driver);

	// public void automationType(Session3270 session);

}
