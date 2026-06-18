package com.orientaçãoobjetos.entity;

public class Estagiario extends Funcionario {

    public Estagiario(int id, String nome) {
        super(id, nome);
    }

    @Override
    public boolean batePonto() {
        return false;
    }

    @Override
    public int limiteHoraExtra() {
        return 0;
    }
}