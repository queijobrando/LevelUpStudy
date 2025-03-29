package studylevelup.menu;

import studylevelup.services.PastaCadastrosService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MenuPrincipal extends Menu {
    public int opcao;

    MenuCadastro menucadastro = new MenuCadastro();
    MenuLogin menuLogin = new MenuLogin();
    PastaCadastrosService path = new PastaCadastrosService();

    @Override
    public void mostrarOpcoes() {
        System.out.println("""
                \n1.Criar conta
                \n2.Entrar
                \n3.Sair
                """);
        System.out.print("\nInsira a opção: ");
    }

    public String inserirEntradas2(Scanner scanner) {
        do {
            mostrarOpcoes();
            try {

                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> menucadastro.inserirEntradas(scanner);
                    case 2 -> {
                        String usuario = menuLogin.inserirEntradasLogin(scanner);

                        if (usuario != null){
                            System.out.println("Login efetuado com sucesso!");
                            return usuario;
                        }
                    }
                    default -> System.out.println("Erro: Insira uma opção válida!");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Erro: Entrada inválida! Digite um número!");
            }
        }while (opcao != 3);
        return null;
    }
}
