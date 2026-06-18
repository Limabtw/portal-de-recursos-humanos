package com.orientaçãoobjetos.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Funcionario {

    protected int id;
    protected String nome;
    protected List<RegistroPonto> registros;

    public Funcionario(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.registros = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<RegistroPonto> getRegistros() {
        return registros;
    }

    public void adicionarRegistro(RegistroPonto registro) {
        registros.add(registro);
    }

    public abstract boolean batePonto();

    public abstract int limiteHoraExtra();

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome +
                " | Cargo: " + this.getClass().getSimpleName();
    }
}
