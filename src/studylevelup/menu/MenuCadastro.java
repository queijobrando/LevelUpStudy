package studylevelup.menu;

import studylevelup.services.CadastrarUsuarioServices;



import java.util.Scanner;

public class MenuCadastro extends Menu {
    CadastrarUsuarioServices servicoCadastro = new CadastrarUsuarioServices();

    @Override
    public void inserirEntradas(Scanner scanner) {
        System.out.println("\n NOVO CADASTRO:\n");
        servicoCadastro.cadastrarUsuario(scanner);
    }
}
