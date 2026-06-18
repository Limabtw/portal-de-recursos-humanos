# PortalRH

Sistema de gerenciamento de recursos humanos desenvolvido em Java como projeto acadêmico.

## Funcionalidades

- Cadastro de funcionários
- Consulta de funcionários
- Remoção de funcionários por ID
- Registro de entrada e saída
- Controle de horas extras
- Diferentes tipos de funcionários:
    - Gerente
    - Coordenador
    - Analista
    - Assistente
    - Estagiário

## Regras de Negócio

- Gerentes e estagiários não registram ponto.
- Analistas e assistentes podem realizar até 3 horas extras por dia.
- Coordenadores podem realizar até 5 horas extras por dia.
- O sistema impede registros que ultrapassem os limites definidos.

## Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos (POO)
- Collections (ArrayList)
- LocalDate e LocalTime
- Scanner para entrada de dados