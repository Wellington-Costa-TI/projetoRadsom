package application;

import view.TelaInicial;
import view.TelaLogin;

import java.util.Scanner;

public class ApplicationMain {

   public static void main(String[] args) {
       TelaLogin telaLogin = new TelaLogin();
       TelaInicial telaInicial =  new TelaInicial();
       telaLogin.exibir();
       telaInicial.exibir();

   }
}
