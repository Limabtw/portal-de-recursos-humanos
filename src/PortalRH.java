import com.orientaçãoobjetos.entity.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class PortalRH {

    static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE PONTO =====");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Registrar ponto");
            System.out.println("3 - Listar funcionários");
            System.out.println("4 - Buscar funcionário");
            System.out.println("5 - Remover funcionário");
            System.out.println("6 - Listar registros");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;

                case 2:
                    registrarPonto();
                    break;

                case 3:
                    listarFuncionarios();
                    break;

                case 4:
                    buscarFuncionario();
                    break;

                case 5:
                    removerFuncionario();
                    break;

                case 6:
                    listarRegistros();
                    break;
            }

        } while (opcao != 0);
    }

    static void cadastrarFuncionario() {

        System.out.println("ID:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.println("""
                1-Gerente
                2-Coordenador
                3-Analista
                4-Assistente
                5-Estagiário
                """);

        int tipo = sc.nextInt();

        Funcionario f = null;

        switch (tipo) {
            case 1:
                f = new Gerente(id, nome);
                break;
            case 2:
                f = new Coordenador(id, nome);
                break;
            case 3:
                f = new Analista(id, nome);
                break;
            case 4:
                f = new Assistente(id, nome);
                break;
            case 5:
                f = new Estagiario(id, nome);
                break;
        }

        funcionarios.add(f);
        System.out.println("Funcionário cadastrado.");
    }

    static Funcionario buscarPorId(int id) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id)
                return f;
        }
        return null;
    }

    static void registrarPonto() {

        System.out.println("ID do funcionário:");
        int id = sc.nextInt();

        Funcionario f = buscarPorId(id);

        if (f == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }

        if (!f.batePonto()) {
            System.out.println("Este funcionário não bate ponto.");
            return;
        }

        sc.nextLine();

        System.out.println("Data (AAAA-MM-DD):");
        LocalDate data = LocalDate.parse(sc.nextLine());

        System.out.println("Entrada (HH:MM):");
        LocalTime entrada = LocalTime.parse(sc.nextLine());

        System.out.println("Saída (HH:MM):");
        LocalTime saida = LocalTime.parse(sc.nextLine());

        if (entrada.isBefore(LocalTime.of(6,0))) {
            System.out.println("Entrada antes das 06:00.");
            return;
        }

        if (saida.isAfter(LocalTime.of(22,0))) {
            System.out.println("Saída após 22:00.");
            return;
        }

        if (!saida.isAfter(entrada)) {
            System.out.println("Saída deve ser após a entrada.");
            return;
        }

        long horas = Duration.between(entrada, saida).toHours() - 1;

        double extra = horas - 8;

        if (extra > f.limiteHoraExtra()) {
            System.out.println("Limite de hora extra excedido.");
            return;
        }

        f.adicionarRegistro(new RegistroPonto(data, entrada, saida));

        System.out.println("Ponto registrado.");
    }

    static void listarFuncionarios() {
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
    }

    static void buscarFuncionario() {
        System.out.println("ID:");
        int id = sc.nextInt();

        Funcionario f = buscarPorId(id);

        if (f != null)
            System.out.println(f);
        else
            System.out.println("Não encontrado.");
    }

    static void removerFuncionario() {
        System.out.println("ID:");
        int id = sc.nextInt();

        Funcionario f = buscarPorId(id);

        if (f != null) {
            funcionarios.remove(f);
            System.out.println("Removido.");
        }
    }

    static void listarRegistros() {

        System.out.println("ID:");
        int id = sc.nextInt();

        Funcionario f = buscarPorId(id);

        if (f == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }

        for (RegistroPonto r : f.getRegistros()) {
            System.out.println(r);
        }
    }
}
