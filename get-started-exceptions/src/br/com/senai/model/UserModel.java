package br.com.senai.model;

import java.time.LocalDate;
import java.util.Objects;

public class UserModel {
    private long id;
    private String nome;
    private String email;
    private LocalDate birthday;

    public UserModel(long id, String nome, String email, LocalDate birthday) {
        this.birthday = birthday;
        this.email = email;
        this.nome = nome;
        this.id = id;
    }

    public UserModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id) && Objects.equals(nome, userModel.nome) && Objects.equals(email, userModel.email) && Objects.equals(birthday, userModel.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, birthday);
    }



}
