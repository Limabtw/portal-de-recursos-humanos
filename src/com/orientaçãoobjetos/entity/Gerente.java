package com.orientaçãoobjetos.entity;

public class Gerente extends Funcionario {

    public Gerente(int id, String nome) {
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


