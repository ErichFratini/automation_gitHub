package pageobjects;

import org.openqa.selenium.By;
import hooks.Hooks;

import static webdriver.WebElementUtils.*;

public class LoginPage extends Hooks {

    private static By bntTryGitlabForFree = By.xpath("//a[contains(text(),'Try GitLab for FREE')]");
    private static By btnSignIn = By.xpath("(//a[contains(text(),'Sign in')])[1]");

    public void login() {
        reportPDF.addStep("Entrando na tela de login", driver);
        driver.get("https://gitlab.com/");
        reportPDF.addStep("Clicando no botao SignIn", driver);
        click(btnSignIn);
        waitForPageLoaded();
    }

    public void realizarLogin(String string, String string2) {
        sendKeys(By.id("user_login"), string);
        sendKeys(By.id("user_password"), string2);
        reportPDF.addStep("Dados inseridos, clicando no botao de login", driver);
        click(By.name("commit"));
    }

    public void validarPaginaCarregada() {
        waitForPageLoaded();
        reportPDF.addStep("Login efetuado com sucesso", driver);
    }

}
