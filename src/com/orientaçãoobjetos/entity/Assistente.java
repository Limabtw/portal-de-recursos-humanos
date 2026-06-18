package com.orientaçãoobjetos.entity;

public class Assistente extends Funcionario {

    public Assistente(int id, String nome) {
        super(id, nome);
    }

    @Override
    public boolean batePonto() {
        return true;
    }

    @Override
    public int limiteHoraExtra() {
        return 3;
    }
}