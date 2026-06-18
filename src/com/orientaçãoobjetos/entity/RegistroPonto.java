package com.orientaçãoobjetos.entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroPonto {
    private LocalDate data;
    private LocalTime entrada;
    private LocalTime saida;

    public RegistroPonto(LocalDate data, LocalTime entrada, LocalTime saida) {
        this.data = data;
        this.entrada = entrada;
        this.saida = saida;
    }

    public double calcularHorasTrabalhadas() {
        long minutos = Duration.between(entrada, saida).toMinutes();

        // desconta 1 hora de almoço
        minutos -= 60;

        return minutos / 60.0;
    }

    @Override
    public String toString() {
        return "Data: " + data +
                " | Entrada: " + entrada +
                " | Saída: " + saida +
                " | Horas trabalhadas: " + calcularHorasTrabalhadas();
    }
}
