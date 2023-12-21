package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aluno extends Pessoa {
    private List<Disciplina> disciplinasAdicionadas;

    public Aluno(String nome, int idade, String endereco, String cpf, String dataNascimento, String matricula, String senha) {
        super(nome, idade, endereco, cpf, dataNascimento, matricula, senha);
        this.disciplinasAdicionadas = new ArrayList<>();
    }

    public double realizarAvaliacao(Disciplina disciplina) {
        if (disciplinasAdicionadas.contains(disciplina)) {
            Random random = new Random();
            double nota = random.nextDouble() * 10; // Gera um número aleatório entre 0 e 10
            disciplina.getNotas().add(nota); // Adiciona a nota à lista de notas da disciplina
            return nota;
        } else {
            System.out.println("O aluno não está matriculado na disciplina " + disciplina.getNomeDisciplina());
            return 0.0; // Retornar 0 em caso de erro.
        }
    }

    public void infoDisciplinas(Disciplina disciplina) {
        System.out.println("Disciplina: " + disciplina.getNomeDisciplina());
        System.out.println("Carga horária: " + disciplina.getCargaHoraria());
        System.out.println("Professor da disciplina: " + disciplina.getNomeProfessor());
    }

    public void addDisciplina(Disciplina disciplina) {
        if (!disciplinasAdicionadas.contains(disciplina)) {
            disciplinasAdicionadas.add(disciplina);
            disciplina.setMaxAluno(1);
            disciplina.matricularAluno(this); // Matricular o professor na disciplina
        } else {
            System.out.println(getNome() + " já está matriculado na disciplina " + disciplina.getNomeDisciplina());
        }
    }
    public void calcularMedia(Disciplina disciplina) {
        String media = disciplina.calcularMedia();
        System.out.println("Média em " + disciplina.getNomeDisciplina() + ": " + media);
    }
    public void removerDisciplina(Disciplina disciplina) {
        if (disciplinasAdicionadas.contains(disciplina)) {
            disciplinasAdicionadas.remove(disciplina);
            disciplina.desmatricularAluno(this); // Desmatricular o professor da disciplina
            disciplina.setMaxAluno(-1);
            System.out.println(getNome() + " foi removido da disciplina " + disciplina.getNomeDisciplina());
        } else {
            System.out.println(getNome() + " não está matriculado na disciplina " + disciplina.getNomeDisciplina());
        }
    }

    public List<Disciplina> getDisciplinasAdicionadas() {
        return disciplinasAdicionadas;
    }
    public List<Double> getNotasDisciplina(Disciplina disciplina){
    	return disciplina.getNotas();
    }
    @Override
    public String toString() {
        if (getNome() != null) {
            return getNome();
        } else {
            return super.toString(); // Use a representação padrão caso não haja nome definido
        }
    }
   

}
