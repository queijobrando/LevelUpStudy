package studylevelup.model.entities;

import studylevelup.services.PastaCadastrosService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public abstract class Pessoa {
    PastaCadastrosService path = new PastaCadastrosService();

    private String nome;
    private String email;
    private Date dataNascimento;

    public Pessoa(){

    }

    public Pessoa(String nome, String email, Date dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String acharNomeBanco(String nome){
        try (BufferedReader br = new BufferedReader(new FileReader(path.getCadastrosPath()))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] espacos = linha.split(",");
                String nomeUsuario = espacos[0];

                if (nomeUsuario.equals(nome)) {
                    return nomeUsuario;

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer getIdade(String nome){
        Date dataAtual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

        String dataFormatada = sdf.format(dataAtual);

        try (BufferedReader br = new BufferedReader(new FileReader(path.getCadastrosPath()))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] espacos = linha.split(",");
                String dataNascimento = espacos[2];
                String nomeUsuario = espacos[0];

                if(nomeUsuario.equals(acharNomeBanco(nome))) {
                    dataNascimento = dataNascimento.substring(dataNascimento.length() - 4);
                    int dataNascimentoNumero = Integer.parseInt(dataNascimento);
                    int dataFormadaNumero = Integer.parseInt(dataFormatada);

                    return dataFormadaNumero - dataNascimentoNumero;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
