package com.orientaçãoobjetos.entity;

public class Coordenador extends Funcionario {

    public Coordenador(int id, String nome) {
        super(id, nome);
    }

    @Override
    public boolean batePonto() {
        return true;
    }

    @Override
    public int limiteHoraExtra() {
        return 5;
    }
}