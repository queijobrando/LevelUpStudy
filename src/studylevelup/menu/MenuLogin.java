package studylevelup.menu;

import studylevelup.services.PastaCadastrosService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MenuLogin extends Menu {
    PastaCadastrosService path = new PastaCadastrosService();

    public String inserirEntradasLogin(Scanner scanner) {
        System.out.print("\nDigite seu usuario: ");
        String inserirusuario = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String inserirsenha = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path.getCadastrosPath()))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] espacos = linha.split(",");
                String nome = espacos[0];
                String nomeUsuario = espacos[3];
                String senhaUsuario = espacos[4];

                if (nomeUsuario.equals(inserirusuario) && senhaUsuario.equals(inserirsenha)) {
                    System.out.println("Senha Correta!");
                    return nome;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Senha Incorreta! Tente novamente!");
        return null;
    }
}
