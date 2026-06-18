package com.orientaçãoobjetos.entity;

public class Analista extends Funcionario {

    public Analista(int id, String nome) {
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
