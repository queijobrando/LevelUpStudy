package studylevelup.menu;

import studylevelup.model.entities.Usuario;
import studylevelup.services.PastaCadastrosService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MenuCadastro extends Menu {
    PastaCadastrosService path = new PastaCadastrosService();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void inserirEntradas(Scanner scanner) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path.getCadastrosPath(), true))){
            System.out.print("Qual o seu nome: ");
            String nome = scanner.nextLine();
            System.out.print("Qual o seu email: ");
            String email = scanner.nextLine();
            System.out.print("Qual sua data de nascimento? (dd/mm/yyyy): ");
            Date dataNascimento = sdf.parse(scanner.next());
            scanner.nextLine();
            System.out.print("Crie um login para o seu usuario: ");
            String nickname = scanner.nextLine();
            System.out.print("Crie a senha:");
            String senha = scanner.nextLine();
            Usuario novousuario = new Usuario(nome, email, dataNascimento, nickname, senha);

            bw.write(novousuario.getNome()+","+novousuario.getEmail()+","+novousuario.getDataNascimento()+","+novousuario.getNickname()+","+novousuario.getSenha());
            bw.newLine();
        }
        catch (NumberFormatException e) {
            System.out.println("Erro: Entrada inválida!");
        }
        catch (IOException | ParseException e){
            System.out.println("Erro: Entrada inválida!");
        }
    }
}
