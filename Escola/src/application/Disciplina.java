package application;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nomeDisciplina;
    private double cargaHoraria;
    private int maxAluno;
    private List<Double> notas;
    private String nomeProfessor;
    private List<Aluno> alunosMatriculados;

    public Disciplina(String nomeDisciplina, Professor professor, double cargaHoraria) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new ArrayList<>();
        this.cargaHoraria = cargaHoraria;
        this.nomeProfessor = professor.getNome();
        this.alunosMatriculados = new ArrayList<>(); 
    }

    public String calcularMedia() {
        if (notas.isEmpty()) {
            return ""; // Se não houver notas, a média é zero.
        }

        double soma = 0;

        for (Double nota : notas) {
            // Substitua ',' por '.' e depois converta para double
            String notaString = nota.toString().replace(",", ".");
            soma += Double.parseDouble(notaString);
        }

        return String.format("%.2f", (soma / notas.size()));
    }
    public void matricularAluno(Aluno aluno) {
        if (!alunosMatriculados.contains(aluno)) {
            alunosMatriculados.add(aluno);
        }
    }
    public void desmatricularAluno(Aluno aluno) {
        if (alunosMatriculados.contains(aluno)) {
            alunosMatriculados.remove(aluno);
        }
    }
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getMaxAluno() {
        return maxAluno;
    }

    public void setMaxAluno(int maxAluno) {
        this.maxAluno += maxAluno;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }
    
    @Override
    public String toString() {
        return nomeDisciplina;
    }
    

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }
    
}