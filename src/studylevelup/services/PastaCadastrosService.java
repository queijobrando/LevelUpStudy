package studylevelup.services;

import java.io.File;
import java.io.IOException;

public class PastaCadastrosService {
    public File cadastrosPath = new File("cadastros.txt");

    public PastaCadastrosService() {
    }

    public File getCadastrosPath() {
        return cadastrosPath;
    }

    public void geraPasta(){
        try {
            File cadastrosPath = new File("cadastros.txt");
            if (cadastrosPath.createNewFile()){
                System.out.println("Banco de dados criado!");
            } else {
                System.out.println("Conexão com Banco de dados OK");
            }
        }
        catch (IOException e){
            System.out.println("Erro ao conectar com banco de dados");
            e.printStackTrace();
        }
    }
}
