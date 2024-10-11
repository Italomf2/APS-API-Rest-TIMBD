package br.com.minhaapi.projeto.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "nome", length = 200, nullable = true)
    private String nome;
    @Column(name = "email", length = 50, nullable = true)
    private String email;
    @Column(name = "nickname",length = 100,nullable = true)
    private String nickname;
    @Column(name = "senha", nullable = true)
    private String senha;
    @Column(name = "telefone", length = 15, nullable = true)
    private String telefone;

    public Usuario(String nome, String nickname) {
        this.nome = nome;
        this.nickname = nickname;
    }
    public Usuario(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
