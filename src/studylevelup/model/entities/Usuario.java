package studylevelup.model.entities;

import java.util.Date;

public class Usuario extends Pessoa{
    private String nickname;
    private String senha;
    private Integer nivel;
    private Integer pontos;

    public Usuario(String nome, String email, Date dataNascimento, String nickname, String senha) {
        super(nome, email, dataNascimento);
        this.nickname = nickname;
        this.senha = senha;
    }

    public Integer getNivel() {
        return nivel;
    }

    public Integer getPontos() {
        return pontos;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSenha() {
        return senha;
    }
}
