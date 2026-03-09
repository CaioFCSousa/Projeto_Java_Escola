# Projeto Java Escola

Projeto desenvolvido em grupo durante o segundo período da faculdade, com o objetivo de aprimorar nossas habilidades em orientação a objetos em Java. Além disso, buscamos fortalecer nossos conhecimentos em lógica de programação e organização de projetos.

---

## Relatórios
- [Relatório do Projeto Escola](https://github.com/CaioFCSousa/Projeto_Java_Escola/files/13745587/Relatorio_Projeto_Escola.pdf)
- [Relatório Individual do Projeto Escola](https://github.com/CaioFCSousa/Projeto_Java_Escola/files/13745601/Relatorio_Individual_Projeto_Escola.pdf)

---

## Descrição Geral
Este projeto é uma aplicação Java para gerenciamento de uma escola, incluindo funcionalidades para alunos, professores, funcionários e gerentes. O sistema possui interface gráfica (GUI) para facilitar o uso.

## Estrutura do Projeto
- **Escola/src/application/**
  - `Aluno.java`: Classe que representa o aluno.
  - `Disciplina.java`: Classe para disciplinas.
  - `Funcionario.java`: Classe para funcionários.
  - `Gerente.java`: Classe para gerentes.
  - `Pessoa.java`: Classe base para pessoas.
  - `Professor.java`: Classe para professores.
- **Escola/src/Layout/**
  - `AlunoGUI.java`: Interface gráfica para alunos.
  - `GerenteGUI.java`: Interface gráfica para gerentes.
  - `LoginGUI.java`: Tela de login.
  - `ProfessorGUI.java`: Interface gráfica para professores.
- **Escola/src/main/**
  - `App.java`: Classe principal para iniciar o sistema.

## Funcionalidades
- Cadastro e gerenciamento de alunos, professores, funcionários e gerentes.
- Controle de disciplinas.
- Interfaces gráficas para facilitar o uso.
- Tela de login para autenticação.

## Como executar
1. Certifique-se de ter o Java instalado (Java 8 ou superior).
2. Compile as classes Java:
   ```shell
   javac Escola/src/main/App.java
   ```
3. Execute o programa:
   ```shell
   java Escola.src.main.App
   ```

## Contribuição
Sinta-se à vontade para contribuir com melhorias, novas funcionalidades ou correções.

## Licença
Este projeto está sob a licença MIT.
