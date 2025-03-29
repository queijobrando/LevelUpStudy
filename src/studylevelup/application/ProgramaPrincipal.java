package studylevelup.application;

import studylevelup.menu.MenuPrincipal;
import studylevelup.services.PastaCadastrosService;

import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuPrincipal chamarMenu = new MenuPrincipal();
        PastaCadastrosService gerarpasta = new PastaCadastrosService();

        System.out.println("-- LEVELUP STUDY --");
        System.out.println("Seja bem vindo(a)!");

        gerarpasta.geraPasta();
        chamarMenu.inserirEntradas(sc);

        System.out.println("Encerrando programa...");
        sc.close();
    }
}
