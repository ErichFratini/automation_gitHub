package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pageobjects.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Dado("que eu esteja na tela de login")
    public void que_eu_esteja_na_tela_de_login() {
        loginPage.login();
    }

    @Quando("faço login com o usuario {string} e senha {string}")
    public void faço_login_com_o_usuario_e_senha(String string, String string2) {
        loginPage.realizarLogin(string,string2);
    }

    @Então("sou autenticado com sucesso")
    public void sou_autenticado_com_sucesso() {
        loginPage.validarPaginaCarregada();
    }

    @Dado("que eu esteja no stopots {string}")
    public void queEuEstejaNoStopots(String link) {
        loginPage.goTo(link);
    }
}
