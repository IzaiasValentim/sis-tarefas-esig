package com.esig.izaiasvalentim.domain.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "USUARIOS")
@Table(name = "USUARIOS")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Primeiro_Nome;
    private String Ultimo_Nome;
    @Column(unique = true, nullable = false)
    private String Email;
    private String Senha;
    @OneToMany(mappedBy = "usuario", orphanRemoval = true)
    private List<Tarefa> Tarefas = new ArrayList<>();

    public Usuario() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getPrimeiro_Nome() {
        return Primeiro_Nome;
    }

    public void setPrimeiro_Nome(String primeiro_Nome) {
        Primeiro_Nome = primeiro_Nome;
    }

    public String getUltimo_Nome() {
        return Ultimo_Nome;
    }

    public void setUltimo_Nome(String ultimo_Nome) {
        Ultimo_Nome = ultimo_Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
