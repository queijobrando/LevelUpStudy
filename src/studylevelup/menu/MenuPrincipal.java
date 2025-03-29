package studylevelup.menu;

import studylevelup.services.PastaCadastrosService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MenuPrincipal extends Menu {
    public int opcao;

    MenuCadastro menucadastro = new MenuCadastro();
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

    @Override
    public void inserirEntradas(Scanner scanner) {
        do {
            mostrarOpcoes();
            try {

                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> menucadastro.inserirEntradas(scanner);
                    case 2 -> {
                        System.out.print("\nDigite seu usuario: ");
                        String inserirusuario = scanner.nextLine();
                        System.out.print("Digite a senha: ");
                        String inserirsenha = scanner.nextLine();

                        boolean loginSucesso = false;

                        try (BufferedReader br = new BufferedReader(new FileReader(path.getCadastrosPath()))) {
                            String linha;
                            while ((linha = br.readLine()) != null) {
                                String[] espacos = linha.split(",");
                                String nomeUsuario = espacos[3];
                                String senhaUsuario = espacos[4];

                                if (nomeUsuario.equals(inserirusuario) && senhaUsuario.equals(inserirsenha)) {
                                    System.out.println("Senha Correta!");
                                    loginSucesso = true;
                                    break;
                                }
                            }
                            if (loginSucesso) { //se loginsucesso for verdadeiro
                                opcao = 3;
                            } else {
                                System.out.println("Senha Incorreta! Tente novamente!");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    default -> System.out.println("Erro: Insira uma opção válida!");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Erro: Entrada inválida! Digite um número!");
            }
        }while (opcao != 3);
    }
}
